<%@ page language="java" import="com.winsolution.weixin.common.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = URIUtil.getURI(request);
	String baseURI = URIUtil.getPreForwardURI(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>上海微恩索微信考勤系统</title>
<link rel="stylesheet" href="<%=basePath%>css/jquery.mobile-1.4.5.min.css" />
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/jquery.mobile-1.4.5.min.js"></script>

<!--日历引入文件-->
<script src="<%=basePath%>js/jqm-datebox-1.4.5.js" type="text/javascript"></script>
<link href="<%=basePath%>css/jqm-datebox-1.4.5.css" rel="stylesheet" type="text/css" />
<!--日期格式js-->
<!--  <script src="<%=basePath%>js/dateFormate.js"></script>-->
<!--Start 使用日期控件 引入文件-->

<!-- 分页js -->
<script src="<%=basePath%>js/js.js" type="text/javascript"></script>
<script>
	function query_info() {
		$("#form1").submit();
	}
	
	function chkSubmit(){
	
		var startdate = document.getElementById("txtStartDate").value;
		var enddate = document.getElementById("txtEndDate").value;
		
		if(startdate!="" && enddate!=""){
			startdate1 = new Date(Date.parse(startdate));
			enddate1 = new Date(Date.parse(enddate));
			if(startdate1>enddate1){
				alert("结束日期不能小于开始日期，请重新选择！");
				return false;
			}
		}
		
	}


	$(document).ready(function(){
		//获取当前日期
		var d = new Date();
		var vYear = d.getFullYear();
		var vMonth = d.getMonth()+1;
		var vDay = d.getDate();
		
		var vdate = vMonth+"/"+vDay+"/"+vYear;
		$("#txtStartDate").val(vdate);
		$("#txtEndDate").val(vdate);
	  }); 
	

	/* $(document).ready(
			function() {
				var currYear = (new Date()).getFullYear();
				var opt = {};
				opt.date = {
					preset : 'date'
				};
				//opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
				opt.datetime = {
					preset : 'datetime'
				};
				opt.time = {
					preset : 'time'
				};
				/*
				opt.default = {
					theme: 'android-ics light', //皮肤样式
					display: 'modal', //显示方式 
					mode: 'scroller', //日期选择模式
					lang:'zh',
					startYear:currYear - 10, //开始年份
					endYear:currYear + 10 //结束年份
				};
				 */
				 /*		$("#txtStartDate1").val('').scroller('destroy')
						.scroller(
								$.extend(opt['date'],
										opt['default']));
				$("#txtEndDate1").val('').scroller('destroy')
						.scroller(
								$.extend(opt['date'],
										opt['default']));

				var vardate = new Date().Format("yyyy-MM-dd");
				$("#txtStartDate1").val(vardate);
				$("#txtEndDate1").val(vardate);
	}); */
</script>

</head>
<body>

	<div id="div_attendRecord" data-role="page">
		<div data-role="header" data-theme="a">
			<!--data-position="fixed"-->
			<h1>考勤记录</h1>
		</div>
		<div data-role="content">
			<form method="post" id="form1" name="form1"  action="<%=baseURI %>#" onsubmit="return chkSubmit();">
				<fieldset data-role="collapsible" data-collapsed="false" data-theme="b">
					<legend>查询条件</legend>
					<div data-role="fieldcontain">
						<fieldset data-role="controlgroup" data-type="horizontal" data-role="fieldcontain">
							<legend>登记类型</legend>
							<input type="radio" name="gender" id="radall" value="radall" <c:if test='${param.gender=="radall" || param.gender==null}'> checked</c:if> />
							<label for="radall">全部</label> 
								<input type="radio" name="gender" id="radsignin" value="radsignin" <c:if test='${param.gender=="radsignin"}'> checked</c:if> /> 
								<label for="radsignin">签到</label> 
									<input type="radio" name="gender" id="radsignout" value="radsignout" <c:if test='${param.gender=="radsignout"}'> checked</c:if> /> 
								<label for="radsignout">签退</label>
						</fieldset>
					</div>

					<div data-role="fieldcontain">
						<label for="lblStartDate">开始日期</label> 
						<input type="text" name="txtStartDate" id="txtStartDate" readonly="true" data-role="datebox" data-options='{"mode":"calbox"}' value="${param.txtStartDate}" />
					</div>
					<div data-role="fieldcontain">
						<label for="lblEndDate">结束日期</label> 
						<input type="text" name="txtEndDate" id="txtEndDate" readonly="true" data-role="datebox" data-options='{"mode":"calbox"}' value="${param.txtEndDate}"/>
					</div>
				</fieldset>
				<input type="submit" data-inline="true" id="btnSearch" data-icon="search" value="查询" />
				<!--Talbe Start -->
				<div id="div_attrecordlist">
					<table data-role="table" id="tab_attrecordlist" data-mode="reflow"
						class="ui-responsive table-stroke">
						<thead>
							<tr>
								<th data-priority="1">序号</th>
								<th>姓名</th>
								<th>签到类型</th>
								<th>登记时间</th>
							</tr>
						</thead>
						<tbody id="tb_data">
							<c:if test="${not empty tempsign_list }">
								<c:forEach items="${tempsign_list }" var="tempsign_list">
									<tr>
										<td>${tempsign_list.rownum}</td>
										<td>${tempsign_list.tempInfo.usrname }</td>
										<td>${tempsign_list.signtype}</td>
										<td>${tempsign_list.msgtime }</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
				<!--Table End-->
				<div align="center" style="clear:all;">${pager}</div>
			</form>
		</div>

		<div data-role="footer" data-theme="a">
			<h2>@版权所有&nbsp;&nbsp;&nbsp;上海微恩索软件技术有限公司</h1>
		</div>
	</div>
</body>
</html>