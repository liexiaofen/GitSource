<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
<div class="div_search_title">
	<table class="tb_title">
		<tbody>
			<tr class="tr_caption">
				<td class="td_caption_mark">
					<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
				<td class="td_caption">
					目前剩余假期
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
				<label class="message">法定休假</label>
			</td>
			<td class="td_value">
				<input class="input_txt dis_input" value="${ command.unlegalvctn}" readonly="readonly"/>小时
			</td>
			<td class="td_key" width="8%">
				<label class="message">福利休假</label>
			</td>
			<td class="td_value">
				<input class="input_txt dis_input" value="${ command.unwealvctn}" readonly="readonly"/>小时
			</td>
			<td class="td_key" width="8%">
				<label class="message">加班调休</label>
			</td>
			<td class="td_value">
				<input class="input_txt dis_input" value="${ command.unextraworkvctn}" readonly="readonly"/>小时
			</td>
		</tr>		
    </tbody>
  </table>
</div>