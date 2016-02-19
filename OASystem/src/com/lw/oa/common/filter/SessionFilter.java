package com.lw.oa.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 采用Filter统一处理session超时.
 * 
 * @author yuliang
 * 
 */
public class SessionFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		// 登陆url
		String loginUrl = httpRequest.getContextPath() + "/index.jsp";
		String url = httpRequest.getRequestURI();		
		if (url.indexOf("common/login/init.do") != -1 || url.indexOf("common/login/login.do") != -1 
				|| session.getAttribute("user") != null) {			
			chain.doFilter(request, response);
		} else {
			// 超时处理，ajax请求超时设置超时状态，页面请求超时则返回提示并重定向
			// 判断是否为ajax请求
			if (httpRequest.getHeader("x-requested-with") != null && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
				httpResponse.addHeader("sessionstatus", "timeOut");
				httpResponse.addHeader("loginPath", loginUrl);
				chain.doFilter(request, response);
			} else {
				String str = "<script language='javascript'>alert('会话过期，请重新登录！');"
						+ "parent.window.location.href='" + loginUrl + "';</script>";
				// 设置编码方式
				response.setContentType("text/html;charset=UTF-8");
				try {
					PrintWriter writer = response.getWriter();
					writer.write(str);
					writer.flush();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
