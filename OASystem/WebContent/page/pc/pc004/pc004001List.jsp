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
*创建时间: 2015-12-29
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "pc004001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: link_view( id)
*输入参数: obj
*输出参数: 无
*机       能: Link到明细
*创 建  者: yuliang          
*创建时间: 2015-12-29
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var applyid = $(obj).parent().find('input[name="applyid"]').val();
	var exclusivefg = $(obj).parent().find('input[name="exclusivefg"]').val();
	var applytype_result = $(obj).parent().find('input[name="applytype_result"]').val();
	$("#viewForm").find('input[name="applyid"]').val(applyid);
	$("#viewForm").find('input[name="exclusivefg"]').val(exclusivefg);
	$("#viewForm").find('input[name="applytype_result"]').val(applytype_result);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "pc004001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_file()
*输入参数: 无
*输出参数: 无
*机       能: 归档
*创 建  者: yuliang          
*创建时间: 2015-12-30
*更 新  者: 
*更新时间: 
*/
function btn_file(){
	var obj = $( "input[name='chk']:checked" );
	if ( obj.length < 1 ) {
		alert(Message.getString("MSG_COMM_0031"));
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_PD005_0001"))) 
		return;
	$("#div_result").find("input[name='chk']:checked").each(function( i, n){			
		var applyid = $(n).parent().find('input[name="applyid"]').val();
		var exclusivefg = $(n).parent().find('input[name="exclusivefg"]').val();
		$("#fileForm").append("<input name=\"applyform["+i+"].applyid\" value=\""+applyid+"\" type=\"hidden\" />");
		$("#fileForm").append("<input name=\"applyform["+i+"].exclusivefg\" value=\""+exclusivefg+"\" type=\"hidden\" />");
	});
	c_ShowProgressBar(); 
	$("#fileForm").attr( "action", "pc004001file.do");	
	$("#fileForm").submit();
}
/*
*名       称: btn_fileGenerate()
*输入参数: 无
*输出参数: 无
*机       能: 文件生成
*创 建  者: yuliang          
*创建时间: 2016-1-7
*更 新  者: 
*更新时间: 
*/
function btn_fileGenerate(){
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0022"))) 
		return;	
	c_ShowProgressBar(3); 
	//获取empid
	var empid = '<c:out value="${sessionScope.user.empid}"/>';
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/applyFileGenerate.do?flg='+escape(new Date())+'&empid='+escape(empid),
		success:function(data){		
			if(data.flag == true){
				var msgid = data.msgid;
				alert(Message.getString(msgid)); 
			}else{
				alert(Message.getString("MSG_COMM_0043"));
			}			
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
}

/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-12-29
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
	//初始化全选框
    $("#checkAll").click(function() {
         $('input[name="chk"]').attr("checked",this.checked); 
     });
     var $chk = $("input[name='chk']");
     $chk.click(function(){
         $("#checkAll").attr("checked",$chk.length == $("input[name='chk']:checked").length ? true : false);
     });
});
</script>
</head>
<body>
<form id="queryForm" action="" method="post" > 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;人事归档&nbsp;&gt;&nbsp;人事归档一览</span></div>
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
					<input id="applyno"  name="applyno" class="input_txt" value="${searchCommand.applyno}" maxlength="16" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">申请单</label></td>
				<td class="td_value" width="26%">
					<dict:select id="applytype" name="applytype" value="${searchCommand.applytype}" busiDictTypeId="OA_PC001_ApplyType" cssClass="input_select" nullLabel="全部"></dict:select>
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">状态</label></td>					
				<td class="td_value" >
					<dict:select id="status" name="status" value="${searchCommand.status}" busiDictTypeId="OA_PC004_Status" cssClass="input_select" nullLabel="全部"></dict:select>
				</td>
			</tr>	 
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询"  onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空"  onClick="btn_reset();"/>
					<input name="check" id="check" type="button" class="btn" value="文件生成"  onClick="btn_fileGenerate()" />  
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
		    	<td width="3%"><c:if test="${ searchCommand.status ne 6 && searchCommand.status ne 7}"><input type="checkbox" name="checkAll" id="checkAll" value='abc'/></c:if></td>
				<td width="3%">&nbsp;序号&nbsp;</td>
				<td width="15%" nowrap>&nbsp;申请单号&nbsp;</td>		
				<td width="15%" nowrap>&nbsp;申请类型&nbsp;</td>
				<td width="15%" nowrap>&nbsp;申请人&nbsp;</td>
				<td width="15%" nowrap>&nbsp;状态&nbsp;</td>
				<td width="15%" nowrap>&nbsp;处理人&nbsp;</td>
				<td nowrap >&nbsp;处理日期&nbsp;</td>
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<% num++;%>
		    			<td align="center" nowrap>
		    				<c:if test="${ iterator.status eq 5}">
		    					<input type="checkbox" name="chk" />
		    					<input name="applyid" value="${ iterator.applyid}" type="hidden" />
		    					<input name="exclusivefg" value="${ iterator.exclusivefg}" type="hidden" />
		    				</c:if>
		    			</td>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap>
							<a href="#" onclick="javascript:link_view(this);return false;">${iterator.applyno}</a>
							<input name="applyid" type="hidden"  value="${iterator.applyid}" />
							<input name="exclusivefg" type="hidden"  value="${iterator.exclusivefg}" />						
							<input name="applytype_result" type="hidden"  value="${iterator.applytype}" />
							<input name="status" type="hidden"  value="${iterator.status}" />
						</td>
						<td align="center" nowrap>${iterator.applytypedict}</td>
						<td align="left" nowrap>${iterator.applyempname}</td>
						<td align="center" nowrap>${iterator.statusdict}</td>
						<td align="left" nowrap>${iterator.processempname}</td>
						<td align="center" nowrap>${iterator.processtime}</td>
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
	<div class="div_result_button">
		<table>
			<tr>
				<td>
					<input name="check" id="check" type="button" class="btn" onClick="btn_file()"  value="归&nbsp;档" />
				</td>
			</tr>
		</table>
	</div>
</c:if>
<form action="pc004001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="empid" type="hidden"  value="${searchCommand.empid}" />
	<input name="applyno" type="hidden"  value="${searchCommand.applyno}" /> 
	<input name="applytype" type="hidden"  value="${searchCommand.applytype}" />
	<input name="status" type="hidden"  value="${searchCommand.status}" />
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
				pagination("page", "pc004001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<%-- 详情表单开始  --%>
<form action="pc004001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="empid" type="hidden"  value="${searchCommand.empid}" />
	<input name="applyno" type="hidden"  value="${searchCommand.applyno}" /> 
	<input name="applytype" type="hidden"  value="${searchCommand.applytype}" />
	<input name="status" type="hidden"  value="${searchCommand.status}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="applyid" type="hidden"  />
	<input name="exclusivefg" type="hidden"  />						
	<input name="applytype_result" type="hidden" />
</form>
<%-- 详情表单结束  --%>
<form action="pc004001file.do" id="fileForm" name="fileForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="empid" type="hidden"  value="${searchCommand.empid}" />
	<input name="applyno" type="hidden"  value="${searchCommand.applyno}" /> 
	<input name="applytype" type="hidden"  value="${searchCommand.applytype}" />
	<input name="status" type="hidden"  value="${searchCommand.status}" />
	<%/*共通隐藏字段 end*/%>	
	
</form>
</body>
</html>