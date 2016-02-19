package com.lw.oa.pa.master.pa002;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA002Service {
	public List<?> pa002001search(PA002001SearchCommand searchCommand);
	public PA002Command pa002001view(PA002001SearchCommand searchCommand);
	public int pa002003save(PA002Command command, HttpServletRequest request);	
	public int pa002002update(PA002Command command, HttpServletRequest request);
	public int pa002002delete(PA002Command command, HttpServletRequest request);
}
