<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
	int num = 0;
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_search()
*输入参数: 无
*输出参数: 无
*机       能: 查询
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	if(!checkBgnEndDate( $("#entrytimestart").val(), $("#entrytimeend").val())){
		alert( Message.getString( "MSG_COMM_0012", "入职时间"));
		return;
	}
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "pa001001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "pa001001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: link_view( id)
*输入参数: obj
*输出参数: 无
*机       能: Link到明细
*创 建  者: yuliang          
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var empid = $(obj).parent().find('input[name="empid"]').val();
	$("#viewForm").find('input[name="empid"]').val(empid);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pa001001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-09-14
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
</script>
</head>
<body>
<form id="queryForm" action="" method="post" > 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：消息一览</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark"><img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">工作信息</td>
				</tr>
			</tbody>
		</table>	
	</div>
	<div class="div_search_content">
	  <table class="tb_search check_specialchar">
	    <tbody>
			<tr>
				<td class="td_key" width="10%" nowrap><label class="message">审核管理</label></td>
				<td class="td_value" width="23%">
					<c:if test="${command.uncheckcount > 0}">
						<a href="<%= request.getContextPath()%>/pc003001init.do" target="_self">${command.uncheckcount}</a>件
					</c:if>
					<c:if test="${command.uncheckcount == 0}">
						0件
					</c:if>
				</td>
				<td class="td_key" width="10%" nowrap><label class="message">人事归档</label></td>
				<td class="td_value">
					<c:if test="${command.unpersonfilecheckcount > 0}">
						<a href="<%= request.getContextPath()%>/pc004001init.do" target="_self">${command.unpersonfilecheckcount}</a>件
					</c:if>
					<c:if test="${command.unpersonfilecheckcount == 0}">
						0件
					</c:if>
				</td>
			</tr> 
	    </tbody>
	  </table>
	</div>
</form>
</body>
</html>