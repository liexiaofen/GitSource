package com.lw.system.framework.fa002;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
/**
 **@author yuliang
 */
public interface IFA002Service {
	public List<?> fa002001search(FA002001SearchCommand searchCommand);
	public int fa002001delete( FA002001SearchCommand searchCommand, HttpServletRequest request);
	public int fa002001setAuthority( FA002001SearchCommand searchCommand, HttpServletRequest request);	
	public int fa002002update( FA002Command command, HttpServletRequest request);
	public int fa002002insert( FA002Command command, HttpServletRequest request);
}
