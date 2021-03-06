<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
/*
*名       称: btn_save()
*输入参数: 无
*输出参数: 无
*机       能: 保存
*创 建  者: yuliang          
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function btn_save() {	
	if ( !$.fn.autovalidateForm("addForm") ){
		return;
	}	
	//检查该年度的年假是否生成
	var flg = false;
	var msgid;
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/checkAnnualVctn.do?flg='+escape(new Date())+'&year='+escape($("#year").val()),
		success:function(data){
			if(data.flag == true){
				msgid = data.msgid;				
				flg = false;
			}else{
				flg = true;
			}			
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			flg = false;
			return;
		}		
	});
	if(!flg){
		if(!window.confirm( Message.getString(msgid))){
			return;
		}		
	}else{
		if ( !window.confirm( Message.getString("MSG_IC_PA005_0001"))) 
			return;		
	}
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pa005003save.do");	
	$("#addForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2016-01-21
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#addForm").attr( "action", "pa005003back.do");	
	$("#addForm").submit();
}
$(document).ready(function(){	
	var dt = new Date().getFullYear().toString();
    var cnt = parseInt(dt) + 2;
    $('select[name="legalyear"]').append("<option value='' >请选择</option>");
 	for(var i=dt-1;i<cnt;i++){
	 	if(i==dt){
	 		$('select[name="year"]').append("<option value='" + i +  "'selected>" + i + "</option>");
	 	}else{
	    	$('select[name="year"]').append("<option value='" + i +  "'>" + i + "</option>");
    	}
    }
})
</script>
</head>
<body>
<form id="addForm" action="" method="post" >
	<input name="pa005001searchcommand.year" type="hidden"  value="${command.pa005001searchcommand.year}" />
	<input name="pa005001searchcommand.empname" type="hidden"  value="${command.pa005001searchcommand.empname}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;年假信息&nbsp;&gt;&nbsp;年假信息登录</span></div>
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
				<td class="td_key" width="8%" nowrap><font color="#ff0000">*</font><label class="message">年份</label></td>
				<td class="td_value">
					<select id="year" name="year" class="input_select" title="required">
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right">					
					<input name="search" id="search" type="button" class="btn" value="生&nbsp;成" onClick="btn_save();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>	
</form>
</body>
</html>