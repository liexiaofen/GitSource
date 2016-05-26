<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_save()
*输入参数: 无
*输出参数: 无
*机       能: 保存
*创 建  者: yuliang          
*创建时间: 2016-05-23
*更 新  者: 
*更新时间: 
*/
function btn_save() {	
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0002"))) 
		return;
	c_ShowProgressBar(); 
	//ztree的重新加载
	window.parent.document.getElementById('left').src = '<%=request.getContextPath()%>/page/fa/fa001/ztree.jsp';
	$("#updateForm").attr( "action", "fa001002update.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2016-05-23
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "fa001003back.do");	
	$("#updateForm").submit();
}
/*
*名       称: btn_subadd()
*输入参数: 无
*输出参数: 无
*机       能: 增加子菜单
*创 建  者: yuliang          
*创建时间: 2016-05-23
*更 新  者: 
*更新时间: 
*/
function btn_subadd() {		
	var resourcelevel = $("#resourcelevel").val();
	$("#resourcelevel").val(parseInt(resourcelevel)+1);
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "fa001002subadd.do");	
	$("#updateForm").submit();	
}

</script>
</head>
<body>
<form id="updateForm" action="" method="post" >  
	<input name="searchCommand.resourcecode" type="hidden"  value="${command.searchCommand.resourcecode}" />
	<input name="searchCommand.resourcelevel" type="hidden"  value="${command.searchCommand.resourcelevel}" />
	<input name="searchCommand.resourcename" type="hidden"  value="${command.searchCommand.resourcename}" />
	<input name="resourceid" type="hidden"  value="${command.resourceid}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;菜单信息&nbsp;&gt;&nbsp;菜单信息编辑</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						菜单信息
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content">
	  <table class="tb_search">
	    <tbody>
	    	<tr>
				<td class="td_key" width="8%">
					<label class="message">父菜单名称</label>
				</td>
				<td class="td_value" width="26%">
					<input value="${command.parentname}" class="input_txt dis_input"  readonly="readonly"/>
					<input id="parentid" name="parentid" type="hidden" value="${command.parentid}" />
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">菜单名称</label>
				</td>
				<td class="td_value" width="26%">
					<input id="resourcename" name="resourcename" value="${command.resourcename}" class="input_txt" maxlength="20"  title="required" />
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">菜单代码</label>
				</td>
				<td class="td_value">
					<input id="resourcecode" name="resourcecode" value="${command.resourcecode}" class="input_txt" maxlength="15"  title="required" />
				</td>	
			</tr>			
			<tr>
				<td class="td_key" width="8%">
					<label class="message">是否叶子资源</label>
				</td>
				<td class="td_value">
					<c:if test="${command.resourcelevel == 1}">
						<input value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${command.isleaf}"></dict:write>' class="input_txt dis_input" readonly="readonly"/>
						<input id="isleaf" name="isleaf" type="hidden" value="${command.isleaf}" />
					</c:if>
					<c:if test="${command.resourcelevel != 1}">
						<dict:select id="isleaf" name="isleaf" value="${command.isleaf}" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select"></dict:select>
					</c:if>
					
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">菜单入口</label>
				</td>
				<td class="td_value">
					<c:if test="${command.resourcelevel == 1}">
						<input id="resourceaction" name="resourceaction" value="${command.resourceaction}" class="input_txt dis_input" readonly="readonly"/>
					</c:if>
					<c:if test="${command.resourcelevel != 1}">
						<input id="resourceaction" name="resourceaction" value="${command.resourceaction}" class="input_txt" maxlength="20"  />
					</c:if>
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">资源类型</label>
				</td>
				<td class="td_value">
					<c:if test="${command.resourcelevel == 1}">
						<input value='<dict:write busiDictTypeId="OA_COMMON_ResourceType" value="${command.resourcetype}"></dict:write>' class="input_txt dis_input" readonly="readonly"/>
						<input id="resourcetype" name="resourcetype" type="hidden" value="${command.resourcetype}" />
					</c:if>
					<c:if test="${command.resourcelevel != 1}">
						<dict:select id="resourcetype" name="resourcetype" value="${command.resourcetype}" busiDictTypeId="OA_COMMON_ResourceType" cssClass="input_select"></dict:select>
					</c:if>
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">显示顺序</label>
				</td>
				<td class="td_value">
					<input name="sortno" class="input_txt" value="${command.sortno}"   maxlength="2"  title="required"/>
				</td>	
			</tr>	
			<tr>
				<td class="td_key" width="8%">
					<label class="message">菜单层次</label>
				</td>
				<td class="td_value">
					<input class="input_txt dis_input" value="<dict:write busiDictTypeId="OA_COMMON_Level" value="${command.resourcelevel}"></dict:write>" readonly="readonly"/>
					<input id="resourcelevel" name="resourcelevel" type="hidden" value="${command.resourcelevel}" />
				</td>	
			</tr>					
	    </tbody>
	  </table>
	</div>
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td align="right">					
					<input name="save" id="save" type="button" class="btn" value="保&nbsp;存" onClick="btn_save();"/>
					<input name="subadd" id="subadd" type="button" class="btn" value="增加子菜单" onClick="btn_subadd();" />
				</td>
	      	</tr>
		</table>
	</div>	
</form>
</body>
</html>