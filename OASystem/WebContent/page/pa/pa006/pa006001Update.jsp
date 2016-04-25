<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/pwdstrength.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pwdstrength.js"></script>
<%
	String basePath = URIUtil.getURI(request);
%>
<base href="<%=basePath%>">
<script type="text/javascript">
var PasswordStrenth = 0;
function change_pwstrength(Pwd) {
	//长度大于等于6时开始判断
	if (Pwd.length >= 6) {
		if (ClientStrongPassword(Pwd, gSimilarityMap,gDictionary)) {				
			document.getElementById('weak').className = 'pwd_strong1';
	        document.getElementById('middle').className = 'pwd_strong1';
			document.getElementById('strong').className = 'pwd_strong';
			PasswordStrenth = 6;
		} else if (ClientMiddlePassword(Pwd, gSimilarityMap,gDictionary)) {
			document.getElementById('weak').className = 'pwd_middle1';
	        document.getElementById('middle').className = 'pwd_middle';
			document.getElementById('strong').className = 'pwd_default';
			PasswordStrenth = 4;
		} else if (ClientWeakPassword(Pwd, gSimilarityMap,gDictionary)) {
			document.getElementById('weak').className = 'pwd_weak';
	        document.getElementById('middle').className = 'pwd_default';
			document.getElementById('strong').className = 'pwd_default';
			PasswordStrenth = 2;
		} else{
			document.getElementById('weak').className = 'pwd_default';
	        document.getElementById('middle').className = 'pwd_default';
			document.getElementById('strong').className = 'pwd_default';
		}
	 }else{
		document.getElementById('weak').className = 'pwd_default';
        document.getElementById('middle').className = 'pwd_default';
		document.getElementById('strong').className = 'pwd_default';
		PasswordStrenth = 0;//无强度等级
	}
}
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
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}
	//原密码验证
	var password = $("#updateForm").find("input[name='password']").val();
	var oldpassword = $("#updateForm").find("input[name='oldpassword']").val();
	if(password != oldpassword){
		alert(Message.getString("ERROR_PA006_0001"));
		$("#updateForm").find("input[name='oldpassword']").val('');
		$("#updateForm").find("input[name='oldpassword']").focus();
		return;
	}
	var newpassword = $("#updateForm").find("input[name='newpassword']").val();
	//原密码新密码验证
	if(newpassword == oldpassword){
		alert(Message.getString("ERROR_PA006_0003"));
		$("#updateForm").find("input[name='newpassword']").val('');
		$("#updateForm").find("input[name='newpasswordconfirm']").val('');
		$("#updateForm").find("input[name='newpassword']").focus();
		return;
	}
	//新密码和确认新密码验证	
	var newpasswordconfirm = $("#updateForm").find("input[name='newpasswordconfirm']").val();
	if(newpassword != newpasswordconfirm){
		alert(Message.getString("ERROR_PA006_0002"));
		$("#updateForm").find("input[name='newpassword']").val('');
		$("#updateForm").find("input[name='newpasswordconfirm']").val('');
		$("#updateForm").find("input[name='newpassword']").focus();
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0002"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa006001save.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_clear()
*输入参数: 无
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2016-04-25
*更 新  者: 
*更新时间: 
*/
function btn_clear() {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		updateForm;
	$("#updateForm").find("input[type='text']").val('');
	$("#updateForm").find("input[type='password']").val('');
	$("#updateForm").find("select").each(function(i,n){
		$(n).val('');
	});
	document.getElementById('weak').className = 'pwd_default';
    document.getElementById('middle').className = 'pwd_default';
	document.getElementById('strong').className = 'pwd_default';
}
</script>
</head>
<body>
<form id="updateForm" action="" method="post" >
	<input name="empid" type="hidden"  value="${command.empid}" />
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}" />
	<input name="password" type="hidden"  value="${command.password}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;密码设置&nbsp;&gt;&nbsp;密码修改</span></div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						密码修改
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
						<font color="#ff0000">*</font><label class="message">原密码</label>
					</td>
					<td class="td_value" width="26%">
						<input id="oldpassword" name="oldpassword" class="input_txt" maxlength="20"  title="required" />
					</td>
				</tr>
				<tr>
					<td class="td_key" width="8%">
						<font color="#ff0000">*</font><label class="message">新密码</label>
					</td>
					<td class="td_value" width="26%">
						<input id="newpassword" name="newpassword" type="password" class="input_txt" onkeyup="change_pwstrength(this.value)" onchange="change_pwstrength(this.value)" maxlength="20"  title="required,password" />
					</td>
				</tr>
				<tr>
					<td class="td_key" width="8%">新密码强度</td>
					<td class="td_value" width="26%">
						<table class="tb_title" style="width: 20%">
							<tr>
								<td width="14%" id="weak" class="pwd_default" align=center>低</td>						
								<td width="9%" id="middle" class="pwd_default" align=center>中</td>						
								<td width="12%" id="strong" class="pwd_default" align=center>高</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="td_key" width="8%">
						<font color="#ff0000">*</font><label class="message">确认新密码</label>
					</td>
					<td class="td_value" width="26%">
						<input id="newpasswordconfirm" name="newpasswordconfirm" type="password" class="input_txt" maxlength="20"  title="required" />
					</td>
				</tr>
				<tr>
					<td class="td_key" width="8%">
						新密码规则
					</td>
					<td class="td_value">
						<font color="#ff0000">新密码必须包含数字、字母、和特殊字符（!@#$） 三种，并且长度在6-8之间。</font>
					</td>				
				</tr>
				<tr>
					<td colspan="2" align="right">					
						<input name="search" id="search" type="button" class="btn" value="保&nbsp;存" onClick="btn_save();"/>
						<input name="button" id="reset" type="button" class="btn" value="清&nbsp;空" onClick="btn_clear();" />
					</td>
		      	</tr>
		      </tbody>
	  	</table>
	</div>	
</form>
</body>
</html>