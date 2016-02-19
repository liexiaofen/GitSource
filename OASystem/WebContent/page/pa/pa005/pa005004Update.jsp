<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_update()
*输入参数: 无
*输出参数: 无
*机       能: 修改
*创 建  者: yuliang          
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function btn_update() {
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}	
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0011"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa005004update.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-10-26
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa005004back.do");	
	$("#updateForm").submit();
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post">  
	<input name="empid" type="hidden"  value="${command.empid}"/>
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}"/>	
	<input name="pa005001searchcommand.year" type="hidden"  value="${command.pa005001searchcommand.year}" />
	<input name="pa005001searchcommand.empname" type="hidden"  value="${command.pa005001searchcommand.empname}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;年假信息&nbsp;&gt;&nbsp;年假信息编辑</span></div>
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
					<label class="message">员工姓名</label>
				</td>
				<td class="td_value" width="26%">
					<input id="empname" name="empname" value="${command.empname}" class="input_txt dis_input" readonly="readonly"/>
				</td>
				<td class="td_key" width="8%">
					<label class="message">年份</label>
				</td>
				<td class="td_value" colspan="3">
					<input id="year" name="year" value="${command.year}" class="input_txt dis_input" readonly="readonly"/>
				</td>	
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">法定休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="legalvctn" name="legalvctn" value="${command.legalvctn}" class="input_txt input_num1" title="required,num1" maxlength="3" />小时
				</td>				
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">福利休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="wealvctn" name="wealvctn" value="${command.wealvctn}" class="input_txt input_num1" title="required,num1" maxlength="3" />小时
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">加班调休</label>
				</td>
				<td class="td_value">
					<input id="extraworkvctn" name="extraworkvctn" value="${command.extraworkvctn}" class="input_txt input_num1" title="required,num1" maxlength="3" />小时
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">已休法定休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="haslegalvctn" name="haslegalvctn" value="${command.haslegalvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>				
				<td class="td_key" width="8%">
					<label class="message">已休福利休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="haswealvctn" name="haswealvctn" value="${command.haswealvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>
				<td class="td_key" width="8%">
					<label class="message">已休加班调休</label>
				</td>
				<td class="td_value">
					<input id="hasextraworkvctn" name="hasextraworkvctn" value="${command.hasextraworkvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">未休法定休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="unlegalvctn" name="unlegalvctn" value="${command.unlegalvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>				
				<td class="td_key" width="8%">
					<label class="message">未休福利休假</label>
				</td>
				<td class="td_value" width="26%">
					<input id="unwealvctn" name="unwealvctn" value="${command.unwealvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>
				<td class="td_key" width="8%">
					<label class="message">未休加班调休</label>
				</td>
				<td class="td_value">
					<input id="unextraworkvctn" name="unextraworkvctn" value="${command.unextraworkvctn}" class="input_txt dis_input" readonly="readonly"/>小时
				</td>				
			</tr>
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="修&nbsp;改" onClick="btn_update();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>		
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>