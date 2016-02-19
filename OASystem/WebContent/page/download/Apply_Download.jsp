<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="com.lw.oa.common.command.ApplyFormCommand,com.lw.oa.common.util.POIUtil" %>
<%
	out.clear();
	response.reset();

	try{
		//填充数据取得
		ApplyFormCommand command = (ApplyFormCommand)request.getAttribute("command");		
		//模板文件取得
		String tempPath = request.getSession().getServletContext().getRealPath("/");
		String tempFileName = POIUtil.getTemplateFileName(command.getApplytype());
		//判断模板文件是否存在
		java.io.File f=new java.io.File(tempPath+tempFileName);
		if(f.exists() && f.canRead()){
			POIUtil.applyFormDownload(response, tempPath, tempFileName, command);
		}else{
			System.out.println("文件不存在或无法打开");
		}
		return;
	}catch(Exception ex){
		out.clear();
		out = pageContext.pushBody();
		ex.printStackTrace();
	}
%>