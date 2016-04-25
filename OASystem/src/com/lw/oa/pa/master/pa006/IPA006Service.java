package com.lw.oa.pa.master.pa006;

import javax.servlet.http.HttpServletRequest;

/**
 **@author yuliang
 */
public interface IPA006Service {
	public PA006Command pa006001view(String empid);
	public int pa006001save(PA006Command command, HttpServletRequest request);
}
