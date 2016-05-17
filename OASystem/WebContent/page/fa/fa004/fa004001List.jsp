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
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function btn_search() {
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "fa004001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "fa004001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: btn_edit( obj)
*输入参数: obj
*输出参数: 无
*机       能: 编辑按钮按下，跳转到编辑画面
*创 建  者: yuliang          
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function btn_edit( obj){
	var busidicttypeid = $(obj).parent().parent().find('input[name="busidicttypeid"]').val();
	var busidicttypename = $(obj).parent().parent().find('input[name="busidicttypename"]').val();
	$("#editForm").find('input[name="id"]').val(busidicttypeid);
	$("#editForm").find('input[name="name"]').val(busidicttypename);
	c_ShowProgressBar(); 
	$('#editForm').attr( "action", "fa004001edit.do");	
	$('form[name="editForm"]').submit();
}
/*
*名       称: link_view( obj)
*输入参数: obj
*输出参数: 无
*机       能: 编辑按钮按下，跳转到明细画面
*创 建  者: yuliang          
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var busidicttypeid = $(obj).parent().parent().find('input[name="busidicttypeid"]').val();
	var busidicttypename = $(obj).parent().parent().find('input[name="busidicttypename"]').val();
	$("#viewForm").find('input[name="id"]').val(busidicttypeid);
	$("#viewForm").find('input[name="name"]').val(busidicttypename);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "fa004001view.do");	
	$('form[name="viewForm"]').submit();
}
/*
*名       称: btn_reset()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2016-05-16
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
*名       称: btn_delete()
*输入参数: 无
*输出参数: 无
*机       能: 删除
*创 建  者: yuliang          
*创建时间: 2016-05-12
*更 新  者: 
*更新时间: 
*/
function btn_delete(){
	var obj = $( "input[name='chk']:checked" );
	if ( obj.length < 1 ) {
		alert(Message.getString("MSG_COMM_0031"));
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_PD005_0001"))) 
		return;
	$("#div_result").find("input[name='chk']:checked").each(function( i, n){			
		var busidicttypeid = $(n).parent().find('input[name="busidicttypeid"]').val();
		$("#deleteForm").append("<input name=\"busidicttype["+i+"].busidicttypeid\" value=\""+busidicttypeid+"\" type=\"hidden\" />");
	});
	c_ShowProgressBar(); 
	$("#deleteForm").attr( "action", "fa004001delete.do");	
	$("#deleteForm").submit();
}
/*
*名       称: btn_refreshCache()
*输入参数: 无
*输出参数: 无
*机       能: 刷新缓存
*创 建  者: yuliang          
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function btn_refreshCache(){
	c_ShowProgressBar(); 
	$("#queryForm").attr( "action", "fa004001refreshCache.do");	
	$("#queryForm").submit();
}

/*
*名       称: btn_update()
*输入参数: obj
*输出参数: 无
*机       能: 更新
*创 建  者: yuliang          
*创建时间: 2016-05-17
*更 新  者: 
*更新时间: 
*/
function btn_update(obj){	
	if($(obj).val() == '更新'){		
		var id = $(obj).parent().prev().prev();
		var name = $(obj).parent().prev();
		id.html("<input class=\"input_bigger\" value=\""+$(id).find("a").eq(0).text()+"\" maxlength=\"20\" />");
		name.html("<input class=\"input_bigger\" value=\""+$(name).text()+"\" maxlength=\"50\" />");
		$(obj).val('保存');
	}else{				
		var id = $(obj).parent().prev().prev();
		var name = $(obj).parent().prev();
		var idval = $(id).find("input").val();
		var nameval = $(name).find("input").val()
		if(idval == ''){
			alert( Message.getString( "MSG_COMM_0001", "类型代码"));
			$(id).find("input").focus();
			return;
		}
		if(nameval == ''){
			alert( Message.getString( "MSG_COMM_0001", "类型名称"));
			$(name).find("input").focus();
			return;
		}
		var flg = true;
		//检查类型代码唯一性
		$.ajax({
			async: false,
			data:"",
			type:"GET",
			dataType: 'json',
			url:'<%= request.getContextPath()%>/common/ajax/checkUniqueTypeId.do?flg='+escape(new Date())+'&typeid='+escape(idval)+'&busidicttypeid='+escape($(obj).parent().parent().find('input[name="busidicttypeid"]').val()),
			success:function(data){
				if(data.flag == true){
					var msgid = data.msgid;
					alert(Message.getString(msgid)); 
					flg = false;
				}else{
					flg = true;
				}			
			},
			error:function(data){
				alert(Message.getString("ERROR_COMM_0037")); 
				flg = false;
				return;
			}		
		});
		if(!flg){
			return;
		}
		//更新类型代码
		$.ajax({
			async: false,
			data:"",
			type:"GET",
			dataType: 'json',
		 	contentType:"application/x-www-form-urlencoded:charset=UTF-8",
			url:'<%= request.getContextPath()%>/common/ajax/updateBusiDictType.do?flg='+escape(new Date())+'&typeid='+escape(idval)+'&typename='+encodeURI(encodeURI(nameval))+'&busidicttypeid='+escape($(obj).parent().parent().find('input[name="busidicttypeid"]').val()),
			success:function(data){
				var msgid = data.msgid;
				alert(Message.getString(msgid)); 
				if(data.flag == true){					
					flg = true;
				}else{
					flg = false;
				}			
			},
			error:function(data){
				alert(Message.getString("ERROR_COMM_0037")); 
				flg = false;
				return;
			}		
		});
		if(flg){
			id.html("<a href=\"#\" onclick=\"javascript:link_view(this);return false;\">"+idval+"</a>");
			name.text(nameval);
			//隐藏域处理
			$(obj).parent().parent().find('input[name="busidicttypeid"]').val(idval);
			$(obj).parent().parent().find('input[name="busidicttypename"]').val(nameval);
		}else{
			id.html("<a href=\"#\" onclick=\"javascript:link_view(this);return false;\">"+$(obj).parent().parent().find('input[name="busidicttypeid"]').val()+"</a>");
			name.text($(obj).parent().parent().find('input[name="busidicttypename"]').val());
		}
		$(obj).val('更新');
	}
	
	
}
</script>
</head>
<body>
<form id="queryForm" action="" method="post"> 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;业务字典信息&nbsp;&gt;&nbsp;业务字典信息一览</span></div>
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
				<td class="td_key" width="8%" nowrap><label class="message">类型代码</label></td>
				<td class="td_value" width="42%">
					<input id="busidicttypeid"  name="busidicttypeid" class="input_txt" value="${searchCommand.busidicttypeid}" maxlength="20" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">类型名称</label></td>
				<td class="td_value" >
					<input id="busidicttypename"  name="busidicttypename" class="input_txt" value="${searchCommand.busidicttypename}" maxlength="20" />
				</td>
			</tr>	 
			<tr>
				<td colspan="4" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input name="button" id="login" type="button" class="btn" value="刷新缓存" onClick="btn_refreshCache();">
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
		    	<td width="3%"><input type="checkbox" name="checkAll" id="checkAll" value='abc'/></td>
		    	<td width="3%">&nbsp;序号&nbsp;</td>					
				<td width="20%">&nbsp;类型代码&nbsp;</td>
				<td width="20%">&nbsp;类型名称&nbsp;</td>	
				<td width="10%">&nbsp;操作&nbsp;</td>	
				<td>&nbsp;&nbsp;</td>
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<% num++;%>
		    			<td align="center" nowrap>
	    					<input type="checkbox" name="chk" />
	    					<input name="busidicttypeid" value="${ iterator.busidicttypeid}" type="hidden" />
	    					<input name="busidicttypename" value="${ iterator.busidicttypename}" type="hidden" />
		    			</td>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap>
							<a href="#" onclick="javascript:link_view(this);return false;">${iterator.busidicttypeid}</a>
						</td>
						<td align="left" nowrap>${iterator.busidicttypename}</td>	
						<td align="left" nowrap>
							<input name="edit" id="edit" type="button" class="btn" onClick="btn_edit(this)"  value="编辑" />
							<input name="edit" id="edit" type="button" class="btn" onClick="btn_update(this)" value="更新" />							
						</td>	 					
						<td align="left" nowrap></td>
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
	<div class="div_result_button">
		<table>
			<tr>
				<td>
					<input name="insert" id="insert" type="button" class="btn" onClick="btn_insert()"  value="登&nbsp;录" /> 
					<input name="delete" id="delete" type="button" class="btn" onClick="btn_delete()"  value="删&nbsp;除" />
				</td>
			</tr>
		</table>
	</div>
</c:if>
<form action="fa004001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="busidicttypeid" type="hidden"  value="${searchCommand.busidicttypeid}" />
	<input name="busidicttypename" type="hidden"  value="${searchCommand.busidicttypename}" />
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
				pagination("page", "fa004001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<form action="fa004001edit.do" id="editForm" name="editForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="busidicttypeid" type="hidden"  value="${searchCommand.busidicttypeid}" />
	<input name="busidicttypename" type="hidden"  value="${searchCommand.busidicttypename}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="id" type="hidden"  />
	<input name="name" type="hidden"  />
</form>
<form action="fa004001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="busidicttypeid" type="hidden"  value="${searchCommand.busidicttypeid}" />
	<input name="busidicttypename" type="hidden"  value="${searchCommand.busidicttypename}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="id" type="hidden"  />
	<input name="name" type="hidden"  />
</form>
<form action="fa004001delete.do" id="deleteForm" name="deleteForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="busidicttypeid" type="hidden"  value="${searchCommand.busidicttypeid}" />
	<input name="busidicttypename" type="hidden"  value="${searchCommand.busidicttypename}" />
	<%/*共通隐藏字段 end*/%>		
</form>
</body>
</html>