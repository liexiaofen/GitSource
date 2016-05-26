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
	//ztree的重新加载
	window.parent.document.getElementById('left').src = '<%=request.getContextPath()%>/page/fa/fa001/ztree.jsp';
	$("#addForm").attr( "action", "fa001003save.do");	
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
	<input name="isleaf" type="hidden" value="0" />
	<input name="resourcetype" type="hidden" value="0" />	
	<input name="resourcelevel" type="hidden" value="1" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;菜单信息&nbsp;&gt;&nbsp;菜单信息登录</span></div>
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
					<font color="#ff0000">*</font><label class="message">显示顺序</label>
				</td>
				<td class="td_value">
					<input name="sortno" class="input_txt num1" maxlength="2"  title="required"/>
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