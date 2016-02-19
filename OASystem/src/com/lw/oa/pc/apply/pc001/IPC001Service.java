package com.lw.oa.pc.apply.pc001;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPC001Service {
	public PC001Command pc001001apply(PC001001SearchCommand searchCommand);
	public int pc001002save( PC001Command command, HttpServletRequest request);
}
