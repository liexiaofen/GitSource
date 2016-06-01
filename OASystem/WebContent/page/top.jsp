<%@ page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA</title>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/top.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/Clock.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.4.min.js"></script>
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
/*
*名       称: getMessageCount
*输入参数: 无
*输出参数: 无
*机       能: 定时获取消息条数
*创 建  者: yuliang          
*创建时间: 2016-04-29
*更 新  者: 
*更新时间: 
*/
function getMessageCount(){
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/getMessageCount.do',
		success:function(data){			
			var count = data.count;
			$('#messagecount').text(count);		
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			return;
		}		
	});
	window.setTimeout(function() {getMessageCount();}, 1000*60*5);
}
function init(){
	getMessageCount();
}
</script>
</head>
<body onload="init()">
	<div id="top"></div>
	<div id="header">
		<div class="logo">			
	  		<img src="<%=request.getContextPath()%>/resources/images/logo.png" align="middle">&nbsp;联兴集团（上海）公司
		</div>
		<div class="logo1">
			<A href="<%=request.getContextPath()%>/common/message/init.do" target="mainFrame"><IMG src="<%=request.getContextPath()%>/resources/images/mail.gif" align="top" border="0" /></A>
			消息<A href="<%=request.getContextPath()%>/common/message/init.do" target="mainFrame"><span id="messagecount">${command.totalcount}</span></A>条 
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