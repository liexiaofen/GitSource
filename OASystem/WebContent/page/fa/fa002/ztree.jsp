<%@page language="java" import="com.lw.oa.common.util.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../pgcommon/head.jsp"%>
<%
	String basePath = URIUtil.getURI(request);
	int num = 0;
%>
<base href="<%=basePath%>">
<!-- ZTree树形插件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/zTreeStyle/zTreeIcons.css" type="text/css">  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript">
var zTree;//定义Ztree对象	
var setting = {
	check:{
		enable:true//是否有复选框：true?false			
	},
	view:{
		dblClickExpand:true,//设置是否双击鼠标左键打开			
		selectedMulti:false,
		showLine:true//是否允许有连接线
	},		
	data:{
		simpleData:{
			enable:true,
			idKey:"id",//设置字段ID格式
			pIdKey:"pid",//设置父ID的格式
			rootPId:"0"
		}
	},				
	edit:{
		enable:false //是否允许编辑
	}
};		
//定义Ztree的节点数组
var zNodes = [
	{id:0, name:"菜单管理", open:true},		
	{id:1, pid:0, name:"基本功能演示"},
	{id:101, pid:1, name:"基本功能演示11", file:"hao123.com"},
	{id:102, pid:1, name:"基本功能演示12", file:"baidu.com"},		
	{id:2, pid:0, name:"基本功能演示"},
	{id:101, pid:2, name:"基本功能演示21", file:"hao123.com"},
	{id:102, pid:2, name:"基本功能演示22", file:"baidu.com"}
];

$(document).ready(function(){		
	var roleid = $('#roleid').val();
	$.ajax({	
		async : false, 
        cache:false,  
        type: "get",  
        dataType : "json",  //返回json格式	    
        url: '<%= request.getContextPath()%>/common/ajax/getResourcesByRoleid.do?flg='+escape(new Date())+'&roleid='+escape(roleid),//请求的URL路径  
        beforeSend:	function(){ 
        				//alert("Jquery ajax正在获取后台json数据");
        			}, 
        success:
        	function(data){ //请求成功后处理函数。  	
	         	//请求后返回的json是字符串，需要用eval()函数转换成Object类型
	           	zNodes = eval(data);			        
	        },
        error:	function(){//请求失败处理函数  
        			alert(Message.getString("ERROR_COMM_0037")); 
        		} 
	 });		
	zTree = $.fn.zTree.init( $("#tree"), setting, zNodes);		
	zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id", "102"));
});
/*
*名       称: btn_save()
*输入参数: 无
*输出参数: 无
*机       能: 保存
*创 建  者: yuliang          
*创建时间: 2016-06-01
*更 新  者: 
*更新时间: 
*/
function btn_save(){
	var check = zTree.getCheckedNodes(true);
	if ( $(check).length < 1 ) {
		alert(Message.getString("MSG_COMM_0031"));
		return;
	}
	if ( !window.confirm( Message.getString("MSG_IC_COMM_0002"))) 
		return;
	var roleid = $('#roleid').val();
	$(check).each(function( index, value){
		$("#updateForm").append("<input name=\"roleresource["+index+"].roleid\" value=\""+roleid+"\" type=\"hidden\" />");
		$("#updateForm").append("<input name=\"roleresource["+index+"].resourceid\" value=\""+value.id+"\" type=\"hidden\" />");
	});
	c_ShowProgressBar();	
	$("#updateForm").attr( "action", "fa002001setAuthority.do");	
	$("#updateForm").submit();
}
</script>
</head>
<body>
	<form id="updateForm" action="" method="post" > 
		<input type="hidden" id="roleid" name="roleid" value='<%=request.getParameter("roleid") %>' />
		<ul id="tree" class="ztree"></ul>
		<span style="margin-left: -200;margin-top: 200">
			<input name="save" id="save" type="button" class="btn" value="保&nbsp;存" onClick="btn_save();"/>
		</span>
	</form>
</body>
</html>