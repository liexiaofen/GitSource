<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
var currentdate='<c:out value="${searchCommand.currentdate}"></c:out>';
/*
*名       称: btn_save()
*输入参数: 无
*输出参数: 无
*机       能: 保存
*创 建  者: yuliang          
*创建时间: 2015-11-03
*更 新  者: 
*更新时间: 
*/
function btn_save() {	
	if ( !$.fn.autovalidateForm("addForm") ){
		return;
	}	
	var eventstarthm = $("#eventstarthm").val();
	var eventendhm = $("#eventendhm").val();
	var eventstart = $("#eventstart").val();
	var eventend = $("#eventend").val();
	if(!checkTimeBgnEndDate( eventstart, eventend, eventstarthm, eventendhm)){
		alert( Message.getString( "MSG_COMM_0012", "日期和时间"));
		return;
	}
	var eventdevicesid = $("#eventdevicesid").val();
	var eventconnectsid = $("#eventconnectsid").val();
	var dailycycle = $("#dailycycle").val();
	var deviceOrderflg = true;
	var dailyConflg = true;
	var flg = true;
	if(eventdevicesid != ""){
		//检查设备是否已被预约		
		$.ajax({
			async: false,
			data:"",
			type:"GET",
			dataType: 'json',
			url:'<%= request.getContextPath()%>/common/ajax/checkDeviceOrder.do?flg='+escape(new Date())+'&eventdevicesid='+escape(eventdevicesid)+'&eventstart='+escape(eventstart)+'&eventend='+escape(eventend)
					+'&eventstarthm='+escape(eventstarthm)+'&eventendhm='+escape(eventendhm)+'&dailycycle='+escape(dailycycle),
			success:function(data){
				if(data.flag){
					var msgid = data.msgid;
					alert(Message.getString( msgid, data.param1)); 
					deviceOrderflg = false;					
				}else{
					deviceOrderflg = true;
				}			
			},
			error:function(data){
				alert(Message.getString("ERROR_COMM_0037")); 
				flg = false;
				return;
			}		
		});
	}
	if(!deviceOrderflg){
		return;
	}
	if(eventconnectsid == ""){
		eventconnectsid = $('input[name="empid"]').val();
	}
	var messageid='';
	var param1='';
	//检查日程是否冲突
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/checkDailyConflict.do?flg='+escape(new Date())+'&eventconnectsid='+escape(eventconnectsid)+'&eventstart='+escape(eventstart)+'&eventend='+escape(eventend)
				+'&eventstarthm='+escape(eventstarthm)+'&eventendhm='+escape(eventendhm)+'&dailycycle='+escape(dailycycle)+'&empid='+escape($('input[name="empid"]').val()),
		success:function(data){
			if(data.flag){
				messageid = data.msgid;
				param1 = data.param1;
				dailyConflg = false;
			}else{
				dailyConflg = true;
			}			
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//系统异常退出
	if(!flg){
		return;
	}
	if(dailyConflg){
		if ( !window.confirm( Message.getString("MSG_IC_COMM_0002"))) 
			return;
	}else{
		if ( !window.confirm( Message.getString(messageid,param1))) 
			return;		
	}
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pb001003save.do");	
	$("#addForm").submit();	
}

function select_changeDaily() {
	var dailycycle = $("#dailycycle").val();
	$('#eventstart').val(currentdate);
	$('#eventend').val(currentdate);
	if(dailycycle == 3){
		//class="input_date Wdate" onclick="WdatePicker()"
		//class="input_date dis_input" 		
		$('#eventstart').removeAttr("class");
		$('#eventstart').attr("class","input_date Wdate");
		$("#eventstart").click(function(){WdatePicker();});
		$('#eventend').removeAttr("class");
		$('#eventend').attr("class","input_date Wdate");
		$("#eventend").click(function(){WdatePicker();});
	}else {			
		$('#eventstart').removeAttr("class");
		$("#eventstart").unbind("click");
		$('#eventstart').attr("class","input_date dis_input");
		$('#eventend').removeAttr("class");
		$("#eventend").unbind("click");
		$('#eventend').attr("class","input_date dis_input");		
	}	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-11-03
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pb001003back.do");	
	$("#addForm").submit();
}
/*
*名       称: btn_deviceListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 设备查询
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_deviceListSearch() {
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchDeviceList.do';
	obj.navi = '日程管理 > 日程安排 > 日程设备一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url, obj);
	if(ret){
		if(ret[0]){
			document.getElementById("eventdevicesid").value = ret[0];
			document.getElementById("eventdevices").value = ret[1];	
		}
	}
}
/*
*名       称: btn_empListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 员工查询
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_empListSearch() {
	c_ShowProgressBar(1);
	var obj = new Object();
	obj.url = 'common/zoom/searchEmpList.do';
	obj.navi = '日程管理 > 日程安排 > 日程参加者一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url, obj);
	if(ret){
		if(ret[0]){
			document.getElementById("eventconnectsid").value = ret[0];
			document.getElementById("eventconnects").value = ret[1];
		}
	}
}
/*
*名       称: btn_deviceOrderSearch()
*输入参数: 无
*输出参数: 无
*机       能: 打开模式窗口
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_deviceOrderSearch() {		
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchDeviceOrderList.do';
	obj.navi = '日程管理 > 日程安排 > 日程设备预约一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url+'?daily='+$('#eventstart').val(), obj);
}

/*
*名       称: btn_clear(obj)
*输入参数: obj
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-12-07
*更 新  者: 
*更新时间: 
*/
function btn_clear(obj) {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		return;
	$(obj).parent().find(":text").each(function(i,n){
		$(n).val('');
	});
	$(obj).parent().find(":hidden").each(function(i,n){
		$(n).val('');
	});
	$(obj).parent().find("textarea").each(function(i,n){
		$(n).val('');
	});
}
</script>
</head>
<body>
<form id="addForm" action="" method="post" >
	<input name="empid" type="hidden"  value="${searchCommand.empid}"/>
	<input name="originateid" type="hidden"  value="${searchCommand.empid}"/>
	<%/*共通隐藏字段 start*/%>
	<input name="pb001001searchcommand.orgcdid" type="hidden"  value="${command.pb001001searchcommand.orgcdid}" />
	<input name="pb001001searchcommand.depid" type="hidden"  value="${command.pb001001searchcommand.depid}" />
	<input name="pb001001searchcommand.empid" type="hidden"  value="${command.pb001001searchcommand.empid}" />
	<input name="pb001001searchcommand.empname" type="hidden"  value="${command.pb001001searchcommand.empname}" />
	<input name="pb001001searchcommand.displaydate" type="hidden"  value="${command.pb001001searchcommand.displaydate}" />
	<%/*共通隐藏字段 end*/%>	 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：日程管理&nbsp;&gt;&nbsp;日程安排&nbsp;&gt;&nbsp;日程安排填写</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						基本信息
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content">
	  <table class="tb_search">
	    <tbody>
	    	<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">定期模式</label>
				</td>
				<td class="td_value" >
					<dict:select id="dailycycle" name="dailycycle" busiDictTypeId="OA_PB001_DailyCycle" cssClass="input_select" nullLabel="请选择" title="required" onChange="select_changeDaily()" value="0"></dict:select>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">事件类型</label>
				</td>
				<td class="td_value" >
					<dict:select id="eventtype" name="eventtype" busiDictTypeId="OA_PB001_EventType" cssClass="input_select" nullLabel="请选择" title="required"></dict:select>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">日期和时间</label>
				</td>
				<td class="td_value">
					<input id="eventstart" name="eventstart" class="input_date dis_input" value="${searchCommand.currentdate}" readonly="readonly" title="required"/>&nbsp;<dict:select id="eventstarthm" name="eventstarthm" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" value="08:30" nullLabel="请选择" title="required"></dict:select>&nbsp;~
					<input id="eventend" name="eventend" class="input_date dis_input" value="${searchCommand.currentdate}" readonly="readonly" title="required"/>&nbsp;<dict:select id="eventendhm" name="eventendhm" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" value="08:30" nullLabel="请选择" title="required"></dict:select>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%"><font color="#ff0000">*</font><label class="message">标题</label></td>
				<td class="td_value">
					<input id="title" name="title" class="input_bigger1" title="required" maxlength="30"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%"><label class="message">设备</label></td>
				<td class="td_value">
					<input id="eventdevices" name="eventdevices" class="input_bigger1" readonly="readonly"/>
					<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_deviceListSearch()" />
					<input name="deviceroder" id="deviceroder" type="button" class="btn" value="设备空闲" onClick="btn_deviceOrderSearch()" />
					<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear(this)">
					<input id="eventdevicesid" name="eventdevicesid" type="hidden" />
				</td>
			</tr>			
			<tr>
				<td class="td_key" width="4%">
					<label class="message">内容</label>
				</td>
				<td class="td_value" >
					<textarea id="comment" name="comment"  class="input_memo_long" maxlength="200"></textarea>	
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<label class="message">参加者</label>
				</td>
				<td class="td_value" >
					<textarea id="eventconnects" name="eventconnects"  class="input_memo_long" readonly="readonly"></textarea>
					<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_empListSearch()"/>
					<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear(this)">
					<input id="eventconnectsid" name="eventconnectsid" type="hidden" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">					
					<input name="search" id="search" type="button" class="btn" value="发&nbsp;布" onClick="btn_save();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>