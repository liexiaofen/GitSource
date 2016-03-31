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
*名       称: btn_applyA4ListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 出差申请列表查询
*创 建  者: yuliang          
*创建时间: 2016-03-30
*更 新  者: 
*更新时间: 
*/
function btn_applyA4ListSearch() {
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchApplyA4List.do';
	obj.navi = '申请管理 > 申请管理 > 出差申请一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url+'?empid='+$('#applyempid').val(), obj);
	if(ret){
		if(ret[0]){
			document.getElementById("sourceid").value = ret[0];
			document.getElementById("sourceapplyno").value = ret[1];	
			document.getElementById("applyreason").value = ret[2];
			document.getElementById("evectionaddress").value = ret[3];	
			document.getElementById("evectionaddressdict").value = ret[4];
			document.getElementById("evectionaddress1").value = ret[5];	
			document.getElementById("evectionaddress2").value = ret[6];
			document.getElementById("evectionconnects").value = ret[7];	
			document.getElementById("evectionstart").value = ret[8];
			document.getElementById("evectionstartdict").value = ret[9];	
			document.getElementById("airplaneflag").value = ret[10];
			document.getElementById("airplaneflagdict").value = ret[11];	
			document.getElementById("applystart").value = ret[12];	
			document.getElementById("applyend").value = ret[13];
			document.getElementById("applystarthm").value = ret[14];	
			document.getElementById("applyendhm").value = ret[15];
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
	document.getElementById("applyreason").value = '';
	document.getElementById("evectionaddress").value = '';
	document.getElementById("evectionaddressdict").value = '';
	document.getElementById("evectionaddress1").value = '';
	document.getElementById("evectionaddress2").value = '';
	document.getElementById("evectionconnects").value = '';
	document.getElementById("evectionstart").value = '';
	document.getElementById("evectionstartdict").value = '';
	document.getElementById("airplaneflag").value = '';
	document.getElementById("airplaneflagdict").value = '';
	document.getElementById("applystart").value = '';
	document.getElementById("applyend").value = '';
	document.getElementById("applystarthm").value = '';
	document.getElementById("applyendhm").value = '';
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post" >
	<input id="applyid" name="applyid" type="hidden"  value="${command.applyid}" />
	<input id="sourceid" name="sourceid" type="hidden" value="${command.sourceid}" />
	<input id="applyempid" name="applyempid" type="hidden"  value="${command.applyempid}" />
	<input name="applytype" type="hidden"  value="${command.applytype}" />
	<input name="checklevel" type="hidden" value="${command.checklevel}" />
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
	<%/*共通隐藏字段 start*/%>
	<input name="searchcommand.empid" type="hidden"  value="${command.searchcommand.empid}" />
	<input name="searchcommand.applyno" type="hidden"  value="${command.searchcommand.applyno}" />
	<input name="searchcommand.applytype" type="hidden"  value="${command.searchcommand.applytype}" />
	<input name="searchcommand.status" type="hidden"  value="${command.searchcommand.status}" />
	<%/*共通隐藏字段 end*/%>
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;申请管理&nbsp;&gt;&nbsp;出差取消申请编辑</span></div>
	<jsp:include page="../../pgcommon/Apply_A5Edit.jsp"></jsp:include>
	<jsp:include page="../../pgcommon/Apply_ResumeEdit.jsp"></jsp:include>
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