package com.lw.oa.pb.daily.pb001;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPB001Service {
	public List<?> pb001001search(PB001001SearchCommand searchCommand, PB001001ResultTitleCommand title);
	public PB001001ResultTitleCommand getLegalDateListByWeek( PB001001SearchCommand searchCommand);	
	public PB001Command pb001001edit(PB001001SearchCommand searchCommand);	
	public PB001Command pb001001month(PB001001SearchCommand searchCommand);	
	public int pb001003save(PB001Command command, HttpServletRequest request);	
	public int pb001002update(PB001Command command, HttpServletRequest request);
	public int pb001002cancel(PB001Command command, HttpServletRequest request);
}
