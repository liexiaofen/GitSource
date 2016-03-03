<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
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
				<label class="message">申请单号</label>
			</td>
			<td class="td_value" width="26%">
				<input name="applyno" class="input_txt dis_input" value="${ command.applyno}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">申请人</label>
			</td>
			<td class="td_value" width="26%">
				<input class="input_txt dis_input" value="${ command.applyempname}" readonly="readonly"/>
			</td>				
			<td class="td_key" width="8%">
				<label class="message">机构</label>
			</td>
			<td class="td_value" colspan="3">
				<input class="input_bigger2 dis_input" value="${ command.orgcddepposes}" readonly="readonly"/>
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">申请事由</label>
			</td>
			<td class="td_value"  width="26%">
				<input id="applyreason" name="applyreason" class="input_bigger1 dis_input" value="${ command.applyreason}" readonly="readonly"/>					
			</td>		
			<td class="td_key" width="8%">
				<label class="message">申请加班类型</label>
			</td>
			<td class="td_value"  width="26%">
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_PC001_EWApplyType" value="${ command.extraworkapplytype}" />' readonly="readonly"/>					
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">加班申请时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystarttime" name="applystarttime" class="input_txt dis_input" value="${command.applystarttime}" readonly="readonly"/>&nbsp;~
				<input id="applyendtime" name="applyendtime" class="input_txt dis_input" value="${command.applyendtime}" readonly="readonly"/>
			</td>
			<td class="td_key" width="8%"><label class="message">总工时</label></td>
			<td class="td_value" width="26%">
				<input id="totalhours" name="totalhours" class="input_txt" value="${ command.totalhours}"/>小时
			</td>								
		</tr>	
		<tr>
			<td class="td_key" width="8%">
				<label class="message">是否出差地加班</label>
			</td>
			<td class="td_value"  width="26%">
				<input class="input_small dis_input" value='<dict:write busiDictTypeId="OA_PC001_EWFlag" value="${ command.evectionworkflag}" />' readonly="readonly"/>					
			</td>			
		</tr>		
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">出差地加班说明</label>
			</td>
			<td class="td_value" colspan="5">
				出差地加班只能发生在双休和国定节假日
			</td>
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">加班实施时间（事后入力）</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="extraworkstart" name="extraworkstart" class="input_date Wdate" value="${command.extraworkstart}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="extraworkstarthm" name="extraworkstarthm" value="${command.extraworkstarthm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>&nbsp;~
				<input id="extraworkend" name="extraworkend" class="input_date Wdate" value="${command.extraworkend}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="extraworkendhm" name="extraworkendhm" value="${command.extraworkendhm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>
			</td>
		</tr>
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">备注</label>
			</td>
			<td class="td_value" colspan="5">
				一般每日加班不得超过3小时；每月加班不能超过36小时
			</td>
		</tr>
    </tbody>
  </table>
</div>
<jsp:include page="Apply_AuthorityEdit.jsp"></jsp:include>	