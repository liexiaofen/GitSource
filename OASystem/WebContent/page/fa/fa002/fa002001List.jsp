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
	$("#queryForm").attr( "action", "fa002001search.do");	
	$("#queryForm").submit();
}
/*
*名       称: btn_insert()
*输入参数: 无
*输出参数: 无
*机       能: 登录
*创 建  者: yuliang          
*创建时间: 2016-05-23
*更 新  者: 
*更新时间: 
*/
function btn_insert() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "fa002001insert.do");
	$('#queryForm').submit();
}
/*
*名       称: link_view( obj)
*输入参数: obj
*输出参数: 无
*机       能: link按下，跳转到明细画面
*创 建  者: yuliang          
*创建时间: 2016-05-16
*更 新  者: 
*更新时间: 
*/
function link_view( obj){
	var roleid = $(obj).parent().parent().find('input[name="roleid"]').val();
	$("#viewForm").find('input[name="roleid"]').val(roleid);
	c_ShowProgressBar(); 
	$('#viewForm').attr( "action", "fa002001view.do");	
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
*创建时间: 2016-05-31
*更 新  者: 
*更新时间: 
*/
function btn_delete(){
	var obj = $( "input[name='chk']:checked" );
	if ( obj.length < 1 ) {
		alert(Message.getString("MSG_COMM_0031"));
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0004"))) 
		return;
	$("#div_result").find("input[name='chk']:checked").each(function( i, n){			
		var roleid = $(n).parent().find('input[name="roleid"]').val();
		$("#deleteForm").append("<input name=\"role["+i+"].roleid\" value=\""+roleid+"\" type=\"hidden\" />");
	});
	c_ShowProgressBar();	
	$("#deleteForm").attr( "action", "fa002001delete.do");	
	$("#deleteForm").submit();
}
/*
*名       称: btn_setAuthority(obj)
*输入参数: obj
*输出参数: 无
*机       能: 配置权限
*创 建  者: yuliang          
*创建时间: 2016-05-31
*更 新  者: 
*更新时间: 
*/
function btn_setAuthority(obj){
	var roleid = $(obj).parent().parent().find('input[name="roleid"]').val();
	ztree_reload(roleid);
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
		var rolename = $(obj).parent().prev().prev().prev();
		var rolecode = $(obj).parent().prev().prev();
		rolename.html("<input class=\"input_txt\" value=\""+$(rolename).text()+"\" maxlength=\"20\" />");
		rolecode.html("<input class=\"input_txt\" value=\""+$(rolecode).text()+"\" maxlength=\"15\" />");
		$(obj).val('保存');
	}else{				
		var rolename = $(obj).parent().prev().prev().prev();
		var rolecode = $(obj).parent().prev().prev();
		var newrolename = $(rolename).find("input").val();
		var newrolecode = $(rolecode).find("input").val();
		if(newrolename == ''){
			alert( Message.getString( "MSG_COMM_0001", "角色名称"));
			$(rolename).find("input").focus();
			return;
		}
		if(newrolecode == ''){
			alert( Message.getString( "MSG_COMM_0001", "角色代码"));
			$(rolecode).find("input").focus();
			return;
		}
		var flg = true;
		//更新角色信息
		$.ajax({
			async: false,
			data:"",
			type:"GET",
			dataType: 'json',
		 	contentType:"application/x-www-form-urlencoded:charset=UTF-8",
			url:'<%= request.getContextPath()%>/common/ajax/updateRole.do?flg='+escape(new Date())+'&rolecode='+encodeURI(encodeURI(newrolecode))+'&rolename='+encodeURI(encodeURI(newrolename))+'&roleid='+escape($(obj).parent().parent().find('input[name="roleid"]').val()),
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
			rolename.text(newrolename);
			rolecode.text(newrolecode); 	
			//隐藏域处理
			$(obj).parent().parent().find('input[name="rolecode"]').val(newrolecode);
			$(obj).parent().parent().find('input[name="rolename"]').val(newrolename);
		}else{
			rolename.text($(obj).parent().parent().find('input[name="rolename"]').val());
			rolecode.text($(obj).parent().parent().find('input[name="rolecode"]').val());
		}
		$(obj).val('更新');
	}	
}
/*
*名       称: ztree_reload(roleid)
*输入参数: roleid
*输出参数: 无
*机       能: 树节点重新加载
*创 建  者: yuliang          
*创建时间: 2016-06-01
*更 新  者: 
*更新时间: 
*/
function ztree_reload(roleid){	
	//ztree的重新加载
	window.parent.document.getElementById('right').src = '<%=request.getContextPath()%>/page/fa/fa002/ztree.jsp?roleid='+roleid;
}
$(document).ready(function(){	
	var roleid = $("#div_result").find('input[name="roleid"]').eq(0).val();
	ztree_reload(roleid);
});
</script>
</head>
<body>
<form id="queryForm" action="" method="post"> 
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;角色信息&nbsp;&gt;&nbsp;角色信息一览</span></div>
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
				<td class="td_key" width="8%" nowrap><label class="message">角色代码</label></td>
				<td class="td_value" width="26%">
					<input id="rolecode"  name="rolecode" class="input_txt" value="${searchCommand.rolecode}" maxlength="15" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">角色名称</label></td>
				<td class="td_value" width="26%">
					<input id="rolename"  name="rolename" class="input_txt" value="${searchCommand.rolename}" maxlength="20" />
				</td>
				<td class="td_key" width="8%" nowrap><label class="message">角色级别</label></td>
				<td class="td_value">
					<dict:select id="roletype" name="roletype" value="${searchCommand.roletype}" busiDictTypeId="OA_COMMON_RoleType" cssClass="input_select" nullLabel="全部"></dict:select>
				</td>
			</tr>	 
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="查&nbsp;询" onClick="btn_search();"/>
					<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_reset();">
					<input name="insert" id="insert" type="button" class="btn" onClick="btn_insert()"  value="登&nbsp;录" /> 
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
		    	<td width="5%"><input type="checkbox" name="checkAll" id="checkAll" value='abc'/></td>
		    	<td width="5%">&nbsp;序号&nbsp;</td>					
				<td width="25%">&nbsp;角色名称&nbsp;</td>
				<td width="25%">&nbsp;角色代码&nbsp;</td>	
				<td width="25%">&nbsp;角色级别&nbsp;</td>
				<td width="25%">&nbsp;操作&nbsp;</td>
			</tr>
		    <tbody id="body_result">
		    	<c:forEach items="${list}" var="iterator">
		    		<tr class="pg_result_content">
		    			<% num++;%>
		    			<td align="center" nowrap>
	    					<input type="checkbox" name="chk" />
	    					<input name="roleid" value="${ iterator.roleid}" type="hidden" />
	    					<input name="rolename" value="${ iterator.rolename}" type="hidden" />
	    					<input name="rolecode" value="${ iterator.rolecode}" type="hidden" />
	    					<input name="roletype" value="${ iterator.roletype}" type="hidden" />
		    			</td>
		    			<td align="center" nowrap><%=num %></td>
						<td align="left" nowrap>${iterator.rolename}</td>
						<td align="left" nowrap>${iterator.rolecode}</td>
						<td align="left" nowrap><dict:write busiDictTypeId="OA_COMMON_RoleType" value="${iterator.roletype}"></dict:write></td>		
						<td align="left" nowrap>
							<input name="update" id="update" type="button" class="btn" onClick="btn_update(this)" value="更新" />			
							<input name="authority" id="authority" type="button" class="btn" onClick="btn_setAuthority(this)"  value="配置权限" />
						</td>		
		    		</tr>
		    	</c:forEach>	
		    </tbody>
		</table>
	</div>
	<div class="div_result_button">
		<table>
			<tr>
				<td>					
					<input name="delete" id="delete" type="button" class="btn" onClick="btn_delete()"  value="删&nbsp;除" />
				</td>
			</tr>
		</table>
	</div>
</c:if>
<form action="fa002001page.do" id="pageform" name="pageform" method="post" >
	<%/*共通隐藏字段 start*/%>
	<input name="rolecode" type="hidden"  value="${searchCommand.rolecode}" />
	<input name="rolename" type="hidden"  value="${searchCommand.rolename}" />
	<input name="roletype" type="hidden"  value="${searchCommand.roletype}" />
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
				pagination("page", "fa002001page.do","pageform",curPage,totalPage,firstPage,lastPage);
			</script>
		</div>
	</c:if>
	<!--End Page Infor-->
</form>
<form action="fa002001view.do" id="viewForm" name="viewForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="rolecode" type="hidden"  value="${searchCommand.rolecode}" />
	<input name="rolename" type="hidden"  value="${searchCommand.rolename}" />
	<input name="roletype" type="hidden"  value="${searchCommand.roletype}" />
	<%/*共通隐藏字段 end*/%>	
	<input name="roleid" type="hidden"  />
</form>
<form action="fa002001delete.do" id="deleteForm" name="deleteForm" method="post">
	<%/*共通隐藏字段 start*/%>
	<input name="rolecode" type="hidden"  value="${searchCommand.rolecode}" />
	<input name="rolename" type="hidden"  value="${searchCommand.rolename}" />
	<input name="roletype" type="hidden"  value="${searchCommand.roletype}" />
	<%/*共通隐藏字段 end*/%>		
</form>
</body>
</html>