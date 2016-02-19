<%@ page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA</title>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/top.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/Clock.js"></script>
<script type="text/javascript">
/*
*名       称: img_login()
*输入参数: 无
*输出参数: 无
*机       能: 重新登录
*创 建  者: yuliang          
*创建时间: 2015-10-22
*更 新  者: 
*更新时间: 
*/
function img_login() {
	parent.window.location.href="<%=request.getContextPath()%>/index.jsp";
}
</script>
</head>
<body>
	<div id="top"></div>
	<div id="header">
		<div class="logo">			
	  		<img src="<%=request.getContextPath()%>/resources/images/logo.png" align="middle">&nbsp;联兴集团（上海）公司
		</div>
		<div class="logo1">
			<A href="<%=request.getContextPath()%>/common/message/init.do" target="mainFrame"><IMG src="<%=request.getContextPath()%>/resources/images/mail.gif" align="top" border="0" /></A>
			消息<A href="<%=request.getContextPath()%>/common/message/init.do" target="mainFrame">${command.totalcount}</A>条 
			&nbsp;
			<A href="<%=request.getContextPath()%>/pb001001init.do" target="mainFrame">Home</A>
			&nbsp;
			<A href="" onClick="img_login()">Exit</A>		
		</div>
		<div class="navigation">
			登录者：${sessionScope.user.empname}&nbsp;<SPAN id="clock"></SPAN>		
		</div>
	</div>
	<SCRIPT type=text/javascript>
		var clock = new Clock();
		clock.display(document.getElementById("clock"));
	</SCRIPT>
</body>
</html>