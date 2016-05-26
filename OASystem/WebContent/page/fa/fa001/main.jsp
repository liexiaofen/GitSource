<%@ page language="java" contentType="text/html; charset=utf-8" import="com.lw.oa.common.util.URIUtil" 
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
</head>
<FRAMESET border="0" frameSpacing="0" frameBorder="no" cols="15%,*">
	<FRAME id="left" name="left" src="<%=request.getContextPath()%>/page/fa/fa001/ztree.jsp" noResize scrolling="no">
	<FRAME id="right" name="right" src="<%=request.getContextPath()%>/fa001001init.do" scrolling="yes">
</FRAMESET>	
<noframes>
	<body> 
		很抱歉，阁下使用的浏览器不支援框架功能，请转用新的浏览器。 
 	</body>
 </noframes>
</html>
