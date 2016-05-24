package com.lw.system.framework.fa001;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
/**
 **@author yuliang
 */
public interface IFA001Service {
	public List<?> fa001001search(FA001001SearchCommand searchCommand);
	public int fa001001delete( FA001001SearchCommand searchCommand, HttpServletRequest request);
	public FA001Command fa001001view( FA001001SearchCommand searchCommand);
	public int fa001002update( FA001Command command, HttpServletRequest request);
	public int fa001003insert( FA001Command command, HttpServletRequest request);
}
