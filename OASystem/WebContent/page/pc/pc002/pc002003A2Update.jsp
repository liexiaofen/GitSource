<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_apply()
*输入参数: 无
*输出参数: 无
*机       能: 申请
*创 建  者: yuliang          
*创建时间: 2015-12-23
*更 新  者: 
*更新时间: 
*/
function btn_apply() {	
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}	
	var applystarthm = $("#applystarthm").val();
	var applyendhm = $("#applyendhm").val();
	var applystart = $("#applystart").val();
	var applyend = $("#applyend").val();
	if(!checkTimeBgnEndDate( applystart, applyend, applystarthm, applyendhm)){
		alert( Message.getString( "MSG_COMM_0012", "请假时间"));
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0001"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pc002003update.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_delete()
*输入参数: 无
*输出参数: 无
*机       能: 删除
*创 建  者: yuliang          
*创建时间: 2016-01-12
*更 新  者: 
*更新时间: 
*/
function btn_delete() {	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0003"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pc002003delete.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-09-16
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pc002003back.do");	
	$("#updateForm").submit();
}
/*
*名       称: change_refreshEmp( obj, orgcdid, empselectid)
*输入参数: obj, orgcdid, empselectid
*输出参数: 无
*机       能: 根据部门查询员工
*创 建  者: yuliang          
*创建时间: 2015-12-22
*更 新  者: 
*更新时间: 
*/
function change_refreshEmp( obj, orgcdid, empselectid){
	//获取depid
	var depid = $(obj).val();	
	//获取组织id
	var orgcdid = $('#'+orgcdid).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid)+'&depid='+escape(depid),
		success:function(data){			
			addOptions( data, empselectid, 0);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
}
/*
*名       称: change_refreshDepEmp( obj, depselectid, empselectid, selectindex)
*输入参数: obj, depselectid, empselectid, selectindex
*输出参数: 无
*机       能: 根据组织id查询部门，员工
*创 建  者: yuliang          
*创建时间: 2015-12-18
*更 新  者: 
*更新时间: 
*/
function change_refreshDepEmp( obj, depselectid, empselectid, selectindex){
	//获取orgcdid
	var orgcdid = $(obj).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid),
		success:function(data){			
			addOptions( data, depselectid, selectindex);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取部门经理审核人员列表
	var depid = $('#'+depselectid).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid)+'&depid='+escape(depid),
		success:function(data){			
			addOptions( data, empselectid, 0);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
}
//初始化
$(document).ready(function(){
	//获取部门经理审核部门列表
	var managerorgcdid = $('#managerorgcdid').val();	
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(managerorgcdid),
		success:function(data){			
			addOptions( data, 'managerdepid', '<c:out value="${command.managerdepid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取人事审核部门列表
	var personnelorgcdid = $('#personnelorgcdid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(personnelorgcdid),
		success:function(data){			
			addOptions( data, 'personneldepid', '<c:out value="${command.personneldepid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取副总审核部门列表
	var vicepresiorgcdid = $('#vicepresiorgcdid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(vicepresiorgcdid),
		success:function(data){			
			addOptions( data, 'vicepresidepid', '<c:out value="${command.vicepresidepid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取总经理审核部门列表
	var presiorgcdid = $('#presiorgcdid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(presiorgcdid),
		success:function(data){			
			addOptions( data, 'presidepid', '<c:out value="${command.presidepid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取人事归档审核部门列表
	var personfileorgcdid = $('#personfileorgcdid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(personfileorgcdid),
		success:function(data){	
			addOptions( data, 'personfiledepid', '<c:out value="${command.personfiledepid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取部门经理审核人员列表
	var managerdepid = $('#managerdepid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(managerorgcdid)+'&depid='+escape(managerdepid),
		success:function(data){			
			addOptions( data, 'managercheckid', '<c:out value="${command.managercheckid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取人事审核人员列表
	var personneldepid = $('#personneldepid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(personnelorgcdid)+'&depid='+escape(personneldepid),
		success:function(data){			
			addOptions( data, 'personnelcheckid', '<c:out value="${command.personnelcheckid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取副总审核人员列表
	var vicepresidepid = $('#vicepresidepid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(vicepresiorgcdid)+'&depid='+escape(vicepresidepid),
		success:function(data){			
			addOptions( data, 'vicepresicheckid', '<c:out value="${command.vicepresicheckid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取总经理审核人员列表
	var presidepid = $('#presidepid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(presiorgcdid)+'&depid='+escape(presidepid),
		success:function(data){			
			addOptions( data, 'presicheckid', '<c:out value="${command.presicheckid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	//获取人事归档人员列表
	var personfiledepid = $('#personfiledepid').val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(personfileorgcdid)+'&depid='+escape(personfiledepid),
		success:function(data){			
			addOptions( data, 'personfilecheckid', '<c:out value="${command.personfilecheckid}"></c:out>');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
});
/*
*名       称: btn_applyA1ListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 休假申请列表查询
*创 建  者: yuliang          
*创建时间: 2016-02-23
*更 新  者: 
*更新时间: 
*/
function btn_applyA1ListSearch() {
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchApplyA1List.do';
	obj.navi = '申请管理 > 申请单填写 > 休假申请一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url+'?empid='+$('#applyempid').val(), obj);
	if(ret){
		if(ret[0]){
			document.getElementById("sourceid").value = ret[0];
			document.getElementById("sourceapplyno").value = ret[1];	
			document.getElementById("vacatereasontype").value = ret[2];
			document.getElementById("vacatereasontypedict").value = ret[3];	
			document.getElementById("otherremark").value = ret[4];
			document.getElementById("applystart").value = ret[5];	
			document.getElementById("applyend").value = ret[6];
			document.getElementById("applystarthm").value = ret[7];	
			document.getElementById("applyendhm").value = ret[8];
			document.getElementById("totalhours").value = ret[9];	
		}
	}
}
/*
*名       称: btn_clear()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2016-02-24
*更 新  者: 
*更新时间: 
*/
function btn_clear(obj) {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		return;
	document.getElementById("sourceid").value = '';
	document.getElementById("sourceapplyno").value = '';	
	document.getElementById("vacatereasontype").value = '';
	document.getElementById("vacatereasontypedict").value = '';	
	document.getElementById("otherremark").value = '';
	document.getElementById("applystart").value = '';	
	document.getElementById("applyend").value = '';
	document.getElementById("applystarthm").value = '';	
	document.getElementById("applyendhm").value = '';
	document.getElementById("totalhours").value = '';
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post" >
	<input id="applyid" name="applyid" type="hidden"  value="${command.applyid}" />
	<input id="sourceid" name="sourceid" type="hidden" value="${command.sourceid}" />
	<input id="applyempid" name="applyempid" type="hidden"  value="${command.applyempid}" />
	<input name="applytype" type="hidden"  value="${command.applytype}" />
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
	<%/*共通隐藏字段 start*/%>
	<input name="searchcommand.empid" type="hidden"  value="${command.searchcommand.empid}" />
	<input name="searchcommand.applyno" type="hidden"  value="${command.searchcommand.applyno}" />
	<input name="searchcommand.applytype" type="hidden"  value="${command.searchcommand.applytype}" />
	<input name="searchcommand.status" type="hidden"  value="${command.searchcommand.status}" />
	<%/*共通隐藏字段 end*/%>
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;申请管理&nbsp;&gt;&nbsp;休假取消申请编辑</span></div>
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
				<td class="td_key" width="8%">
					<label class="message">休假取消申请单号</label>
				</td>
				<td class="td_value" width="26%">
					<input name="applyno" class="input_txt dis_input" value="${ command.applyno}" readonly="readonly"/>
				</td>
				<td class="td_key" width="8%">
					<label class="message">休假申请单号</label>
				</td>
				<td class="td_value" width="26%">
					<input id="sourceapplyno" name="sourceapplyno" value="${ command.sourceapplyno}" class="input_txt dis_input" readonly="readonly" />
					<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_applyA1ListSearch()" />
					<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear()" />
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">申请人</label>
				</td>
				<td class="td_value" width="26%">
					<input class="input_txt dis_input" value="${ command.applyempname}" readonly="readonly"/>
				</td>				
				<td class="td_key" width="8%">
					<label class="message">机构</label>
				</td>
				<td class="td_value" colspan="3">
					<input class="input_bigger2 dis_input" value="${ command.orgcddepposes}" readonly="readonly"/>
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">请假事由</label>
				</td>
				<td class="td_value"  width="26%">
					<input id="vacatereasontypedict" name="vacatereasontypedict" value="${ command.vacatereasontypedict}" class="input_txt dis_input" readonly="readonly" title="required"/>
					<input id="vacatereasontype" name="vacatereasontype" type="hidden" value="${ command.vacatereasontype}" />
				</td>
				<td class="td_key" width="8%"><label class="message">其他休假请注明</label></td>
				<td class="td_value" colspan="3">
					<input id="otherremark" name="otherremark" class="input_bigger1 dis_input" maxlength="50" value="${ command.otherremark}"/>
				</td>							
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">请假时间</label>
				</td>
				<td class="td_value" colspan="3">
					<input id="applystart" name="applystart" class="input_short dis_input" value="${command.applystart}" readonly="readonly" title="required"/>&nbsp;<input id="applystarthm" name="applystarthm" value="${command.applystarthm}" class="input_small dis_input" readonly="readonly" title="required" />&nbsp;~
					<input id="applyend" name="applyend" class="input_short dis_input" value="${command.applyend}" readonly="readonly" title="required"/>&nbsp;<input id="applyendhm" name="applyendhm" value="${command.applyendhm}" class="input_small dis_input" readonly="readonly" title="required" />
				</td>
				<td class="td_key" width="8%"><font color="#ff0000">*</font><label class="message">总工时</label></td>
				<td class="td_value" width="26%">
					<input id="totalhours" name="totalhours" class="input_txt dis_input" title='required' maxlength="3" value="${ command.totalhours}" />小时
				</td>								
			</tr>			
			<tr>				
				<td class="td_key" width="8%">
					<label class="message">备注</label>
				</td>
				<td class="td_value" colspan="5">
					休假取消申请需要打印出相应的休假申请，并附在该申请之后交给人事。
				</td>
			</tr>
	    </tbody>
	  </table>
	</div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						路径设置
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content">
	  <table class="tb_search">
	    <tbody>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">部门经理审核</label>
				</td>
				<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
				<td class="td_value" width="15%">
					<select id='managercheckid' name= 'managercheckid' class='input_select'>						
					</select>
				</td>
				<td class="td_key" width="10%">机构</td>
				<td class="td_value" width="15%">
					<dict:select1 id="managerorgcdid" name="managerorgcdid" value="${ command.managerorgcdid}" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'managerdepid', 'managercheckid', 3)"></dict:select1>
				</td>
				<td class="td_key" width="10%"><label class="message">部门</label></td>
				<td class="td_value" >
					<select id='managerdepid' name= 'managerdepid' class='input_select' onchange="change_refreshEmp( this, 'managerorgcdid', 'managercheckid')" >
					</select>
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">人事审核</label>
				</td>
				<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
				<td class="td_value" width="15%">
					<select id='personnelcheckid' name='personnelcheckid' class='input_select' >
					</select>
				</td>
				<td class="td_key" width="10%">机构</td>
				<td class="td_value" width="15%">
					<dict:select1 id="personnelorgcdid" name="personnelorgcdid" value="${ command.personnelorgcdid}" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'personneldepid', 'personnelcheckid', 1)"></dict:select1>
				</td>
				<td class="td_key" width="10%"><label class="message">部门</label></td>
				<td class="td_value">
					<select id='personneldepid' name= 'personneldepid' class='input_select' onchange="change_refreshEmp( this, 'personnelorgcdid', 'personnelcheckid')">
					</select>
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">副总审核</label>
				</td>
				<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
				<td class="td_value" width="15%">
					<select id='vicepresicheckid' name= 'vicepresicheckid' class='input_select' >
					</select>
				</td>
				<td class="td_key" width="10%">机构</td>
				<td class="td_value" width="15%">
					<dict:select1 id="vicepresiorgcdid" name="vicepresiorgcdid" value="${ command.vicepresiorgcdid}" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'vicepresidepid', 'vicepresicheckid', 0)"></dict:select1>
				</td>
				<td class="td_key" width="10%"><label class="message">部门</label></td>
				<td class="td_value" >
					<select id='vicepresidepid' name= 'vicepresidepid' class='input_select' onchange="change_refreshEmp( this, 'vicepresiorgcdid', 'vicepresicheckid')">
					</select>
				</td>				
			</tr>	
			<tr>
				<td class="td_key" width="8%">
					<label class="message">总经理审核</label>
				</td>
				<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
				<td class="td_value" width="15%">
					<select id='presicheckid' name= 'presicheckid' class='input_select' >
					</select>
				</td>
				<td class="td_key" width="10%">机构</td>
				<td class="td_value" width="15%">
					<dict:select1 id="presiorgcdid" name="presiorgcdid" value="${ command.presiorgcdid}" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'presidepid', 'presicheckid', 0)"></dict:select1>
				</td>
				<td class="td_key" width="10%"><label class="message">部门</label></td>
				<td class="td_value">
					<select id='presidepid' name= 'presidepid' class='input_select' onchange="change_refreshEmp( this, 'presiorgcdid', 'presicheckid')">
					</select>
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">人事归档</label>
				</td>
				<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
				<td class="td_value" width="15%">
					<select id='personfilecheckid' name= 'personfilecheckid' class='input_select' >
					</select>
				</td>
				<td class="td_key" width="10%">机构</td>
				<td class="td_value" width="15%">
					<dict:select1 id="personfileorgcdid" name="personfileorgcdid" value="${ command.personfileorgcdid}" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'personfiledepid', 'personfilecheckid', 1)"></dict:select1>
				</td>
				<td class="td_key" width="10%"><label class="message">部门</label></td>
				<td class="td_value">
					<select id='personfiledepid' name= 'personfiledepid' class='input_select' onchange="change_refreshEmp( this, 'personfileorgcdid', 'personfilecheckid')">
					</select>
				</td>				
			</tr>
	    </tbody>
	  </table>
	</div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						目前剩余假期
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content">
	  <table class="tb_search">
	    <tbody>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">法定休假</label>
				</td>
				<td class="td_value">
					<input class="input_txt dis_input" value="${ command.unlegalvctn}" readonly="readonly"/>小时
				</td>
				<td class="td_key" width="8%">
					<label class="message">福利休假</label>
				</td>
				<td class="td_value">
					<input class="input_txt dis_input" value="${ command.unwealvctn}" readonly="readonly"/>小时
				</td>
				<td class="td_key" width="8%">
					<label class="message">加班调休</label>
				</td>
				<td class="td_value">
					<input class="input_txt dis_input" value="${ command.unextraworkvctn}" readonly="readonly"/>小时
				</td>
			</tr>		
	    </tbody>
	  </table>
	</div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark" ><IMG src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></td>
					<td class="td_caption">审核履历</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content" id="div_view_resumes">
		<table class="tb_search">
			<tr>
			  	<td class="td_key" width="8%">审核意见</td>
			  	<td class="td_value"><textarea class="input_memo_lang" name="remark" id="remark"></textarea></td>
			</tr>
			<tr>
				<td class="td_key" width="8%">履历</td>
				<td class="td_value">
					<textarea class="input_memo_lang dis_input"  readonly="readonly">${ command.resume}</textarea>
				</td>
			</tr>
		</table>
	</div>
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td align="right">					
					<input name="search" id="search" type="button" class="btn" value="提&nbsp;交" onClick="btn_apply();"/>
					<input name="search" id="search" type="button" class="btn" value="删&nbsp;除" onClick="btn_delete();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
		</table>
	</div>
</form>
</body>
</html>