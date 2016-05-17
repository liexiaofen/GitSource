<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2016-05-12
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "fa004003back.do");	
	$("#updateForm").submit();
}

</script>
</head>
<body>
<form id="updateForm" action="" method="post" >  
	<input name="searchCommand.busidicttypeid" type="hidden"  value="${command.searchCommand.busidicttypeid}" />
	<input name="searchCommand.busidicttypename" type="hidden"  value="${command.searchCommand.busidicttypename}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：系统管理&nbsp;&gt;&nbsp;业务字典信息&nbsp;&gt;&nbsp;业务字典信息明细</span></div>
	<div class="div_search_title" style="width: 50%">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						类型信息
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content" style="width: 50%">
	  <table class="tb_search">
	    <tbody>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">类型代码</label>
				</td>
				<td class="td_value" width="26%">
					<input id="busidicttypeid" name="busidicttypeid" value="${command.busidicttypeid}" class="input_txt dis_input" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">类型名称</label>
				</td>
				<td class="td_value">
					<input id="busidicttypename" name="busidicttypename" value="${command.busidicttypename}" class="input_txt dis_input" readonly="readonly"/>
				</td>	
			</tr>
	    </tbody>
	  </table>
	</div>	
	<div class="div_search_title" style="width: 50%">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						类型项信息
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="div_search_content" style="width: 50%">
	  <table id="tresult" class="pg_result">				
			<tr class="pg_result_head">
				<td width="35%">&nbsp;类型项代码&nbsp;</td>
				<td width="35%">&nbsp;类型项名称&nbsp;</td>
				<td width="20%">&nbsp;排序&nbsp;</td>
				<td width="10%">&nbsp;操作&nbsp;</td>	
			</tr>
			<tbody id="body_result">
				<c:forEach items="${command.list}" var="iterator">		    	
					<tr class="pg_result_content">		    			
						<td align="left" nowrap>${iterator.busidictid}</td>
						<td align="left" nowrap>${iterator.busidictname}</td>	
						<td align="left" nowrap>${iterator.sortno}</td>
						<td align="center" nowrap>				
						</td>	
					</tr>	
				</c:forEach>										
			</tbody>
  		</table>
	</div>
	<div class="div_result_button">
		<table>
			<tr>
				<td colspan="4" align="right">					
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
		</table>
	</div>	
</form>
</body>
</html>