package com.lw.oa.pa.master.pa001;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA001Service {
	public int pa001003save( PA001Command command, HttpServletRequest request);
	public List<?> pa001001search(PA001001SearchCommand searchCommand);
	public PA001Command pa001001view(PA001001SearchCommand searchCommand);
	public int pa001002update(PA001Command command, HttpServletRequest request);
	public int pa001002delete(PA001Command command, HttpServletRequest request);
}
