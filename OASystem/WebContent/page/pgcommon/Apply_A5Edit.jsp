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
				<label class="message">出差申请单号</label>
			</td>
			<td class="td_value" width="26%">
				<input id="sourceapplyno" name="sourceapplyno" value="${ command.sourceapplyno}" class="input_txt dis_input" readonly="readonly" />
				<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_applyA4ListSearch()" />
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
				<font color="#ff0000">*</font><label class="message">出差目的</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applyreason" name="applyreason" class="input_bigger1 dis_input" value="${ command.applyreason}" readonly="readonly" title="required"/>					
			</td>		
		</tr>		
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">出差地</label>
			</td>
			<td class="td_value"  colspan="3">
				<input id="evectionaddressdict" name="evectionaddressdict" class="input_txt dis_input" value='<dict:write busiDictTypeId="OA_PC001_EVAddress" value="${ command.evectionaddress}"></dict:write>' readonly="readonly" title="required"/>&nbsp;
				1.<input id="evectionaddress1" name="evectionaddress1" class="input_txt dis_input" value="${ command.evectionaddress1}" readonly="readonly"/>&nbsp;
				2.<input id="evectionaddress2" name="evectionaddress2" class="input_txt dis_input" value="${ command.evectionaddress2}" readonly="readonly"/>
				<input id="evectionaddress" name="evectionaddress" type="hidden" value="${ command.evectionaddress}"/>	
			</td>			
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">同行人</label>
			</td>
			<td class="td_value" width="26%">
				<input id="evectionconnects" name="evectionconnects" class="input_txt dis_input" readonly="readonly" value="${ command.evectionconnects}"/>	
			</td>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">出发自</label>
			</td>
			<td class="td_value" width="26%">
				<input id="evectionstartdict" name="evectionstartdict" class="input_txt dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_EVStart" value="${ command.evectionstart}"></dict:write>' title="required"/>	
				<input id="evectionstart" name="evectionstart" type="hidden" value="${ command.evectionstart}" />
			</td>				
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">是否利用飞机</label>
			</td>
			<td class="td_value">
				<input id="airplaneflagdict" name="airplaneflagdict" class="input_txt dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.airplaneflag}"></dict:write>' title="required"/>	
				<input id="airplaneflag" name="airplaneflag" type="hidden" value="${ command.airplaneflag}" />
			</td>				
		</tr>		
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">预计出差时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystart" name="applystart" class="input_short dis_input" value="${command.applystart}" readonly="readonly" title="required"/>&nbsp;<input id="applystarthm" name="applystarthm" value="${command.applystarthm}" class="input_small dis_input" readonly="readonly" title="required" />&nbsp;~
				<input id="applyend" name="applyend" class="input_short dis_input" value="${command.applyend}" readonly="readonly" title="required"/>&nbsp;<input id="applyendhm" name="applyendhm" value="${command.applyendhm}" class="input_small dis_input" readonly="readonly" title="required" />
			</td>
		</tr>						
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">备注</label>
			</td>
			<td class="td_value" colspan="3">
				原则上出差前须提出申请，未提出申请的，费用一般不予支持。
			</td>
		</tr>
    </tbody>
  </table>
</div>
<jsp:include page="Apply_AuthorityA3Edit.jsp"></jsp:include>	