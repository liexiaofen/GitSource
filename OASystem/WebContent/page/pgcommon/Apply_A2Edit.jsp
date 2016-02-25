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
			<td class="td_key" width="8%">
				<label class="message">休假申请单号</label>
			</td>
			<td class="td_value" width="26%">
				<input id="sourceapplyno" name="sourceapplyno" value="${ command.sourceapplyno}" class="input_txt dis_input" readonly="readonly" />
				<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_applyA1ListSearch()" />
				<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear()" />
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
				<input id="vacatereasontypedict" name="vacatereasontypedict" value="${ command.vacatereasontypedict}" class="input_txt dis_input" readonly="readonly" title="required"/>
				<input id="vacatereasontype" name="vacatereasontype" type="hidden" value="${ command.vacatereasontype}" />
			</td>
			<td class="td_key" width="8%"><label class="message">其他休假请注明</label></td>
			<td class="td_value" colspan="3">
				<input id="otherremark" name="otherremark" class="input_bigger1 dis_input" maxlength="50" value="${ command.otherremark}"/>
			</td>							
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">请假时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystart" name="applystart" class="input_short dis_input" value="${command.applystart}" readonly="readonly" title="required"/>&nbsp;<input id="applystarthm" name="applystarthm" value="${command.applystarthm}" class="input_small dis_input" readonly="readonly" title="required" />&nbsp;~
				<input id="applyend" name="applyend" class="input_short dis_input" value="${command.applyend}" readonly="readonly" title="required"/>&nbsp;<input id="applyendhm" name="applyendhm" value="${command.applyendhm}" class="input_small dis_input" readonly="readonly" title="required" />
			</td>
			<td class="td_key" width="8%"><font color="#ff0000">*</font><label class="message">总工时</label></td>
			<td class="td_value" width="26%">
				<input id="totalhours" name="totalhours" class="input_txt dis_input" title='required' maxlength="3" value="${ command.totalhours}" />小时
			</td>								
		</tr>			
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">备注</label>
			</td>
			<td class="td_value" colspan="5">
				休假取消申请需要打印出相应的休假申请，并附在该申请之后交给人事。
			</td>
		</tr>
    </tbody>
  </table>
</div>
<jsp:include page="Apply_AuthorityEdit.jsp"></jsp:include>