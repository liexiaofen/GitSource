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
				<label class="message">出差目的</label>
			</td>
			<td class="td_value"  colspan="3">
				<input id="applyreason" name="applyreason" class="input_bigger1 dis_input" value="${ command.applyreason}" readonly="readonly"/>					
			</td>			
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">出差地</label>
			</td>
			<td class="td_value"  colspan="3">
				<input class="input_txt dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_EVAddress" value="${ command.evectionaddress}"></dict:write>'/>
				&nbsp;
				1.<input id="evectionaddress1" name="evectionaddress1" class="input_txt dis_input" value="${ command.evectionaddress1}" readonly="readonly"/>&nbsp;
				2.<input id="evectionaddress2" name="evectionaddress2" class="input_txt dis_input" value="${ command.evectionaddress2}" readonly="readonly"/>
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
				<label class="message">出发自</label>
			</td>
			<td class="td_value" width="26%">
				<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_EVStart" value="${ command.evectionstart}"></dict:write>'/>
			</td>				
			<td class="td_key" width="8%">
				<label class="message">是否利用飞机</label>
			</td>
			<td class="td_value">
				<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.airplaneflag}"></dict:write>'/>
			</td>				
		</tr>
		<tr>
			<td class="td_key" width="8%">
				<label class="message">预计出差时间</label>
			</td>
			<td class="td_value" colspan="3">
				<input id="applystarttime" name="applystarttime" class="input_txt dis_input" value="${command.applystarttime}" readonly="readonly"/>&nbsp;~
				<input id="applyendtime" name="applyendtime" class="input_txt dis_input" value="${command.applyendtime}" readonly="readonly"/>
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
								<input class="input_date dis_input" value="${command.ticketdetail[0].orderdate}" readonly="readonly" />
							</td>
							<td align="left" nowrap><input value="${command.ticketdetail[0].flight}" class="input_txt dis_input" readonly="readonly" /></td>	
							<td align="left" nowrap><input value="${command.ticketdetail[0].start}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="left" nowrap><input value="${command.ticketdetail[0].reach}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_Discount" value="${ command.ticketdetail[0].discountflag}"></dict:write>'/>
							</td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.ticketdetail[0].ticketflag}"></dict:write>'/>
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input class="input_date dis_input" value="${command.ticketdetail[0].orderdate}" readonly="readonly" />
							</td>
							<td align="left" nowrap><input value="${command.ticketdetail[1].flight}" class="input_txt dis_input" readonly="readonly" /></td>	
							<td align="left" nowrap><input value="${command.ticketdetail[1].start}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="left" nowrap><input value="${command.ticketdetail[1].reach}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_Discount" value="${ command.ticketdetail[1].discountflag}"></dict:write>'/>
							</td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.ticketdetail[1].ticketflag}"></dict:write>'/>
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input class="input_date dis_input" value="${command.ticketdetail[2].orderdate}" readonly="readonly" />
							</td>
							<td align="left" nowrap><input value="${command.ticketdetail[2].flight}" class="input_txt dis_input" readonly="readonly" /></td>	
							<td align="left" nowrap><input value="${command.ticketdetail[2].start}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="left" nowrap><input value="${command.ticketdetail[2].reach}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_Discount" value="${ command.ticketdetail[2].discountflag}"></dict:write>'/>
							</td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.ticketdetail[2].ticketflag}"></dict:write>'/>
							</td>
						</tr>
						<tr class="pg_result_content">		    			
							<td align="left" nowrap>
								<input class="input_date dis_input" value="${command.ticketdetail[3].orderdate}" readonly="readonly" />
							</td>
							<td align="left" nowrap><input value="${command.ticketdetail[3].flight}" class="input_txt dis_input" readonly="readonly" /></td>	
							<td align="left" nowrap><input value="${command.ticketdetail[3].start}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="left" nowrap><input value="${command.ticketdetail[3].reach}" class="input_txt dis_input" readonly="readonly" /></td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_PC001_Discount" value="${ command.ticketdetail[3].discountflag}"></dict:write>'/>
							</td>
							<td align="center" nowrap>
								<input class="input_txt1 dis_input" readonly="readonly" value='<dict:write busiDictTypeId="OA_COMMON_YesOrNo" value="${ command.ticketdetail[3].ticketflag}"></dict:write>'/>
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
<jsp:include page="Apply_AuthorityA3Detail.jsp"></jsp:include>	