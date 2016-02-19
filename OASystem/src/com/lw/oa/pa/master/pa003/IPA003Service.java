package com.lw.oa.pa.master.pa003;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA003Service {
	public List<?> pa003001search(PA003001SearchCommand searchCommand);
	public PA003Command pa003001view(PA003001SearchCommand searchCommand);
	public int pa003003save(PA003Command command, HttpServletRequest request);	
	public int pa003002update(PA003Command command, HttpServletRequest request);
}
