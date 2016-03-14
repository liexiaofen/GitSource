<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_agree()
*输入参数: 无
*输出参数: 无
*机       能: 同意
*创 建  者: yuliang          
*创建时间: 2015-12-23
*更 新  者: 
*更新时间: 
*/
function btn_agree() {	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0015"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pc003003agree.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_reject()
*输入参数: 无
*输出参数: 无
*机       能: 驳回
*创 建  者: yuliang          
*创建时间: 2015-12-23
*更 新  者: 
*更新时间: 
*/
function btn_reject() {	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0016"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pc003003reject.do");	
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
	$("#updateForm").attr( "action", "pc003003back.do");	
	$("#updateForm").submit();
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post" >
	<input name="empid" type="hidden"  value="${sessionScope.user.empid}" />
	<input name="status" type="hidden" value="${command.status}" />
	<input name="checklevel" type="hidden" value="${command.checklevel}" />
	<input name="applyid" type="hidden"  value="${command.applyid}" />
	<input name="applyempid" type="hidden"  value="${command.applyempid}" />
	<input name="applytype" type="hidden"  value="${command.applytype}" />
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
	<%/*共通隐藏字段 start*/%>
	<input name="searchcommand.empid" type="hidden"  value="${command.searchcommand.empid}" />
	<input name="searchcommand.applyid" type="hidden"  value="${command.searchcommand.applyid}" />
	<input name="searchcommand.applyno" type="hidden"  value="${command.searchcommand.applyno}" />
	<input name="searchcommand.applytype" type="hidden"  value="${command.searchcommand.applytype}" />
	<input name="searchcommand.statusalias" type="hidden"  value="${command.searchcommand.statusalias}" />
	<%/*共通隐藏字段 end*/%>
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;审核管理&nbsp;&gt;&nbsp;休假申请审核</span></div>
	<jsp:include page="../../pgcommon/Apply_A1Detail.jsp"></jsp:include>
	<jsp:include page="../../pgcommon/Apply_ResumeEdit.jsp"></jsp:include>
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td align="right">
					<input name="agree" id="agree" type="button" class="btn" value="同&nbsp;意" onClick="btn_agree()"/>
					<input name="reject" id="reject" type="button" class="btn" value="驳&nbsp;回" onClick="btn_reject()"/>
					<input name="back" id="back" type="button" class="btn" value="返&nbsp;回" onClick="btn_back()" />
				</td>
	      	</tr>
		</table>
	</div>
</form>
</body>
</html>