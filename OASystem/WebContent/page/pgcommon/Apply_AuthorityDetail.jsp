<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.lw.com/tags/dict" prefix="dict" %>
<div class="div_search_title">
	<table class="tb_title">
		<tbody>
			<tr class="tr_caption">
				<td class="td_caption_mark">
					<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
				<td class="td_caption">
					路径设置
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
				<label class="message">部门经理审核</label>
			</td>
			<td class="td_key" width="10%"><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<input id="managercheckname" name="managercheckname" class="input_txt dis_input" value="${ command.managercheckname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<input id="managerorgcdname" name="managerorgcdname" class="input_txt dis_input" value="${ command.managerorgcdname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value" >
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_COMMON_Department" value="${ command.managerdepid}"></dict:write>' readonly="readonly"/>					
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">人事审核</label>
			</td>
			<td class="td_key" width="10%"><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<input id="personnelcheckname" name="personnelcheckname" class="input_txt dis_input" value="${ command.personnelcheckname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<input id="personnelorgcdname" name="personnelorgcdname" class="input_txt dis_input" value="${ command.personnelorgcdname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value">
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_COMMON_Department" value="${ command.personneldepid}"></dict:write>' readonly="readonly"/>						
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">副总审核</label>
			</td>
			<td class="td_key" width="10%"><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<input id="vicepresicheckname" name="vicepresicheckname" class="input_txt dis_input" value="${ command.vicepresicheckname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<input id="vicepresiorgcdname" name="vicepresiorgcdname" class="input_txt dis_input" value="${ command.vicepresiorgcdname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value" >
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_COMMON_Department" value="${ command.vicepresidepid}"></dict:write>' readonly="readonly"/>					
			</td>				
		</tr>	
		<tr>
			<td class="td_key" width="8%">
				<label class="message">总经理审核</label>
			</td>
			<td class="td_key" width="10%"><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<input id="presicheckname" name="presicheckname" class="input_txt dis_input" value="${ command.presicheckname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<input id="presiorgcdname" name="presiorgcdname" class="input_txt dis_input" value="${ command.presiorgcdname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value">
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_COMMON_Department" value="${ command.presidepid}"></dict:write>' readonly="readonly"/>						
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">人事归档</label>
			</td>
			<td class="td_key" width="10%"><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<input id="personfilecheckname" name="personfilecheckname" class="input_txt dis_input" value="${ command.personfilecheckname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<input id="personfileorgcdname" name="personfileorgcdname" class="input_txt dis_input" value="${ command.personfileorgcdname}" readonly="readonly"/>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value">
				<input class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_COMMON_Department" value="${ command.personfiledepid}"></dict:write>' readonly="readonly"/>					
			</td>				
		</tr>
    </tbody>
  </table>
</div>
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