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
			enable:false//是否有复选框：true?false			
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
		callback:{
			/*beforeClick:function(treeid, treeNode){
				var zTree=$.fn.zTree.getZTreeObj("tree");
				if(treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					//window.location.href = treeNode.file;
					//alert(treeid);
					return true;
				}
			},*/
			onClick:zTreeOnClick//鼠标单击事件
		},
		edit:{
			enable:false //是否允许编辑
		}
	};	
	function zTreeOnClick(event, treeId, treeNode) {
		//alert(treeNode.id+","+treeNode.name);
		if(treeNode.id == '0'){
			window.parent.document.getElementById('right').src = '<%=request.getContextPath()%>/fa001001init.do';
		}else{
			window.parent.document.getElementById('right').src = '<%=request.getContextPath()%>/fa001001edit.do?flg='+escape(new Date())+'&id='+escape(treeNode.id);
		}	    
	}
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
		$.ajax({	
			async : false, 
	        cache:false,  
	        type: "get",  
	        dataType : "json",  //返回json格式	    
	        url: "<%= request.getContextPath()%>/common/ajax/getResources.do",//请求的URL路径  
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
</script>
</head>
<body>
	<ul id="tree" class="ztree"></ul>
</body>
</html>