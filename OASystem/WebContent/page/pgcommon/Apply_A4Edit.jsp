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
				<font color="#ff0000">*</font><label class="message">出差目的</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applyreason" name="applyreason" class="input_bigger1" value="${ command.applyreason}" maxlength="50" title="required"/>					
			</td>		
		</tr>		
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">出差地</label>
			</td>
			<td class="td_value"  colspan="3">
				<dict:select id="evectionaddress" name="evectionaddress" busiDictTypeId="OA_PC001_EVAddress" value="${ command.evectionaddress}" cssClass="input_select" nullLabel="请选择" title='required'></dict:select>&nbsp;
				1.<input id="evectionaddress1" name="evectionaddress1" class="input_txt" value="${ command.evectionaddress1}" maxlength="10"/>&nbsp;
				2.<input id="evectionaddress2" name="evectionaddress2" class="input_txt" value="${ command.evectionaddress2}" maxlength="10"/>
			</td>			
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">同行人</label>
			</td>
			<td class="td_value" width="26%">
				<input id="evectionconnects" name="evectionconnects" class="input_txt" maxlength="15" value="${ command.evectionconnects}"/>	
			</td>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">出发自</label>
			</td>
			<td class="td_value" width="26%">
				<dict:select id="evectionstart" name="evectionstart" busiDictTypeId="OA_PC001_EVStart" value="${ command.evectionstart}" cssClass="input_select" title='required'></dict:select>
			</td>				
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">是否利用飞机</label>
			</td>
			<td class="td_value">
				<dict:select id="airplaneflag" name="airplaneflag" busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.airplaneflag}" cssClass="input_select_small" title='required'></dict:select>
			</td>				
		</tr>		
		<tr>
			<td class="td_key" width="8%">
				<font color="#ff0000">*</font><label class="message">预订出差时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystart" name="applystart" class="input_date Wdate" value="${command.applystart}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="applystarthm" name="applystarthm" value="${command.applystarthm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>&nbsp;~
				<input id="applyend" name="applyend" class="input_date Wdate" value="${command.applyend}" readonly="readonly" onclick="WdatePicker()" title="required"/>&nbsp;<dict:select id="applyendhm" name="applyendhm" value="${command.applyendhm}" busiDictTypeId="OA_PB001_DailyHM" cssClass="input_select_small" nullLabel="请选择" title="required"></dict:select>
			</td>
		</tr>	
		<tr>				
			<td class="td_key" width="8%">
				<label class="message">飞机票预订信息</label>
			</td>
			<td class="td_value" colspan="2">
				<table id="tresult" class="pg_result">	
					<tr class="pg_result_head">
						<td width="25%">&nbsp;日期&nbsp;</td>
						<td width="10%">&nbsp;航班&nbsp;</td>
						<td width="10%">&nbsp;出发&nbsp;</td>
						<td width="10%">&nbsp;到达&nbsp;</td>
						<td width="10%">&nbsp;是否折扣&nbsp;</td>	
						<td width="10%">&nbsp;是否出票&nbsp;</td>	
					</tr>
					<tbody id="body_result2">		    	
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input id="ticketdetail[0].orderdate" name="ticketdetail[0].orderdate" class="input_date Wdate" value="${command.ticketdetail[0].orderdate}" readonly="readonly" onclick="WdatePicker()" />
							</td>
							<td align="left" nowrap><input name="ticketdetail[0].flight" class="input_txt" value="${command.ticketdetail[0].flight}" maxlength="15" /></td>	
							<td align="left" nowrap><input name="ticketdetail[0].start" class="input_txt" value="${command.ticketdetail[0].start}" maxlength="10" /></td>
							<td align="left" nowrap><input name="ticketdetail[0].reach" class="input_txt" value="${command.ticketdetail[0].reach}" maxlength="10" /></td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[0].discountflag" name="ticketdetail[0].discountflag" value="${command.ticketdetail[0].discountflag}" busiDictTypeId="OA_PC001_Discount" cssClass="input_select_small"></dict:select>
							</td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[0].ticketflag" name="ticketdetail[0].ticketflag" value="${command.ticketdetail[0].ticketflag}" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select_small"></dict:select>
								<input id="ticketdetail[0].sortno" name="ticketdetail[0].sortno" type="hidden"  value="1" />
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input id="ticketdetail[1].orderdate" name="ticketdetail[1].orderdate" class="input_date Wdate" value="${command.ticketdetail[1].orderdate}" readonly="readonly" onclick="WdatePicker()" />
							</td>
							<td align="left" nowrap><input name="ticketdetail[1].flight" class="input_txt" value="${command.ticketdetail[1].flight}" maxlength="15" /></td>	
							<td align="left" nowrap><input name="ticketdetail[1].start" class="input_txt" value="${command.ticketdetail[1].start}" maxlength="10" /></td>
							<td align="left" nowrap><input name="ticketdetail[1].reach" class="input_txt" value="${command.ticketdetail[1].reach}" maxlength="10" /></td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[1].discountflag" name="ticketdetail[1].discountflag" value="${command.ticketdetail[1].discountflag}" busiDictTypeId="OA_PC001_Discount" cssClass="input_select_small"></dict:select>
							</td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[1].ticketflag" name="ticketdetail[1].ticketflag" value="${command.ticketdetail[1].ticketflag}" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select_small"></dict:select>
								<input id="ticketdetail[1].sortno" name="ticketdetail[1].sortno" type="hidden"  value="2" />
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input id="ticketdetail[2].orderdate" name="ticketdetail[2].orderdate" class="input_date Wdate" value="${command.ticketdetail[2].orderdate}" readonly="readonly" onclick="WdatePicker()" />
							</td>
							<td align="left" nowrap><input name="ticketdetail[2].flight" class="input_txt" value="${command.ticketdetail[2].flight}" maxlength="15" /></td>	
							<td align="left" nowrap><input name="ticketdetail[2].start" class="input_txt" value="${command.ticketdetail[2].start}" maxlength="10" /></td>
							<td align="left" nowrap><input name="ticketdetail[2].reach" class="input_txt" value="${command.ticketdetail[2].reach}" maxlength="10" /></td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[2].discountflag" name="ticketdetail[2].discountflag" value="${command.ticketdetail[2].discountflag}" busiDictTypeId="OA_PC001_Discount" cssClass="input_select_small"></dict:select>
							</td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[2].ticketflag" name="ticketdetail[2].ticketflag" value="${command.ticketdetail[2].ticketflag}" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select_small"></dict:select>
								<input id="ticketdetail[2].sortno" name="ticketdetail[2].sortno" type="hidden"  value="3" />
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input id="ticketdetail[3].orderdate" name="ticketdetail[3].orderdate" class="input_date Wdate" value="${command.ticketdetail[3].orderdate}" readonly="readonly" onclick="WdatePicker()" />
							</td>
							<td align="left" nowrap><input name="ticketdetail[3].flight" class="input_txt" value="${command.ticketdetail[3].flight}" maxlength="15" /></td>	
							<td align="left" nowrap><input name="ticketdetail[3].start" class="input_txt" value="${command.ticketdetail[3].start}" maxlength="10" /></td>
							<td align="left" nowrap><input name="ticketdetail[3].reach" class="input_txt" value="${command.ticketdetail[3].reach}" maxlength="10" /></td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[3].discountflag" name="ticketdetail[3].discountflag" value="${command.ticketdetail[3].discountflag}" busiDictTypeId="OA_PC001_Discount" cssClass="input_select_small"></dict:select>
							</td>
							<td align="center" nowrap>
								<dict:select id="ticketdetail[3].ticketflag" name="ticketdetail[3].ticketflag" value="${command.ticketdetail[3].ticketflag}" busiDictTypeId="OA_COMMON_YesOrNo" cssClass="input_select_small"></dict:select>
								<input id="ticketdetail[3].sortno" name="ticketdetail[3].sortno" type="hidden"  value="4" />
							</td>
						</tr>
					</tbody>
		  		</table>
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