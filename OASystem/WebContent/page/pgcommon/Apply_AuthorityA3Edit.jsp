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
			<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<select id='managercheckid' name= 'managercheckid' class='input_select'>
					
				</select>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<dict:select1 id="managerorgcdid" name="managerorgcdid" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'managerdepid', 'managercheckid', 3)"></dict:select1>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value" >
				<select id='managerdepid' name= 'managerdepid' class='input_select' onchange="change_refreshEmp( this, 'managerorgcdid', 'managercheckid')" >
				</select>
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">副总审核</label>
			</td>
			<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<select id='vicepresicheckid' name= 'vicepresicheckid' class='input_select' >
				</select>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<dict:select1 id="vicepresiorgcdid" name="vicepresiorgcdid" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'vicepresidepid', 'vicepresicheckid', 0)"></dict:select1>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value" >
				<select id='vicepresidepid' name= 'vicepresidepid' class='input_select' onchange="change_refreshEmp( this, 'vicepresiorgcdid', 'vicepresicheckid')">
				</select>
			</td>				
		</tr>	
		<tr>
			<td class="td_key" width="8%">
				<label class="message">总经理审核</label>
			</td>
			<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<select id='presicheckid' name= 'presicheckid' class='input_select' >
				</select>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<dict:select1 id="presiorgcdid" name="presiorgcdid" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'presidepid', 'presicheckid', 0)"></dict:select1>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value">
				<select id='presidepid' name= 'presidepid' class='input_select' onchange="change_refreshEmp( this, 'presiorgcdid', 'presicheckid')">
				</select>
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">人事归档</label>
			</td>
			<td class="td_key" width="10%"><font color="#ff0000">*</font><label class="message">审核者</label></td>
			<td class="td_value" width="15%">
				<select id='personfilecheckid' name= 'personfilecheckid' class='input_select' >
				</select>
			</td>
			<td class="td_key" width="10%">机构</td>
			<td class="td_value" width="15%">
				<dict:select1 id="personfileorgcdid" name="personfileorgcdid" sqlid="select t2.orgcdid as busidictid,t2.orgshortname as busidictname  from t_emporg t1 inner join s_organize t2 on t1.orgcdid = t2.orgcdid where t1.deletefg = '0' and t1.empid = '${command.applyempid}' order by t2.sortno" cssClass="input_select" onChange="change_refreshDepEmp(this, 'personfiledepid', 'personfilecheckid', 1)"></dict:select1>
			</td>
			<td class="td_key" width="10%"><label class="message">部门</label></td>
			<td class="td_value">
				<select id='personfiledepid' name= 'personfiledepid' class='input_select' onchange="change_refreshEmp( this, 'personfileorgcdid', 'personfilecheckid')">
				</select>
			</td>				
		</tr>
    </tbody>
  </table>
</div>
