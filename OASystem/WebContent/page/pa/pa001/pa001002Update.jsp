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
*创建时间: 2015-09-14
*更 新  者: 
*更新时间: 
*/
function btn_update() {
	if ( !$.fn.autovalidateForm("updateForm") ){
		return;
	}	
	//检查用户名唯一性
	var flg = false;
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:'<%= request.getContextPath()%>/common/ajax/checkUniqueUsername.do?flg='+escape(new Date())+'&username='+escape($("#username").val())+'&empid='+escape($("#empid").val()),
		success:function(data){
			if(data.flag == true){
				var msgid = data.msgid;
				alert(Message.getString(msgid)); 
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
	if(flg){
		if ( !window.confirm( Message.getString("MSG_IC_COMM_0011"))) 
			return;
		c_ShowProgressBar(); 
		$("#updateForm").attr( "action", "pa001002update.do");	
		$("#updateForm").submit();	
	}
}
/*
*名       称: btn_delete()
*输入参数: 无
*输出参数: 无
*机       能: 删除
*创 建  者: yuliang          
*创建时间: 2015-10-14
*更 新  者: 
*更新时间: 
*/
function btn_delete() {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0003"))) 
		return;
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa001002delete.do");	
	$("#updateForm").submit();	
}
/*
*名       称: btn_back()
*输入参数: 无
*输出参数: 无
*机       能: 返回
*创 建  者: yuliang          
*创建时间: 2015-09-16
*更 新  者: 
*更新时间: 
*/
function btn_back() {	
	c_ShowProgressBar(); 
	$("#updateForm").attr( "action", "pa001002back.do");	
	$("#updateForm").submit();
}
/*
*名       称: btn_orgListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 打开模式窗口
*创 建  者: yuliang          
*创建时间: 2015-11-12
*更 新  者: 
*更新时间: 
*/
function btn_orgListSearch() {		
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchOrgList.do';
	obj.navi = '主表管理 > 员工信息 > 机构信息一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url, obj);	
	if(ret){
		if(ret[0]){
			document.getElementById("orgcddepposids").value = ret[0];			
			var str = ret[1].split(",");
			var text = '';
			for(var i=0; i<str.length; i++){
				text += str[i] + '<br/>';
			}
			$("#orgcddepposes").html(text);
		}
	}
}
/*
*名       称: btn_roleListSearch()
*输入参数: 无
*输出参数: 无
*机       能: 角色查询
*创 建  者: yuliang          
*创建时间: 2015-12-31
*更 新  者: 
*更新时间: 
*/
function btn_roleListSearch() {
	c_ShowProgressBar(1); 
	var obj = new Object();
	obj.url = 'common/zoom/searchRoleList.do';
	obj.navi = '主表管理 > 员工信息 > 角色信息一览';
	var ret = selectZoom( '<%= request.getContextPath()%>/'+obj.url, obj);
	if(ret){
		if(ret[0]){
			document.getElementById("roleids").value = ret[0];
			document.getElementById("roles").value = ret[1];	
		}
	}
}
/*
*名       称: btn_clear(obj)
*输入参数: obj
*输出参数: 无
*机       能: 清空
*创 建  者: yuliang          
*创建时间: 2015-12-07
*更 新  者: 
*更新时间: 
*/
function btn_clear(obj) {
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0021"))) 
		return;
	$(obj).parent().find(":text").each(function(i,n){
		$(n).val('');
	});
	$(obj).parent().find(":hidden").each(function(i,n){
		$(n).val('');
	});
	$(obj).parent().find("textarea").each(function(i,n){
		$(n).val('');
	});
}
$(document).ready(function(){	
	var str = '<c:out value="${command.orgcddepposes}"></c:out>';
	var arr = str.split(",");
	var text = '';
	for(var i=0; i<arr.length; i++){
		text += arr[i] + '<br/>';
	}
	$("#orgcddepposes").html(text);
});
</script>
</head>
<body>
<form id="updateForm" action="" method="post">  
	<input id="empid" name="empid" type="hidden"  value="${command.empid}"/>
	<input name="exclusivefg" type="hidden"  value="${command.exclusivefg}"/>	
	<input name="pa001001searchcommand.empname" type="hidden"  value="${command.pa001001searchcommand.empname}" />
	<input name="pa001001searchcommand.entrytimestart" type="hidden"  value="${command.pa001001searchcommand.entrytimestart}" />
	<input name="pa001001searchcommand.entrytimeend" type="hidden"  value="${command.pa001001searchcommand.entrytimeend}" />
	<input name="pa001001searchcommand.status" type="hidden"  value="${command.pa001001searchcommand.status}" />
	<input name="pa001001searchcommand.orgcdid" type="hidden"  value="${command.pa001001searchcommand.orgcdid}" />
	<input name="pa001001searchcommand.depid" type="hidden"  value="${command.pa001001searchcommand.depid}" />
	<div class="div_navi"><span><img src="<%= request.getContextPath()%>/resources/images/home.png">&nbsp;您当前的位置：主表管理&nbsp;&gt;&nbsp;员工信息&nbsp;&gt;&nbsp;员工信息编辑</span></div>
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
					<font color="#ff0000">*</font><label class="message">姓名</label>
				</td>
				<td class="td_value" width="26%">
					<input name="empname" class="input_txt" value="${command.empname}" maxlength="20" title="required" />
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">英文名</label>
				</td>
				<td class="td_value" width="26%">
					<input name="empenname" class="input_txt" value="${command.empenname}" maxlength="20" title="required" />
				</td>
				<td class="td_key" width="8%">
					<label class="message">分机</label>
				</td>
				<td class="td_value">
					<input name="extension" class="input_txt" value="${command.extension}" maxlength="20"  title='tel' />
				</td>								
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">直线</label>
				</td>
				<td class="td_value">
					<input name="straightline" class="input_txt" value="${command.straightline}" maxlength="20"  title="tel" />
				</td>
				<td class="td_key" width="8%"><label class="message">SKYPE號</label></td>
				<td class="td_value"  width="26%">
					<input id="skypenum" name="skypenum" class="input_txt" value="${command.skypenum}" maxlength="32"  title="ascii" />
				</td>
				<td class="td_key" width="8%">
					<label class="message">国际电话</label>
				</td>
				<td class="td_value" width="26%">
					<input name="internttel" class="input_txt" value="${command.internttel}" maxlength="11"  title="mobile" />
				</td>							
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<label class="message">国内电话</label>
				</td>
				<td class="td_value" width="26%">
					<input name="domestictel" class="input_txt" value="${command.domestictel}" maxlength="11"  title="mobile" />
				</td>	
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">email</label>
				</td>
				<td class="td_value" width="26%">
					<input id="email" name="email" class="input_txt" value="${command.email}" maxlength="30"  title="required,email" />
				</td>
				<td class="td_key" width="8%">
					<label class="message">身份证号</label></td>
				<td class="td_value"  width="26%">
					<input id="cardno" name="cardno" class="input_txt dis_input" value="${command.cardno}" maxlength="18"  readonly="readonly"/>
				</td>							
			</tr>			
			<tr>
				<td class="td_key" width="4%"><font color="#ff0000">*</font><label class="message">角色</label></td>
				<td class="td_value" colspan="3">
					<input id="roles" name="roles" value="${command.roles}" class="input_bigger1" readonly="readonly" title='required'/>
					<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_roleListSearch()" />
					<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear(this)">
					<input id="roleids" name="roleids" type="hidden" value="${command.roleids}"/>
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">员工号</label>
				</td>
				<td class="td_value">
					<input id="empno" name="empno" class="input_txt" value="${command.empno}" maxlength="10"  title="required" />
				</td>			
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">入职时间</label></td>
				<td class="td_value" width="26%">
					<input id="entrytime"  name="entrytime" class="input_date Wdate" value="${command.entrytime}" readonly="readonly" onclick="WdatePicker()" title='required'/>
				</td>
				<td class="td_key" width="8%"><label class="message">状态</label></td>
				<td class="td_value">
					<dict:select id="status" name="status" value="${command.status}" busiDictTypeId="OA_PA001_Status" cssClass="input_select"></dict:select>
				</td>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">性别</label>
				</td>
				<td class="td_value">
					<dict:select id="sex" name="sex" busiDictTypeId="OA_COMMON_Gender" value="${command.sex}" cssClass="input_select" nullLabel="请选择" title='required' ></dict:select>
				</td>				
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">工龄</label>
				</td>
				<td class="td_value" colspan="5">
					<input id="workage" name="workage" class="input_txt input_num2" value="${command.workage}" maxlength="2"  title="required,intege1" />
				</td>			
			</tr>
			<tr>
				<td class="td_key" width="8%">
					<font color="#ff0000">*</font><label class="message">机构</label>
				</td>
				<td class="td_value" colspan="5">
					<textarea id="orgcddepposes" name="orgcddepposes"  class="input_memo_long" readonly="readonly" title='required'>
					</textarea>
					<input name="search" id="search" type="button" class="btn" value="选&nbsp;择" onClick="btn_orgListSearch()" />
					<input name="reset" id="reset" type="button" class="btn" value="清&nbsp;空" onclick="btn_clear(this)">
					<input id="orgcddepposids" name="orgcddepposids" type="hidden" value="${command.orgcddepposids}"/>
					
				</td>
				
			</tr>			
	    </tbody>
	  </table>
	</div>
	<div class="div_search_title">
		<table class="tb_title">
			<tbody>
				<tr class="tr_caption">
					<td class="td_caption_mark">
						<img src="<%= request.getContextPath()%>/resources/images/m_nav_dian.gif"></img>
					<td class="td_caption">
						操作员信息
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
					<font color="#ff0000">*</font><label class="message">用户登录名</label>
				</td>
				<td class="td_value">
					<input id="username" name="username" class="input_txt" value="${command.username}" maxlength="20"  title="required,ascii" />
					<input id="password" name="password" value="${command.password}" type="hidden" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">					
					<input name="search" id="search" type="button" class="btn" value="修&nbsp;改" onClick="btn_update();"/>
					<input name="search" id="search" type="button" class="btn" value="删&nbsp;除" onClick="btn_delete();"/>
					<input name="button" id="reset" type="button" class="btn" value="返&nbsp;回" onClick="btn_back();" />
				</td>
	      	</tr>
	    </tbody>
	  </table>
	</div>
</form>
</body>
</html>