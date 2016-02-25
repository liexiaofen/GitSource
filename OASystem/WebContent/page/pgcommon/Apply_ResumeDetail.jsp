<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
<div class="div_search_title">
	<table class="tb_title">
		<tbody>
			<tr class="tr_caption">
				<td class="td_caption_mark" ><IMG src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></td>
				<td class="td_caption">审核履历</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="div_search_content" id="div_view_resumes">
	<table class="tb_search">
		<tr>
			<td class="td_key" width="8%">履历</td>
			<td class="td_value">
				<textarea class="input_memo_lang dis_input"  readonly="readonly">${ command.resume}</textarea>
			</td>
		</tr>
	</table>
</div>