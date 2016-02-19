<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
	int num = 0;
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_apply()
*输入参数: 无
*输出参数: 无
*机       能: 申请
*创 建  者: yuliang          
*创建时间: 2015-12-17
*更 新  者: 
*更新时间: 
*/
function btn_apply() {
	c_ShowProgressBar(); 
	$('#queryForm').attr( "action", "pc001001apply.do");
	$('#queryForm').submit();
}
</script>
</head>
<body>
<form id="queryForm" action="" method="post" >
	<input name="empid" type="hidden"  value="${sessionScope.user.empid}" />
	<input name="empname" type="hidden"  value="${sessionScope.user.empname}" />  
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：申请管理&nbsp;&gt;&nbsp;申请单填写&nbsp;&gt;&nbsp;申请单填写一览</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark"><img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">申请单一览</td>
				</tr>
			</tbody>
		</table>	
	</div>
	<div class="div_search_content">
	  <table class="tb_search check_specialchar">
	    <tbody>
			<tr>
				<td class="td_key" width="8%" nowrap><font color="#ff0000">*</font><label class="message">申请单</label></td>
				<td class="td_value" width="26%">					
		        	<dict:select id="applytype" name="applytype" value="${searchCommand.applytype}" busiDictTypeId="OA_PC001_ApplyType" cssClass="input_select" nullLabel="请选择"></dict:select>
		        </td>
		        <td class="td_value" width="18%" nowrap>
					<input name="button" id="login" type="button" class="btn" value="申&nbsp;请" onClick="btn_apply();"> 
				</td>
				<td class="td_value" width="18%" nowrap>
				
				</td>
			</tr>
	    </tbody>
	  </table>
	</div>
</form>
</body>
</html>