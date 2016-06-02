<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mainstructure.css" /> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/maincontent.css" /> 
<!-- Jquery and Jquery UI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.6.custom.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-timepicker-addon.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/redmond/jquery-ui-1.8.1.custom.css" />
<!-- Jquery and Jquery UI -->
<script src="<%=request.getContextPath()%>/resources/js/formValidator/js/jquery.validationEngine.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/formValidator/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/formValidator/css/validationEngine.jquery.css" type="text/css" media="screen" />
<!-- FullCalender -->
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/resources/js/fullcal/css/fullcalendar.css' />
<script type='text/javascript' src='<%=request.getContextPath()%>/resources/js/fullcal/fullcalendar.js'></script>
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
<STYLE type=text/css>
#loading {
	TOP: 0px; RIGHT: 0px
}
.tooltip {
	PADDING-BOTTOM: 25px; PADDING-LEFT: 25px; WIDTH: 160px; PADDING-RIGHT: 25px; DISPLAY: none; BACKGROUND: url(images/black_arrow.png); HEIGHT: 70px; COLOR: #fff; FONT-SIZE: 12px; PADDING-TOP: 25px; z-order: 100
}
</STYLE>
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
	<DIV id=wrap>
		<SCRIPT type=text/javascript>
		
					$(document).ready(function() {
						/*
						$("#reserveformID").validationEngine({
							validationEventTriggers:"keyup blur", 
							openDebug: true
						}) ;
						*/
						$("#start").timepicker({dateFormat:'yy-mm-dd', timeFormat:'hh:mm', hourMin: 5, hourMax: 24, hourGrid: 3, minuteGrid: 15}); 
						$("#end").timepicker({dateFormat:'yy-mm-dd', timeFormat:'hh:mm', hourMin: 5, hourMax: 24, hourGrid: 3, minuteGrid: 15}); 
						
		
						$("#addhelper").hide();		
						var jsonstr = JSON.parse('<c:out value="${command.jsonstr}" escapeXml="false" />');	
						$('#calendar').fullCalendar({
						  header:{
								right: 'prev,next today',
								center: 'title',
								left: 'month,agendaWeek'
						  },
						  theme: true,
						  editable: true,
						  allDaySlot : false,
						  events:  function(start, end , callback){							  
								var events = jsonstr;
								callback(jsonstr);
						  },
						  /*dayClick: function(date, allDay, jsEvent, view) {
									var selectdate = $.fullCalendar.formatDate(date, "yyyy-MM-dd");	
									
									$( "#reservebox" ).dialog({
										autoOpen: false,
										height: 450,
										width: 400,
										title: 'Reserve meeting room on ' + selectdate,
										modal: true,
										position: "center",
										draggable: false,
										beforeClose: function(event, ui) {
												$.validationEngine.closePrompt("#meeting");
												$.validationEngine.closePrompt("#start");
												$.validationEngine.closePrompt("#end");								
										},
										buttons: {
											"close": function() {
												$( this ).dialog( "close" );
											},
											"reserve": function() {				
												if($("#reserveformID").validationEngine({returnIsValid:true})){
													var startdatestr = $("#start").val();
													var enddatestr = $("#end").val();		
													var confid = $("#meeting").val();	
													var repweeks = $("#repweeks").val();	
													if(repweeks==null){
														repweeks=0;
													}
													var startdate =  $.fullCalendar.parseDate(selectdate+"T"+startdatestr); 
													var enddate =  $.fullCalendar.parseDate(selectdate+"T"+enddatestr);
													var schdata = {startdate:startdate, enddate:enddate, confid:confid, repweeks:repweeks};									
												}	
											}
										}
									});
									$( "#reservebox" ).dialog( "open" );
								return false;
						  },*/
						  timeFormat: 'HH:mm{ - HH:mm}',
						  eventClick: function(event) {
								var fstart  = $.fullCalendar.formatDate(event.start, "yyyy/MM/dd HH:mm");
								var fend  = $.fullCalendar.formatDate(event.end, "HH:mm");				  
								var schdata = {sid:event.sid, deleted:1, uid:event.uid};
								
								$( "#reserveinfo" ).dialog({
									autoOpen: false,
									height: 280,
									width: 400,
									modal: true,
									position: "center",
									draggable: false,
									buttons: {
										"close": function() {
											$( this ).dialog( "close" );
										}
									}
								});
																
								if(1==1||2==schdata.uid){
									$("#reserveinfo").dialog("option", "buttons", {
										"Close": function() {
											$( this ).dialog( "close" );
										},
										
										"Cancel the reservation": function() {
											var answer = confirm("Are you sure to cancel the reservation?");
											if(answer){
												identityService.updateScheduleDeleted(schdata, {
														callback:function(data) {
															alert("The reservation was canceled.");
															window.location.reload();
														}		
												});
											}									
										}
									});
								}
								
								var showtopic = '';
								
								if(event.topic.length>15){
									showtopic = event.topic.substring(0, 15) + '...';
								}else{
									showtopic = event.topic;
								}
								
								
								$("#revdesc").html('<div style="font-weight:bold;color:#5383c2;border-bottom: 1px dotted #5383c2; padding: 3px 0px 3px;">'  + showtopic   + "</div>" + '<div style="padding: 10px 0px 3px">'  + '<div style="width:128px;float:left;"><a href="/mrr/images/conf/' + event.confid +  '.jpg">' + event.confname +  '</a><div style="background:#A4C3E3; text-align:center; padding:5px;color:#1d5987;font-weight:bold;font-size:9px"><span style="background:'+ event.confcolor +';width:14px;height:14px;color:#E3E3E3;font-size:10px;position:relative;left:0;top:0;">' + event.confshortname + '</span>&nbsp;'+ event.confname + ' by ' + event.fullname +'</div></div><div style="float:right;width:220px; padding:0px ; margin:0px">' + event.description+ '</div><div style="clear:both"></div></div>');
								
								$( "#reserveinfo" ).dialog( 
									{ title:  fstart + "-" + fend + " " + showtopic }
								);
								
								$( "#reserveinfo" ).dialog( "open" );
								return false;
						  },
						  loading: function(bool) {
								if (bool) $('#loading').show();
								else $('#loading').hide();
						  },
						  /*
						  eventMouseover: function(calEvent, jsEvent, view) {
								var fstart  = $.fullCalendar.formatDate(calEvent.start, "yyyy/MM/dd HH:mm");
								var fend  = $.fullCalendar.formatDate(calEvent.end, "HH:mm");	
								$(this).attr('title', fstart + " - " + fend + " " + calEvent.topic + " : " + calEvent.description);
								$(this).css('font-weight', 'normal');				
								$(this).tooltip({
									effect:'toggle',
									cancelDefault: true
								});
						  },
						  eventMouseout: function(calEvent, jsEvent, view) {
								$(this).css('font-weight', 'normal');
						  },*/
						  eventRender: function(event, element) {
						  	var fstart  = $.fullCalendar.formatDate(event.start, "HH:mm");
							var fend  = $.fullCalendar.formatDate(event.end, "HH:mm");	
							// Bug in IE8
							//element.html('<a href=#>' + fstart + "-" +  fend + '<div style=color:#E5E5E5>' +  event.title + "</div></a>");
						  },/*
						  eventAfterRender : function(event, element, view) {
						  	var fstart  = $.fullCalendar.formatDate(event.start, "HH:mm");
							var fend  = $.fullCalendar.formatDate(event.end, "HH:mm");		
							//element.html('<a href=#><div>Time: ' + fstart + "-" +  fend + '</div><div>Room:' + event.confname + '</div><div style=color:#E5E5E5>Host:' +  event.fullname + "</div></a>");
							
							
							var confbg='';
							if(event.confid==1){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else if(event.confid==2){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else if(event.confid==3){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else if(event.confid==4){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else if(event.confid==5){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else if(event.confid==6){
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}else{
								confbg = confbg + '<span class="fc-event-bg"></span>';
							}
							
							var titlebg =  '<span class="fc-event-conf" style="background:'+  event.confcolor +'">' + event.confshortname + '</span>';
							
							if(event.repweeks>0){
								titlebg = titlebg + '<span class="fc-event-conf" style="background:#fff;top:0;right:15;color:#3974BC;font-weight:bold">R</span>';
							}
							
							if(view.name=="month"){
								var evtcontent = '<div class="fc-event-vert"><a>';
								evtcontent = evtcontent + confbg;
								evtcontent = evtcontent + '<span class="fc-event-titlebg">' +  fstart + " - " +  fend + titlebg + '</span>';
								evtcontent = evtcontent + '<span>Room: ' +  event.confname + '</span>';
								evtcontent = evtcontent + '<span>Host: ' +  event.fullname + '</span>';
								evtcontent = evtcontent + '</a><div class="ui-resizable-handle ui-resizable-e"></div></div>';
								element.html(evtcontent);
							}else if(view.name=="agendaWeek"){
								var evtcontent = '<a>';
								evtcontent = evtcontent + confbg;
								evtcontent = evtcontent + '<span class="fc-event-time">' +  fstart + "-" +  fend + titlebg + '</span>';
								evtcontent = evtcontent + '<span>' +  event.confname + ' by ' + event.fullname + '</span>';
								//evtcontent = evtcontent + '<span>' +  event.fullname + '</span>';
								evtcontent = evtcontent + '</a><span class="ui-icon ui-icon-arrowthick-2-n-s"><div class="ui-resizable-handle ui-resizable-s"></div></span>';
								element.html(evtcontent);						
							}else if(view.name=="agendaDay"){
								var evtcontent = '<a>';
								evtcontent = evtcontent + confbg;
								evtcontent = evtcontent + '<span class="fc-event-time">' +  fstart + " - " +  fend + titlebg + '</span>';
								evtcontent = evtcontent + '<span>Room: ' +  event.confname + '</span>';
								evtcontent = evtcontent + '<span>Host: ' +  event.fullname + '</span>';
								evtcontent = evtcontent + '<span>Topic: ' +  event.topic + '</span>';
								evtcontent = evtcontent + '</a><span class="ui-icon ui-icon-arrow-2-n-s"><div class="ui-resizable-handle ui-resizable-s"></div></span>';
								element.html(evtcontent);								
							}
						  },*/
						  eventDragStart: function( event, jsEvent, ui, view ) {
							ui.helper.draggable("option", "revert", true);
						  },
						  eventDragStop: function( event, jsEvent, ui, view ) {
						  },
						  eventDrop: function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) { 
		
							if(1==1||2==event.uid){
								var schdata = {startdate:event.start, enddate:event.end, confid:event.confid, sid:event.sid};
							}else{
								revertFunc();
							}
							
						  },
						  eventResizeStart:  function( event, jsEvent, ui, view ) {
						  
							//alert('resizing');
						  
						  },
						  eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
		
							if(1==1||2==event.uid){
								var schdata = {startdate:event.start, enddate:event.end, confid:event.confid, sid:event.sid};
		
							}else{
								revertFunc();
							}
		
						  }
		
						});
						
						//goto date function
						if($.browser.msie){
							$("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:1px 3px 2px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
						}else{
							$("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:3px 2px 4px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
						}
						
						$("#selecteddate").datepicker({
							dateFormat:'yy-mm-dd',
							beforeShow: function (input, instant) {  
								setTimeout(
									function () {
										$('#ui-datepicker-div').css("z-index", 15);
									}, 100
								);
							}
						});
										
		
						
						$("#selectdate").click(function() {
							var selectdstr = 	$("#selecteddate").val();	
							var selectdate = $.fullCalendar.parseDate(selectdstr, "yyyy-mm-dd");					
							$('#calendar').fullCalendar( 'gotoDate', selectdate.getFullYear(), selectdate.getMonth(), selectdate.getDate());
						});
						
						
						// conference function
						//$("#calendar .fc-header-left table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" id="selectmeeting"><a><span id="selectdate" class="ui-icon ui-icon-search" style="float: left;padding-left: 5px; padding-top:1px"></span>meeting room</a></div></td><td><span class="fc-header-space"></span></td>');
						
		
						
						
						
					});
		
				
					
					function validate2time(){ 
						//alert("debug");
						
						var cresult = compare2time($("#start").val(), $("#end").val());
						if(cresult==0){
							return false; 
						}else if(cresult==1){ 
							$.validationEngine.closePrompt("#start");
							return true; 
						} 
		
					}
					
				</SCRIPT>
		
		
		<DIV id=calendar></DIV>
		
		<DIV id=reserveinfo title=Details>
		<DIV id=revtitle></DIV>
		<DIV id=revdesc></DIV></DIV>
		<DIV style="DISPLAY: none" id=reservebox title="Reserve meeting room">
		<FORM id="reserveformID" method="post">
		<DIV class=sysdesc>&nbsp;</DIV>
		<DIV class=rowElem><LABEL>meeting room:</LABEL> <!--<input type="text" name="meeting" id="meeting" class="validate[required]">--><SELECT 
		id=meeting class=validate[required] name=meeting></SELECT> </DIV>
		<DIV class=rowElem><LABEL>Repeated weeks:</LABEL> <SELECT id=repweeks 
		name=repweeks> <OPTION selected value=0>Not repeated</OPTION> <OPTION 
		  value=2>1 week</OPTION> <OPTION value=3>2 weeks</OPTION> <OPTION value=4>3 
		  weeks</OPTION> <OPTION value=5>4 weeks</OPTION> <OPTION value=9>8 
		  weeks</OPTION> <OPTION value=17>16 weeks</OPTION> <OPTION value=33>32 
		  weeks</OPTION></SELECT> </DIV>
		<DIV class=rowElem><LABEL>start time:</LABEL> <INPUT id=start 
		class=validate[required,funcCall[validate2time]] name=start> </DIV>
		<DIV class=rowElem><LABEL>end time:</LABEL> <INPUT id=end 
		class=validate[required,funcCall[validate2time]] name=end> </DIV>
		<DIV class=rowElem><LABEL>Title:</LABEL> <INPUT id=title name=title> </DIV>
		<DIV class=rowElem><LABEL>Details:</LABEL> <TEXTAREA id=details rows=3 cols=43 name=details></TEXTAREA> </DIV>
		<DIV class=rowElem> </DIV>
		<DIV class=rowElem> </DIV>
		<DIV id=addhelper class=ui-widget>
		<DIV 
		style="PADDING-BOTTOM: 5px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; PADDING-TOP: 5px" 
		class="ui-state-error ui-corner-all">
		<DIV id=addresult></DIV></DIV></DIV></FORM></DIV></DIV>
		<!-- google and baidu code -->
		<script type="text/javascript">
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-19118450-1']);
		  _gaq.push(['_trackPageview']);
		  (function() {
			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		</script>
		<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fd999331ad5ea0c0930f3aa7c3bda9fc1' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<!-- end of google and baidu code -->
		
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