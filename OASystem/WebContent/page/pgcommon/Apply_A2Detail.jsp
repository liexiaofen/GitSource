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
				<input class="input_txt dis_input" value="${ command.sourceapplyno}" readonly="readonly"/>
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
				<label class="message">请假事由</label>
			</td>
			<td class="td_value"  width="26%">
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_PC001_VacReasonType" value="${ command.vacatereasontype}" />' readonly="readonly"/>					
			</td>
			<td class="td_key" width="8%"><label class="message">其他休假请注明</label></td>
			<td class="td_value" colspan="3">
				<input id="otherremark" name="otherremark" class="input_bigger1 dis_input" value="${ command.otherremark}"/>
			</td>							
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">请假时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystarttime" name="applystarttime" class="input_txt dis_input" value="${command.applystarttime}" readonly="readonly"/>&nbsp;~
				<input id="applyendtime" name="applyendtime" class="input_txt dis_input" value="${command.applyendtime}" readonly="readonly"/>
			</td>
			<td class="td_key" width="8%"><label class="message">总工时</label></td>
			<td class="td_value" width="26%">
				<input id="totalhours" name="totalhours" class="input_txt dis_input" value="${ command.totalhours}" readonly="readonly"/>小时
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
<jsp:include page="Apply_AuthorityDetail.jsp"></jsp:include>
<jsp:include page="Apply_VacationDetail.jsp"></jsp:include>