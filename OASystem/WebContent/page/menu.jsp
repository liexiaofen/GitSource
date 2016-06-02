<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/menu.js"></script>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/menu.css"/>
</head>
<body>
	<div id="left_menu">
		<ul id="nav_dot">
			<c:forEach items="${list}" var="iterator">
		      	<li>
		        	<h4 class="${iterator.remark1}"><span></span>${iterator.resourcename}</h4>
		        	<div class="list-item none">
		        		<c:forEach items="${iterator.list}" var="resource">
				            <a href='<%=request.getContextPath()%>/${resource.resourceaction}' target="mainFrame">${resource.resourcename}</a>
						</c:forEach>
		          	</div>
		        </li>
	        </c:forEach>
        </ul>
	</div>
	<script type="text/javascript">navList();</script> 
</body>
</html>