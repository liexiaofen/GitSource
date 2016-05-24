<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
	int num = 0;
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_search()
*输入参数: 无
*输出参数: 无
*机       能: 查询
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	if(!checkBgnEndDate( $("#entrytimestart").val(), $("#entrytimeend").val())){
		alert( Message.getString( "MSG_COMM_0012", "入职时间"));
		return;
	}
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "pa001001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "pa001001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: link_view( obj)
*输入参数: obj
*输出参数: 无
*机       能: Link到明细
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var empid = $(obj).parent().find('input[name="empid"]').val();
	$("#viewForm").find('input[name="empid"]').val(empid);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pa001001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_reset() {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		return;
	$("#queryForm").find("input[type='text']").val('');
	$("#queryForm").find("select").each(function(i,n){
		$(n).val('');
	});
}
$(document).ready(function() {
	$("#body_result").find(".divtop").each(function( i, n){
		$(n).click(function (event){ 
			$('#divtop').slideUp('slow');
			//取消事件冒泡    
			event.stopPropagation();    
			//设置弹出层的位置    
			var offset = $(event.target).offset();    
			$(n).find('#divtop').css({ top: offset.top+$(event.target).height()+"px", left: offset.left});    
			  //按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。    
			$(n).find('#divtop').toggle('slow'); 
		});		
	});  
	
	$("#body_result").find(".divtop").each(function( i, n){
		$(n).mouseout(function (event){ 
			$(n).find('#divtop').fadeOut(1000);
			//$('#divtop').slideUp('slow');
		});		
	});/*
	//点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。    
    $(document).click(function (event){ 
    	$('#divtop').slideUp('slow');
    	//$(this).fadeOut(1000);
    });*/
	/*
    $('#divtop').click(function (event){
    	$(this).slideUp('slow');
    });*/
	//获取regionid
	var regionid = $('#regionid').val();
    //通过区域id获取对应的机构列表
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getOrgidsByRegionid.do?flg='+escape(new Date())+'&regionid='+escape(regionid),
		success:function(data){			
			addOptions( data, 'orgcdid', '<c:out value="${searchCommand.orgcdid}"></c:out>', '全部');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
});
/*
*名       称: change_refreshOrgid( obj, orgcdid)
*输入参数: obj, orgcdid
*输出参数: 无
*机       能: 根据regionid查询机构
*创 建  者: yuliang          
*创建时间: 2016-05-18
*更 新  者: 
*更新时间: 
*/
function change_refreshOrgid( obj, orgcdid){
	//获取regionid
	var regionid = $(obj).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:contextPath+'/common/ajax/getOrgidsByRegionid.do?flg='+escape(new Date())+'&regionid='+escape(regionid),
		success:function(data){			
			addOptions( data, orgcdid, '', '全部');
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			return;
		}		
	});
}
</script>
</head>
<body>
<form id="queryForm" action="" method="post" > 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;员工信息&nbsp;&gt;&nbsp;员工信息一览</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark"><img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">查询条件</td>
				</tr>
			</tbody>
		</table>	
	</div>
	<div class="div_search_content">
	  <table class="tb_search check_specialchar">
	    <tbody>
			<tr>
				<td class="td_key" width="8%" nowrap><label class="message">姓名</label></td>
				<td class="td_value" width="26%">
					<input name="empname" class="input_txt" value="${searchCommand.empname}" maxlength="20" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">入职时间</label></td>
				<td class="td_value" width="26%">
					<input id="entrytimestart" name="entrytimestart" class="input_date Wdate" readonly="readonly" value="${searchCommand.entrytimestart}" onclick="WdatePicker()"/>~
					<input id="entrytimeend" name="entrytimeend" class="input_date Wdate" readonly="readonly" value="${searchCommand.entrytimeend}" onclick="WdatePicker()" />
				</td>
		        <td class="td_key" width="8%" nowrap><label class="message">状态</label></td>
		        <td class="td_value">
		        	<dict:select id="status" name="status" value="${searchCommand.status}" busiDictTypeId="OA_PA001_Status" cssClass="input_select" nullLabel="全部"></dict:select>
		        </td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">区域</label>
				</td>
				<td class="td_value">
					<dict:select id="regionid" name="regionid" value="${searchCommand.regionid}" busiDictTypeId="OA_COMMON_Region" cssClass="input_select" nullLabel="全部" onChange="change_refreshOrgid( this, 'orgcdid')"></dict:select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">机构</label></td>
				<td class="td_value" width="26%">
					<select id='orgcdid' name='orgcdid' class='input_select' >
					</select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">部门</label></td>					
				<td class="td_value">
					<dict:select id="depid" name="depid" value="${searchCommand.depid}" busiDictTypeId="OA_COMMON_Department" cssClass="input_select" nullLabel="全部"></dict:select>
				</td>
			</tr>	 
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input name="button" id="login" type="button" class="btn" value="登&nbsp;录" onClick="btn_insert();"> 
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>
</form>
<c:if test="${not empty list}">
	<div class="div_result_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark"><img src="<%=request.getContextPath()%>/resources/images/m_nav_dian.gif"></td>
					<td class="td_caption">
						查询结果
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_result" id="div_result">  
		<table id="tresult" class="pg_result">
		    <tr class="pg_result_head">
		    	<td width="3%">&nbsp;序号&nbsp;</td>
				<td width="10%">&nbsp;姓名&nbsp;</td>
				<td width="15%">&nbsp;职位&nbsp;</td>
				<td width="8%">&nbsp;国内电话&nbsp;</td>						
				<td width="8%">&nbsp;国际电话&nbsp;</td>	
				<!-- <td>&nbsp;机构&nbsp;部门&nbsp;职称&nbsp;</td> -->	
				<td width="8%">&nbsp;SKYPE号&nbsp;</td>	
				<td width="15%">&nbsp;email&nbsp;</td>
				<!-- <td width="7%">&nbsp;分机&nbsp;</td>		
				<td width="7%">&nbsp;直线&nbsp;</td>	-->										
				<td width="8%">&nbsp;在职状况&nbsp;</td>	
				<td width="8%">&nbsp;更新人&nbsp;</td>		
				<td>&nbsp;更新时间&nbsp;</td>
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<% num++;%>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap class="divtop">
							<a href="#" onclick="javascript:link_view(this);return false;">${iterator.empname}</a>
							<input name="empid" type="hidden"  value="${iterator.empid}" />
							<div id="divtop" style="background-color:moccasin; border: solid 1px #5386ac; position:absolute; display:none; width:250px; height:220px; text-align: left;overflow-y:auto;overflow-x:hidden;">
							<c:forEach items="${iterator.listOrg}" var="entity">${entity.orgshortname}&nbsp;${entity.depiddict}&nbsp;${entity.posiddict}<br/></c:forEach>
							</div>
						</td>						
						<td align="left" nowrap>${iterator.posname}</td>
						<td align="left" nowrap>${iterator.domestictel}</td>												
						<td align="left" nowrap>${iterator.internttel}</td>		
						<td align="left" nowrap>${iterator.skypenum}</td>	
						<td align="left" nowrap><c:out value="${iterator.email}" /></td>
						<!-- <td align="left" nowrap>${iterator.extension}</td>	
						<td align="left" nowrap>${iterator.straightline}</td>-->							
						<td align="center" nowrap>${iterator.statusdict}</td>
						<td align="left" nowrap>${iterator.updator}</td>
						<td align="center" nowrap>${iterator.updatetime}</td>						
		    		</tr>
		    		 
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
</c:if>
<form action="pa001001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="empname" type="hidden"  value="${searchCommand.empname}" />
	<input name="entrytimestart" type="hidden"  value="${searchCommand.entrytimestart}" />
	<input name="entrytimeend" type="hidden"  value="${searchCommand.entrytimeend}" />
	<input name="status" type="hidden"  value="${searchCommand.status}" />	
	<input name="regionid" type="hidden"  value="${searchCommand.regionid}" />
	<input name="orgcdid" type="hidden"  value="${searchCommand.orgcdid}" />
	<input name="depid" type="hidden"  value="${searchCommand.depid}" />
	<input name="pageSize" type="hidden" value="${page.pageSize}"/>
	<input name="curPage" type="hidden" value="${page.curPage}"/>
	<input name="totalPage" type="hidden" value="${page.totalPage}"/>
	<input name="firstPage" type="hidden" value="${page.firstPage}"/>
	<input name="lastPage" type="hidden" value="${page.lastPage}"/>
	<input name="totalRecord" type="hidden" value="${page.totalRecord}"/>
	<%/*共通隐藏字段 end*/%>
	<!--Start Page Infor-->
	<c:if test="${page.totalRecord gt 0}">
		<div class="div_page"> 
			<script type="text/javascript">
				var curPage = $('#pageform').find('input[name="curPage"]').val();
				var totalPage = $('#pageform').find('input[name="totalPage"]').val();
				var firstPage = $('#pageform').find('input[name="firstPage"]').val();
				var lastPage = $('#pageform').find('input[name="lastPage"]').val();
				pagination("page", "pa001001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<%-- 员工详情表单开始  --%>
<form action="pa001001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="empname" type="hidden"  value="${searchCommand.empname}" />
	<input name="entrytimestart" type="hidden"  value="${searchCommand.entrytimestart}" />
	<input name="entrytimeend" type="hidden"  value="${searchCommand.entrytimeend}" />
	<input name="status" type="hidden"  value="${searchCommand.status}" />
	<input name="regionid" type="hidden"  value="${searchCommand.regionid}" />
	<input name="orgcdid" type="hidden"  value="${searchCommand.orgcdid}" />
	<input name="depid" type="hidden"  value="${searchCommand.depid}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="empid" type="hidden"  />
</form>
<%-- 员工详情表单结束  --%>
</body>
</html>