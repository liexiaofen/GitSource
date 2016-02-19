<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/menu.js"></script>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/menu.css"/>
</head>
<body>
	<div id="left_menu">
		<ul id="nav_dot">
	      	<li>
	        	<h4 class="M1"><span></span>主表管理</h4>
	        	<div class="list-item none">
		            <a href='<%=request.getContextPath()%>/pa001001init.do' target="mainFrame">员工信息</a>
		            <a href='<%=request.getContextPath()%>/pa002001init.do' target="mainFrame">设备信息</a>
		            <a href='<%=request.getContextPath()%>/pa003001init.do' target="mainFrame">法定日信息</a>
		            <a href='<%=request.getContextPath()%>/pa004001init.do' target="mainFrame">机构信息</a>
		            <a href='<%=request.getContextPath()%>/pa005001init.do' target="mainFrame">年假信息</a>
		            <a href='design.jsp' target="mainFrame">用户群信息</a>
					<a href='design.jsp' target="mainFrame">密码修改</a>	
	          	</div>
	        </li>
	        <li>
	          	<h4 class="M2"><span></span>日程管理</h4>
	          	<div class="list-item none">
	            	<a href='<%=request.getContextPath()%>/pb001001init.do' target="mainFrame">日程安排</a>    
	            	<a href='design.jsp' target="mainFrame">设备空闲</a>	 
	           	</div>
	        </li>
	        <li>
	        	<h4 class="M3"><span></span>申请管理</h4>
				<div class="list-item none">
					<a href='<%=request.getContextPath()%>/pc001001init.do' target="mainFrame">申请单填写</a>
					<a href='<%=request.getContextPath()%>/pc002001init.do' target="mainFrame">申请管理</a>  	
					<a href='<%=request.getContextPath()%>/pc003001init.do' target="mainFrame">审核管理</a> 
					<a href='<%=request.getContextPath()%>/pc004001init.do' target="mainFrame">人事归档</a>	 					
				</div>
			</li><%--
			<li><h4 class="M4"><span></span>审核管理</h4>
				<div class="list-item none">
					<a href='<%=request.getContextPath()%>/pd001001init.do' target="mainFrame">部门经理审核</a>
					<a href='<%=request.getContextPath()%>/pd002001init.do' target="mainFrame">人事审核</a>
					<a href='<%=request.getContextPath()%>/pd003001init.do' target="mainFrame">副总审核</a>
					<a href='<%=request.getContextPath()%>/pd004001init.do' target="mainFrame">总经理审核</a>
										
				</div>
			</li> --%>
			<li><h4 class="M4"><span></span>系统管理</h4>
				<div class="list-item none">
					<a href='design.jsp' target="mainFrame">菜单信息</a>
					<a href='design.jsp' target="mainFrame">角色信息</a>
					<a href='design.jsp' target="mainFrame">权限绑定</a>
					<a href='design.jsp' target="mainFrame">业务字典信息</a>          	
				</div>
			</li>
        </ul>
	</div>
	<script type="text/javascript">navList();</script> 
</body>
</html>