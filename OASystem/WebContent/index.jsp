<%@ page language="java" import="com.lw.oa.common.util.URIUtil"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OA</title>
<script type="text/javascript">
</script>
</head>
<body>
	<% request.getRequestDispatcher("common/login/init.do").forward(request, response); %>
</body>
</html>
