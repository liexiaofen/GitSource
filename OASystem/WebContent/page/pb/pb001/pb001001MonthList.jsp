<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/fullcalendar.css"/>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/fullcalendar.print.css" media='print'/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/moment.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/fullcalendar.min.js"></script>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
	
	$(document).ready(function() {
		var jsonstr = JSON.parse('<c:out value="${command.jsonstr}" escapeXml="false" />');	
		$('#calendar').fullCalendar({
			defaultDate: '2016-04-12',
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: jsonstr
		});		
	});
	/*
	*名       称: btn_back()
	*输入参数: 无
	*输出参数: 无
	*机       能: 返回
	*创 建  者: yuliang          
	*创建时间: 2015-11-03
	*更 新  者: 
	*更新时间: 
	*/
	function btn_back() {	
		c_ShowProgressBar(); 
		$("#queryForm").attr( "action", "pb001003back.do");	
		$("#queryForm").submit();
	}
</script>
<style>
		body {
			margin: 40px 10px;
			padding: 0;
			font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
			font-size: 14px;
		}
		#calendar {
			max-width: 1000px;
			margin: 0 auto;
		}
	</style>
</head>
<body>
<form id="queryForm" action="" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="pb001001searchcommand.orgcdid" type="hidden"  value="${command.pb001001searchcommand.orgcdid}" />
	<input name="pb001001searchcommand.depid" type="hidden"  value="${command.pb001001searchcommand.depid}" />
	<input name="pb001001searchcommand.empid" type="hidden"  value="${command.pb001001searchcommand.empid}" />
	<input name="pb001001searchcommand.empname" type="hidden"  value="${command.pb001001searchcommand.empname}" />
	<input name="pb001001searchcommand.displaydate" type="hidden"  value="${command.pb001001searchcommand.displaydate}" />
	<input name="pb001001searchcommand.displaycycle" type="hidden"  value="${command.pb001001searchcommand.displaycycle}" />
	<%/*共通隐藏字段 end*/%>	
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：日程管理&nbsp;&gt;&nbsp;日程安排&nbsp;&gt;&nbsp;月预定信息</span></div>
	<div id='calendar'></div>
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td align="right">					
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
		</table>
	</div>
</form>
</body>
</html>