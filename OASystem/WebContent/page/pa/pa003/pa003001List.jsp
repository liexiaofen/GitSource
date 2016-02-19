<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
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
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "pa003001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "pa003001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: link_view( id)
*输入参数: obj
*输出参数: 无
*机       能: Link到明细
*创 建  者: yuliang          
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var legalid = $(obj).parent().find('input[name="legalid"]').val();
	$("#viewForm").find('input[name="legalid"]').val(legalid);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pa003001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-10-22
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
$(document).ready(function(){	
	var dt = '<c:out value="${searchCommand.legalyear}" />';
    var cnt = parseInt(dt) + 2;
    $('select[name="legalyear"]').append("<option value='' >全部</option>");
 	for(var i=dt-1;i<cnt;i++){
	 	if(i==dt){
	 		$('select[name="legalyear"]').append("<option value='" + i +  "'selected>" + i + "</option>");
	 	}else{
	    	$('select[name="legalyear"]').append("<option value='" + i +  "'>" + i + "</option>");
    	}
    }
})
</script>
</head>
<body>
<form id="queryForm" action="" method="post" > 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;法定日信息&nbsp;&gt;&nbsp;法定日信息一览</span></div>
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
				<td class="td_key" width="8%" nowrap><label class="message">年份</label></td>
				<td class="td_value" width="26%">
					<select id="legalyear" name="legalyear" class="input_select">
					</select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">月份</label></td>
				<td class="td_value" width="26%">
					<dict:select id="legalmonth" name="legalmonth" value="${searchCommand.legalmonth}" busiDictTypeId="OA_COMMON_Month" cssClass="input_select" nullLabel="全部"></dict:select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">日期</label></td>
				<td class="td_value" >
					<input id="legaldate" name="legaldate" value="${searchCommand.legaldate}" class="input_date Wdate" readonly="readonly" onclick="WdatePicker()"/>
				</td>
			</tr> 	 
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input name="button" id="login" type="button" class="btn" value="登&nbsp;录" onClick="btn_insert();"> 
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
				<td width="10%">&nbsp;日期&nbsp;</td>
				<td width="10%">&nbsp;星期&nbsp;</td>				
				<td width="10%">&nbsp;周&nbsp;</td>
				<td width="10%">&nbsp;天数&nbsp;</td>
				<td width="10%">&nbsp;是否工作日&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<% num++;%>
		    			<td align="center" nowrap><%=num %></td>
						<td align="center" nowrap>
							<a href="#" onclick="javascript:link_view(this);return false;">${iterator.legaldate}</a>
							<input name="legalid" type="hidden"  value="${iterator.legalid}" />
						</td>
						<td align="left" nowrap>${iterator.dayofweek}</td>
						<td align="left" nowrap>第${iterator.weekofyear}周</td>
						<td align="left" nowrap>第${iterator.dayofyear}天</td>
						<td align="center" nowrap>${iterator.status}</td>
						<td align="left" nowrap></td>
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
</c:if>
<form action="pa003001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="legalyear" type="hidden"  value="${searchCommand.legalyear}" />
	<input name="legalmonth" type="hidden"  value="${searchCommand.legalmonth}" />
	<input name="legaldate" type="hidden"  value="${searchCommand.legaldate}" />
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
				pagination("page", "pa003001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<%-- 详情表单开始  --%>
<form action="pa003001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="legalyear" type="hidden"  value="${searchCommand.legalyear}" />
	<input name="legalmonth" type="hidden"  value="${searchCommand.legalmonth}" />
	<input name="legaldate" type="hidden"  value="${searchCommand.legaldate}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="legalid" type="hidden"  />
</form>
<%-- 详情表单结束  --%>
</body>
</html>