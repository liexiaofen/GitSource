package com.lw.oa.common.util;

import javax.servlet.http.HttpServletRequest;
/**
 * *@author yuliang
 */
public class URIUtil {
	public static String getURI(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		StringBuffer basePath = new StringBuffer(scheme).append("://").append(serverName);
		if(!("http".equalsIgnoreCase(scheme) && port==80) && !("https".equalsIgnoreCase(scheme) && port==443)){
			basePath.append(":").append(port);
		}
		basePath.append(path).append("/");
		return basePath.toString();
	}
	
	public static String getPreForwardURI(HttpServletRequest request) {
		String priURI = (String)request.getAttribute("javax.servlet.forward.request_uri");
		if(priURI==null){
			priURI = request.getHeader("Referer");
		}
		return priURI;
	}
}