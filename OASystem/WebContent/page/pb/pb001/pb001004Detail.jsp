<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_close()
*输入参数: 无
*输出参数: 无
*机       能: 关闭
*创 建  者: yuliang          
*创建时间: 2015-11-05
*更 新  者: 
*更新时间: 
*/
function btn_close() {
	window.close(); 
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post">  
	<input name="eventid" type="hidden"  value="${command.eventid}"/>
	<input name="eventexclusivefg" type="hidden"  value="${command.eventexclusivefg}"/>
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：日程管理&nbsp;&gt;&nbsp;日程安排&nbsp;&gt;&nbsp;日程安排详细</span></div>
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
				<td class="td_key" width="4%"><label class="message">发起人</label></td>
				<td class="td_value">
					<input class="input_bigger dis_input" value="${command.originatename} ${command.createtime}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%"><label class="message">更新人</label></td>
				<td class="td_value">
					<input class="input_bigger dis_input" value="${command.updator} ${command.updatetime}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">定期模式</label>
				</td>
				<td class="td_value" >
					<input id="dailycycle" name="dailycycle" class="input_txt dis_input" value="${command.dailycycledict}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">事件类型</label>
				</td>
				<td class="td_value" >
					<input id="eventtype" name="eventtype" class="input_txt dis_input" value="${command.eventtypedict}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<font color="#ff0000">*</font><label class="message">日期和时间</label>
				</td>
				<td class="td_value">
					<input id="daily" name="daily" class="input_txt dis_input" value="${command.dailystarttime}" readonly="readonly"/>&nbsp;~
					<input class="input_txt dis_input" value="${command.dailyendtime}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%"><font color="#ff0000">*</font><label class="message">标题</label></td>
				<td class="td_value">
					<input id="title" name="title" class="input_bigger1 dis_input" value="${command.title}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%"><label class="message">设备</label></td>
				<td class="td_value">
					<input id="eventdevices" name="eventdevices" class="input_bigger1 dis_input" readonly="readonly" value="${command.eventdevices}"/>
				</td>
			</tr>			
	    	<tr>
				<td class="td_key" width="4%">
					<label class="message">内容</label>
				</td>
				<td class="td_value" >
					<textarea id="comment" name="comment"  class="input_memo_long dis_input" readonly="readonly">${command.comment}</textarea>	
				</td>
			</tr>
			<tr>
				<td class="td_key" width="4%">
					<label class="message">参加者</label>
				</td>
				<td class="td_value" >
					<textarea id="eventconnects" name="eventconnects"  class="input_memo_long dis_input" readonly="readonly">${command.eventconnects}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input name="search" id="search" type="button" class="btn" value="关&nbsp;闭" onClick="btn_close()"/>
				</td>
	      	</tr>		
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>