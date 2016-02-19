package com.lw.oa.pa.master.pa005;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA005Service {
	public List<?> pa005001search(PA005001SearchCommand searchCommand);
	public PA005Command pa005001view(PA005001SearchCommand searchCommand);
	public int pa005003save(PA005Command command, HttpServletRequest request);	
	public int pa005004update(PA005Command command, HttpServletRequest request);
}
