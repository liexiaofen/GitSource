<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_update()
*输入参数: 无
*输出参数: 无
*机       能: 修改
*创 建  者: yuliang          
*创建时间: 2015-10-21
*更 新  者: 
*更新时间: 
*/
function btn_update() {
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0011"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa002002update.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_delete()
*输入参数: 无
*输出参数: 无
*机       能: 删除
*创 建  者: yuliang          
*创建时间: 2015-10-21
*更 新  者: 
*更新时间: 
*/
function btn_delete() {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0003"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa002002delete.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-09-16
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa002002back.do");	
	$("#updateForm").submit();
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post">  
	<input name="dailydeviceid" type="hidden"  value="${command.dailydeviceid}"/>
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}"/>	
	<input name="pa002001searchcommand.dailydevicename" type="hidden"  value="${command.pa002001searchcommand.dailydevicename}" />
	<input name="pa002001searchcommand.orgcdid" type="hidden"  value="${command.pa002001searchcommand.orgcdid}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;设备信息&nbsp;&gt;&nbsp;设备信息编辑</span></div>
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
					<dict:select1 id="orgcdid" name="orgcdid" value="${command.orgcdid}" sqlid="select orgcdid as busidictid,orgshortname as busidictname  from s_organize where deletefg = '0' order by sortno" cssClass="input_select" nullLabel="请选择" title="required"></dict:select1>
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">设备名称</label>
				</td>
				<td class="td_value">
					<input id="dailydevicename" name="dailydevicename" class="input_txt" value="${command.dailydevicename}" maxlength="20" title="required" />
				</td>						
			</tr>			
			<tr>
				<td class="td_key" width="8%"><label class="message">备注</label></td>
				<td class="td_value" colspan="3">
					<textarea id="comment" name="comment"  class="input_memo_long" title="maxlength" maxlength="100" >${command.comment}</textarea>	
				</td>			
			</tr>
			<tr>
				<td colspan="4" align="right">					
					<input name="search" id="search" type="button" class="btn" value="修&nbsp;改" onClick="btn_update();"/>
					<input name="search" id="search" type="button" class="btn" value="删&nbsp;除" onClick="btn_delete();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>		
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>