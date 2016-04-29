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
*创建时间: 2015-10-23
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
	$("#addForm").attr( "action", "pa002003save.do");	
	$("#addForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-10-21
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pa002003back.do");	
	$("#addForm").submit();
}
</script>
</head>
<body>
<form id="addForm" action="" method="post" >  
	<input name="pa002001searchcommand.dailydevicename" type="hidden"  value="${command.pa002001searchcommand.dailydevicename}" />
	<input name="pa002001searchcommand.orgcdid" type="hidden"  value="${command.pa002001searchcommand.orgcdid}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;设备信息&nbsp;&gt;&nbsp;设备信息登录</span></div>
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
					<font color="#ff0000">*</font><label class="message">机构</label>
				</td>
				<td class="td_value" width="26%">
					<dict:select2 id="orgcdid" name="orgcdid" sqlid="select orgcdid as busidictid,orgshortname as busidictname  from s_organize where deletefg = '0' order by sortno" cssClass="input_select" nullLabel="请选择" title="required"></dict:select2>
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">设备名称</label>
				</td>
				<td class="td_value">
					<input id="dailydevicename" name="dailydevicename" class="input_txt" maxlength="20"  title="required" />
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%"><label class="message">备注</label></td>
				<td class="td_value" colspan="3">
					<textarea id="comment" name="comment"  class="input_memo_long" title="maxlength" maxlength="100"></textarea>	
				</td>			
			</tr>
			<tr>
				<td colspan="4" align="right">					
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