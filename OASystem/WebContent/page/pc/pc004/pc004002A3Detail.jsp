<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-12-29
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#detailForm").attr( "action", "pc004002back.do");	
	$("#detailForm").submit();
}
</script>
</head>
<body>
<form id="detailForm" action="" method="post" >
	<input name="applyid" type="hidden"  value="${command.applyid}" />
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
	<%/*共通隐藏字段 start*/%>
	<input name="searchcommand.empid" type="hidden"  value="${command.searchcommand.empid}" />
	<input name="searchcommand.applyno" type="hidden"  value="${command.searchcommand.applyno}" />
	<input name="searchcommand.applytype" type="hidden"  value="${command.searchcommand.applytype}" />
	<input name="searchcommand.status" type="hidden"  value="${command.searchcommand.status}" />
	<%/*共通隐藏字段 end*/%>	 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;人事归档&nbsp;&gt;&nbsp;加班申请明细</span></div>
	
	<jsp:include page="../../pgcommon/Apply_A3Detail.jsp"></jsp:include>
	<jsp:include page="../../pgcommon/Apply_ResumeDetail.jsp"></jsp:include>
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td align="right">
					<input name="exportExcel" class="btn" type="button" value="导出Excel" onclick="btn_applyFormDownload()" />
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
		</table>
	</div>
</form>
<form action="" id="downloadForm" name="downloadForm" method="POST">
<%/*共通隐藏字段 start*/%>
    <input name="applyid" type="hidden"  value="${command.applyid}" />
    <input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
    <input name="applytype" type="hidden"  value="${command.applytype}" />
<%/*共通隐藏字段 end*/%>
</form>
</body>
</html>