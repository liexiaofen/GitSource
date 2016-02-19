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
*创建时间: 2015-10-26
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
	$("#updateForm").attr( "action", "pa003002update.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa003002back.do");	
	$("#updateForm").submit();
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post">  
	<input name="legalid" type="hidden"  value="${command.legalid}"/>
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}"/>	
	<input name="pa003001searchcommand.legalyear" type="hidden"  value="${command.pa003001searchcommand.legalyear}" />
	<input name="pa003001searchcommand.legalmonth" type="hidden"  value="${command.pa003001searchcommand.legalmonth}" />
	<input name="pa003001searchcommand.legaldate" type="hidden"  value="${command.pa003001searchcommand.legaldate}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;法定日信息&nbsp;&gt;&nbsp;法定日信息编辑</span></div>
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
					<label class="message">日期</label>
				</td>
				<td class="td_value" width="26%">
					<input id="legaldate" name="legaldate" value="${command.legaldate}" class="input_txt dis_input" readonly="readonly"/>
				</td>
				<td class="td_key" width="8%">
					<label class="message">星期</label>
				</td>
				<td class="td_value" width="26%">
					<input id="dayofweek" name="dayofweek" value="${command.dayofweek}" class="input_txt dis_input" readonly="readonly"/>
				</td>	
				<td class="td_key" width="8%">
					<label class="message">周</label>
				</td>
				<td class="td_value">
					<input id="weekofyear" name="weekofyear" value="第${command.weekofyear}周" class="input_txt dis_input" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%"><label class="message">天数</label></td>
				<td class="td_value" width="26%">
					<input id="dayofyear" name="dayofyear" value="第${command.dayofyear}天" class="input_txt dis_input" readonly="readonly"/>
				</td>				
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">是否工作日</label>
				</td>
				<td class="td_value">
					<dict:select id="status" name="status" value="${command.status}" busiDictTypeId="OA_PA003_Status" cssClass="input_select" nullLabel="请选择" title="required"></dict:select>
				</td>				
			</tr>
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="修&nbsp;改" onClick="btn_update();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>		
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>