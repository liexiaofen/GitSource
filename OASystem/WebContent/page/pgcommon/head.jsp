<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);	
%>

<html>
<head>
	<title>OA系统</title>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		var contextPath = "<%=request.getContextPath()%>";
	</script>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css"/>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css"/>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/home.css"/>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/tab_style.css"/>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/autovalidate.css"/>
	<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/simpletooltip.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.numberFormat.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.singlevalidate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.autovalidate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common_busi.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common_init.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common_select.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/messages.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/My97DatePicker/WdatePicker.js"></script>
	<c:if test="${not empty searchRetInfo.code}" >		
		<script type="text/javascript">
			$(document).ready( function() {
				var err_msg = '${searchRetInfo.code}';
				alert(Message.getString(err_msg));
			});
		</script>
	</c:if>
	<c:if test="${not empty retInfo.code}" >		
		<script type="text/javascript">
			$(document).ready( function() {
				var err_msg = '${retInfo.code}';
				alert(Message.getString(err_msg));
			});
		</script>
	</c:if>
