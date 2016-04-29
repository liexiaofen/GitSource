<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
	int num = 0;
%>
<base href="<%=basePath%>">
<script type="text/javascript">
var obj = window.dialogArguments;
var url = obj.url;
var navi = obj.navi;
window.name = "curWindow";
/*
*名       称: btn_search()
*输入参数: 无
*输出参数: 无
*机       能: 查询 
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_search() {	
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", url);	
	$("#queryForm").submit();	
}
/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_reset() {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		return;
	$("#queryForm").find("input[type='text']").val('');
	$("#queryForm").find("select").each(function(i,n){
		$(n).val('');
	});
}
/*
*名       称: btn_close()
*输入参数: 无
*输出参数: 无
*机       能: 关闭
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_close() {
	window.close(); 
}
//初始化全选框
$(function() {
	$('#span1').text(navi);
 });
</script>
</head>
<body>
<form id="queryForm" action="" method="post" target="curWindow"> 
	<div class="div_navi"><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：<span id="span1"></span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						查询条件
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content">
	  <table class="tb_search check_specialchar">
	    <tbody>
			<tr>
				<td class="td_key" width="8%" nowrap><label class="message">机构</label></td>
				<td class="td_value" width="26%">
					<dict:select1 id="orgcdid" name="orgcdid" sqlid="select orgcdid as busidictid,orgshortname as busidictname  from s_organize where deletefg = '0' and regionid = (select regionid from s_organize where orgcdid = '${sessionScope.user.orgcdid}') order by sortno" value="${searchCommand.orgcdid}" cssClass="input_select" nullLabel="全部"></dict:select1>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">预约时间</label></td>					
				<td class="td_value" width="26%">
					<input id="displaydate" name="displaydate" class="input_date Wdate" readonly="readonly" value="${searchCommand.displaydate}" onclick="WdatePicker()" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">设备名称</label></td>
				<td class="td_value" >
					<input id="devicename"  name="devicename" class="input_txt" maxlength="20" value="${searchCommand.devicename}"/>
				</td>
			</tr>	 
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input name="search" id="search" type="button" class="btn" value="关&nbsp;闭" onClick="btn_close();"/>
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>
</form>
<c:if test="${not empty list}">
	<div class="div_result_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%=request.getContextPath()%>/resources/images/m_nav_dian.gif"></td>
					<td class="td_caption">
						查询结果
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_result" id="div_result">  
		<table id="tresult" class="pg_result">
		    <tr class="pg_result_head">
		    	<td width="3%">&nbsp;序号&nbsp;</td>
		    	<td width="7%">&nbsp;设备名称&nbsp;</td>
				<td width="7%">&nbsp; 机构 &nbsp;</td>				
				<td width="12%">&nbsp;预约时间&nbsp;</td>				
				<td width="7%">&nbsp;预约开始时间&nbsp;</td>
				<td width="7%">&nbsp;预约结束时间&nbsp;</td>
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">		    			
		    			<% num++;%>
		    			<td align="center" nowrap><%=num %></td>	
		    			<td align="left" nowrap>${iterator.dailydevicename}</td>					
						<td align="left" nowrap>${iterator.orgshortname}</td>						
						<td align="center" nowrap>${iterator.daily}</td>	
						<td align="center" nowrap>${iterator.eventstarttime}</td>	
						<td align="center" nowrap>${iterator.eventendtime}</td>	
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
</c:if>
<form action="" id="pageform" name="pageform" method="post" target="curWindow">
	<%/*共通隐藏字段 start*/%>
	<input name="orgcdid" type="hidden"  value="${searchCommand.orgcdid}" />
	<input name="displaydate" type="hidden"  value="${searchCommand.displaydate}" />
	<input name="devicename" type="hidden"  value="${searchCommand.devicename}" />
	<input name="pageSize" type="hidden" value="${page.pageSize}"/>
	<input name="curPage" type="hidden" value="${page.curPage}"/>
	<input name="totalPage" type="hidden" value="${page.totalPage}"/>
	<input name="firstPage" type="hidden" value="${page.firstPage}"/>
	<input name="lastPage" type="hidden" value="${page.lastPage}"/>
	<input name="totalRecord" type="hidden" value="${page.totalRecord}"/>
	<%/*共通隐藏字段 end*/%>
	<!--Start Page Infor-->
	<c:if test="${page.totalRecord gt 0}">
		<div class="div_page"> 
			<script type="text/javascript">
				var curPage = $('#pageform').find('input[name="curPage"]').val();
				var totalPage = $('#pageform').find('input[name="totalPage"]').val();
				var firstPage = $('#pageform').find('input[name="firstPage"]').val();
				var lastPage = $('#pageform').find('input[name="lastPage"]').val();
				pagination("page", url,"pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
</body>
</html>