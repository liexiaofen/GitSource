<%@ page language="java" import="com.lw.oa.common.util.URIUtil"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);	
	String basePath = URIUtil.getURI(request);
%>

<html>
<head>
	<title>OA系统</title>	
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		var contextPath = "<%=request.getContextPath()%>";
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.numberFormat.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.singlevalidate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.autovalidate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common_busi.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/messages.js"></script>
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
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet"	href="<%=request.getContextPath()%>/resources/css/login.css" />
<script type="text/javascript">
/*
*名       称: btn_login()
*输入参数: 无
*输出参数: 无
*机       能: 查询
*创 建  者: yuliang          
*创建时间: 2015-10-22
*更 新  者: 
*更新时间: 
*/
function btn_login() {
	if ( !$.fn.autovalidateForm("loginForm") ){
		return;
	}
	$("#loginForm").attr( "action", "common/login/login.do");	
	$("#loginForm").submit();
}
</script>
</head>
<body>
	<DIV class=login>
		<DIV class=login_logo></DIV>
		<DIV class=login_boder>
			<DIV class=login_padding>
				<br/>
				<br/>
				<form id="loginForm" action="" method="post" >  
					<table>					
						<tr>
							<td><label class="message">用户名</label></td>
							<td><input id="username" name="username" class="input_login" type="text" value="${username}" maxlength="20" title="required" /></td>
						</tr>
						<tr>
							<td><label class="message">密&nbsp;&nbsp;&nbsp;码</label></td>
							<td><input id="password" name="password" class="input_login" type="password" maxlength="20" title="required" /></td>
						</tr>					
						<tr>
							<td><label class="message">机&nbsp;&nbsp;&nbsp;构</label></td>
							<td>
								<dict:select1 id="orgcdid" name="orgcdid" cssClass="input_select" value="${searchCommand.orgcdid}" sqlid="select orgcdid as busidictid,orgshortname as busidictname  from s_organize where deletefg = '0' order by sortno" nullLabel="全部"></dict:select1>
							</td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align: right;"><input id="save" name="save" type="checkbox" value="yes" ${checked} />记住用户名</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: right;">
								<input id="button" name="button" class="login_button" onclick="btn_login()" type="button" value="登录" />
							</td>
						</tr>
					</table>
				</form>	
			</DIV>
		</DIV>
	</DIV>
</body>
</html>
