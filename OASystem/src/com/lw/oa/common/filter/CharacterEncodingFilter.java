package com.lw.oa.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 采用Filter统一处理字符集.
 * 
 * @author yuliang
 * 
 */

public class CharacterEncodingFilter implements Filter {

	// 定义成员变量
	private String encoding;

	// 销毁.
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 过滤器真正执行的处理功能.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("CharacterEncodingFilter--begin");
		// 设置字符集
		request.setCharacterEncoding(encoding);
		// 设置字符集
		response.setCharacterEncoding(encoding);
		// 过滤链
		chain.doFilter(request, response);		
		// System.out.println("CharacterEncodingFilter--end");
	}

	/**
	 * 初始化过滤器，从配置文件中读取参数的内容
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
