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
*创建时间: 2015-10-22
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
	$("#addForm").attr( "action", "pa004003save.do");	
	$("#addForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-10-22
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pa004003back.do");	
	$("#addForm").submit();
}
</script>
</head>
<body>
<form id="addForm" action="" method="post" >  
	<input name="pa004001searchcommand.regionid" type="hidden"  value="${command.pa004001searchcommand.regionid}" />
	<input name="pa004001searchcommand.orgname" type="hidden"  value="${command.pa004001searchcommand.orgname}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;机构信息&nbsp;&gt;&nbsp;机构信息登录</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						基本信息
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
					<font color="#ff0000">*</font><label class="message">机构全称</label>
				</td>
				<td class="td_value" width="26%">
					<input id="orgname" name="orgname" class="input_bigger" maxlength="50"  title="required" />
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">机构简称</label>
				</td>
				<td class="td_value" width="26%">
					<input id="orgshortname" name="orgshortname" class="input_txt" maxlength="20"  title="required" />
				</td>	
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">区域</label>
				</td>
				<td class="td_value">
					<dict:select id="regionid" name="regionid" busiDictTypeId="OA_COMMON_Region" cssClass="input_select" nullLabel="请选择" title="required"></dict:select>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%"><font color="#ff0000">*</font><label class="message">Tel</label></td>
				<td class="td_value" width="26%">
					<input id="tel" name="tel" class="input_txt" maxlength="20"  title="required,tel" />
				</td>
				<td class="td_key" width="8%">
					<label class="message">Fax</label>
				</td>
				<td class="td_value" width="26%">
					<input id="fax" name="fax" class="input_txt" maxlength="20"  title='tel' />
				</td>
				<td class="td_key" width="8%">
					<label class="message">邮编</label>
				</td>
				<td class="td_value">
					<input id="zipcode" name="zipcode" class="input_txt" maxlength="10"  title='zipcode' />
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">地址</label>
				</td>
				<td class="td_value" width="26%">
					<input id="address" name="address" class="input_bigger1" maxlength="100" title="required"/>
				</td>
				<td class="td_key" width="8%">
					<label class="message">有效期</label></td>
				<td class="td_value">
					<input id="effectivedate"  name="effectivedate" class="input_date Wdate" readonly="readonly" onclick="WdatePicker()" />
				</td>	
			</tr>
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="保&nbsp;存" onClick="btn_save();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>