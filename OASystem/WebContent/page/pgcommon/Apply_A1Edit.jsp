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
				<font color="#ff0000">*</font><label class="message">请假事由</label>
			</td>
			<td class="td_value"  width="26%">
				<dict:select id="vacatereasontype" name="vacatereasontype" busiDictTypeId="OA_PC001_VacReasonType" value="${ command.vacatereasontype}" cssClass="input_select" nullLabel="请选择" title='required'></dict:select>
			</td>
			<td class="td_key" width="8%"><label class="message">其他休假请注明</label></td>
			<td class="td_value" colspan="3">
				<input id="otherremark" name="otherremark" class="input_bigger1" maxlength="50" value="${ command.otherremark}"/>
			</td>							
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">请假时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystart" name="applystart" class="input_date Wdate" value="${command.applystart}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="applystarthm" name="applystarthm" value="${command.applystarthm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>&nbsp;~
				<input id="applyend" name="applyend" class="input_date Wdate" value="${command.applyend}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="applyendhm" name="applyendhm" value="${command.applyendhm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>
			</td>
			<td class="td_key" width="8%"><font color="#ff0000">*</font><label class="message">总工时</label></td>
			<td class="td_value" width="26%">
				<input id="totalhours" name="totalhours" class="input_txt input_num1" title='required' maxlength="3" value="${ command.totalhours}" />小时
			</td>								
		</tr>			
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">备注</label>
			</td>
			<td class="td_value" colspan="5">
				关于休假顺序，原则上先加班调休、后带薪休假（先扣法定后扣福利）
			</td>
		</tr>
    </tbody>
  </table>
</div>
<jsp:include page="Apply_AuthorityEdit.jsp"></jsp:include>	
<jsp:include page="Apply_VacationEdit.jsp"></jsp:include>