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
*创建时间: 2016-05-12
*更 新  者: 
*更新时间: 
*/
function btn_save() {	
	if ( !$.fn.autovalidateForm("addForm") ){
		return;
	}	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0002"))) 
		return;
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "fa001004save.do");	
	$("#addForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2016-05-12
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "fa001003back.do");	
	$("#addForm").submit();
}

</script>
</head>
<body>
<form id="addForm" action="" method="post" >  
	<input name="searchCommand.resourcecode" type="hidden"  value="${command.searchCommand.resourcecode}" />
	<input name="searchCommand.resourcelevel" type="hidden"  value="${command.searchCommand.resourcelevel}" />
	<input name="searchCommand.resourcename" type="hidden"  value="${command.searchCommand.resourcename}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;菜单信息&nbsp;&gt;&nbsp;子菜单信息登录</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						子菜单信息
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
					<font color="#ff0000">*</font><label class="message">父菜单名称</label>
				</td>
				<td class="td_value" width="26%">
					<input value="${ command.resourcename}" class="input_txt dis_input"  readonly="readonly" />
					<input id="parentid" name="parentid" type="hidden" value="${command.resourceid}" />
					<input id="resourcelevel" name="resourcelevel" type="hidden" value="${command.resourcelevel}" />
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">菜单名称</label>
				</td>
				<td class="td_value" width="26%">
					<input id="resourcename" name="resourcename" class="input_txt" maxlength="20"  title="required" />
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">菜单代码</label>
				</td>
				<td class="td_value">
					<input id="resourcecode" name="resourcecode" class="input_txt" maxlength="15"  title="required" />
				</td>	
			</tr>			
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">是否叶子资源</label>
				</td>
				<td class="td_value">
					<dict:select id="isleaf" name="isleaf" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select" value="1"></dict:select>
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">菜单入口</label>
				</td>
				<td class="td_value">
					<input id="resourceaction" name="resourceaction" class="input_txt" maxlength="20"  />
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">资源类型</label>
				</td>
				<td class="td_value">
					<dict:select id="resourcetype" name="resourcetype" busiDictTypeId="OA_COMMON_ResourceType" cssClass="input_select"></dict:select>
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">显示顺序</label>
				</td>
				<td class="td_value">
					<input name="sortno" class="input_txt" maxlength="2"  title="required"/>
				</td>	
			</tr>					
	    </tbody>
	  </table>
	</div>		
	<div class="div_result_button">
		<table class="tb_result">
			<tr>
				<td colspan="2" align="right">					
					<input name="search" id="search" type="button" class="btn" value="保&nbsp;存" onClick="btn_save();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
		</table>
	</div>	
</form>
</body>
</html>