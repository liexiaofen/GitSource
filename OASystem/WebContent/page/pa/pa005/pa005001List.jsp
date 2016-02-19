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
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "pa005001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "pa005001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: link_view( id)
*输入参数: obj
*输出参数: 无
*机       能: Link到明细
*创 建  者: yuliang          
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var empid = $(obj).parent().find('input[name="empid"]').val();
	var year = $(obj).parent().find('input[name="year"]').val();
	var exclusivefg = $(obj).parent().find('input[name="exclusivefg"]').val();
	$("#viewForm").find('input[name="empid"]').val(empid);
	$("#viewForm").find('input[name="detailyear"]').val(year);
	$("#viewForm").find('input[name="exclusivefg"]').val(exclusivefg);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pa005001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_edit()
*输入参数: 无
*输出参数: 无
*机       能: 编辑
*创 建  者: yuliang          
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function btn_edit(){
	var obj = $( "input[name='rad']:checked" );
	if ( obj.length < 1 ) {
		alert(Message.getString("MSG_COMM_0007"));
		return;
	}
	var empid = $(obj).parent().parent().find('input[name="empid"]').val();
	var year = $(obj).parent().parent().find('input[name="year"]').val();
	var exclusivefg = $(obj).parent().parent().find('input[name="exclusivefg"]').val();
	$("#viewForm").find('input[name="empid"]').val(empid);
	$("#viewForm").find('input[name="detailyear"]').val(year);
	$("#viewForm").find('input[name="exclusivefg"]').val(exclusivefg);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pa005001edit.do");	
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
	var dt = '<c:out value="${searchCommand.year}" />';
    var cnt = parseInt(dt) + 2;
    $('select[name="year"]').append("<option value='' >全部</option>");
 	for(var i=dt-1;i<cnt;i++){
	 	if(i==dt){
	 		$('select[name="year"]').append("<option value='" + i +  "'selected>" + i + "</option>");
	 	}else{
	    	$('select[name="year"]').append("<option value='" + i +  "'>" + i + "</option>");
    	}
    }
})
</script>
</head>
<body>
<form id="queryForm" action="" method="post" > 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;年假信息&nbsp;&gt;&nbsp;年假信息一览</span></div>
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
					<select id="year" name="year" class="input_select">
					</select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">员工姓名</label></td>
				<td class="td_value" >
					<input id="empname" name="empname" value="${searchCommand.empname}" class="input_txt" readonly="readonly" />
				</td>
			</tr> 	 
			<tr>
				<td colspan="6" align="right">					
					<input id="search" name="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input id="reset" name="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input id="insert" name="insert" type="button" class="btn" value="年假生成" onClick="btn_insert();"> 
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
				<td width="10%">&nbsp;员工姓名&nbsp;</td>
				<td width="6%">&nbsp;年份&nbsp;</td>
				<td width="13%">&nbsp;法定休假&nbsp;</td>
				<td width="13%">&nbsp;福利休假&nbsp;</td>				
				<td width="13%">&nbsp;加班调休&nbsp;</td>
				<td width="13%">&nbsp;未休法定休假&nbsp;</td>
				<td width="13%">&nbsp;未休福利休假&nbsp;</td>
				<td width="13%">&nbsp;未休加班调休&nbsp;</td>
			</tr>
			<tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">		    			
		    			<% num++;%>
		    			<td align="center" nowrap><input name="rad" type="radio" /></td>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap>
							<a href="#" onclick="javascript:link_view(this);return false;">${iterator.empname}</a>
							<input name="empid" type="hidden"  value="${iterator.empid}" />
							<input name="year" type="hidden"  value="${iterator.year}" />
							<input name="exclusivefg" type="hidden"  value="${iterator.exclusivefg}" />
						</td>
						<td align="left" nowrap>${iterator.year}</td>
						<td align="left" nowrap>${iterator.legalvctn}小时</td>
						<td align="left" nowrap>${iterator.wealvctn}小时</td>
						<td align="left" nowrap>${iterator.extraworkvctn}小时</td>
						<td align="left" nowrap>${iterator.unlegalvctn}小时</td>
						<td align="left" nowrap>${iterator.unwealvctn}小时</td>
						<td align="left" nowrap>${iterator.unextraworkvctn}小时</td>
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
	<div class="div_result_button">
		<table >
			<tr>
				<td>
				 	<input name="edit" id="edit" type="button" class="btn" onClick="btn_edit()" value="编&nbsp;辑"> 
				</td>
			</tr>
		</table>
	</div>
</c:if>
<form action="pa005001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="year" type="hidden"  value="${searchCommand.year}" />
	<input name="empname" type="hidden"  value="${searchCommand.empname}" />
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
				pagination("page", "pa005001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<%-- 详情表单开始  --%>
<form action="pa005001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="year" type="hidden"  value="${searchCommand.year}" />
	<input name="empname" type="hidden"  value="${searchCommand.empname}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="empid" type="hidden"  />
	<input name="detailyear" type="hidden"  />
	<input name="exclusivefg" type="hidden"  />
</form>
<%-- 详情表单结束  --%>
</body>
</html>