package com.lw.system.framework.fa004;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
/**
 **@author yuliang
 */
public interface IFA004Service {
	public List<?> fa004001search(FA004001SearchCommand searchCommand);
	public int fa004001delete(FA004001SearchCommand searchCommand, HttpServletRequest request);
	public int fa004003insert(FA004Command command, HttpServletRequest request);
}
