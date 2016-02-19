package com.lw.oa.pa.master.pa004;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA004Service {
	public List<?> pa004001search(PA004001SearchCommand searchCommand);
	public PA004Command pa004001view(PA004001SearchCommand searchCommand);
	public int pa004003save(PA004Command command, HttpServletRequest request);	
	public int pa004002update(PA004Command command, HttpServletRequest request);
	public int pa004002delete(PA004Command command, HttpServletRequest request);
}
