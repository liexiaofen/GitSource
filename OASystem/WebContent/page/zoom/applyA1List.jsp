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
*创建时间: 2015-10-21
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
*创建时间: 2015-10-21
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
/*
*名       称: btn_sure()
*输入参数: 无
*输出参数: 无
*机       能: 确认
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_sure()
{
	var obj = $( "input[name='rad']:checked" );
	if ( obj.length < 1 ) {
		alert(Message.getString("MSG_COMM_0007"));
		return;
	}
	var retArray = new Array();
	retArray[0] = '';
	retArray[1] = '';
	retArray[2] = '';
	retArray[3] = '';
	retArray[4] = '';
	retArray[5] = '';
	retArray[6] = '';
	retArray[7] = '';
	retArray[8] = '';
	retArray[9] = '';
	var applyid = $(obj).parent().parent().find('input[name="applyid"]').val();
	var applyno = $(obj).parent().parent().find('input[name="applyno"]').val();
	var vacatereasontype = $(obj).parent().parent().find('input[name="vacatereasontype"]').val();
	var vacatereasontypedict = $(obj).parent().parent().find('input[name="vacatereasontypedict"]').val();
	var otherremark = $(obj).parent().parent().find('input[name="otherremark"]').val();
	var applystart = $(obj).parent().parent().find('input[name="applystart"]').val();
	var applyend = $(obj).parent().parent().find('input[name="applyend"]').val();
	var applystarthm = $(obj).parent().parent().find('input[name="applystarthm"]').val();
	var applyendhm = $(obj).parent().parent().find('input[name="applyendhm"]').val();
	var totalhours = $(obj).parent().parent().find('input[name="totalhours"]').val();
	retArray[0] = applyid;
	retArray[1] = applyno;
	retArray[2] = vacatereasontype;
	retArray[3] = vacatereasontypedict;
	retArray[4] = otherremark;
	retArray[5] = applystart;
	retArray[6] = applyend;
	retArray[7] = applystarthm;
	retArray[8] = applyendhm;
	retArray[9] = totalhours;
	window.returnValue = retArray; 
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
				<td class="td_key" width="8%" nowrap><label class="message">申请单号</label></td>
				<td class="td_value" width="26%">
					<input id="applyno"  name="applyno" class="input_txt" value="${applyno}" maxlength="16" />
					<input name="empid" type="hidden" value="${empid}"/>	
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
		    	<td width="3%"></td>
		    	<td width="3%">&nbsp;序号&nbsp;</td>
				<td width="15%" nowrap>&nbsp;申请单号&nbsp;</td>		
				<td width="15%" nowrap>&nbsp;申请类型&nbsp;</td>
				<td width="15%" nowrap>&nbsp;状态&nbsp;</td>
				<td nowrap >&nbsp;开始日期&nbsp;</td>		
				<td nowrap >&nbsp;结束日期&nbsp;</td>			
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<td align="center" nowrap>
		    				<input name="rad" type="radio" />
		    			</td>
		    			<% num++;%>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap>
							${iterator.applyno}
							<input name="applyid" type="hidden"  value="${iterator.applyid}" />
							<input name="applyno" type="hidden"  value="${iterator.applyno}" />	
							<input name="vacatereasontype" type="hidden"  value="${iterator.vacatereasontype}" />
							<input name="vacatereasontypedict" type="hidden"  value="${iterator.vacatereasontypedict}" />
							<input name="otherremark" type="hidden"  value="${iterator.otherremark}" />
							<input name="applystart" type="hidden"  value="${iterator.applystart}" />
							<input name="applyend" type="hidden"  value="${iterator.applyend}" />
							<input name="applystarthm" type="hidden"  value="${iterator.applystarthm}" />
							<input name="applyendhm" type="hidden"  value="${iterator.applyendhm}" />
							<input name="totalhours" type="hidden"  value="${iterator.totalhours}" />	
						</td>
						<td align="center" nowrap>${iterator.applytypedict}</td>
						<td align="center" nowrap>${iterator.statusdict}</td>
						<td align="center" nowrap>${iterator.applystarttime}</td>	
						<td align="center" nowrap>${iterator.applyendtime}</td>		
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
	<div class="div_result_button">
		<table>
		  <tr>
			<td>			
				 <input name="search" id="search" type="button" class="btn" value="确&nbsp;认" onClick="btn_sure();"/>		
			</td>
		  </tr>
		</table>
  </div>
</c:if>
</body>
</html>