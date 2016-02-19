package com.lw.oa.pd.check.pd005;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPD005Service {
	public List<?> pd005001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pd005001view(ApplySearchCommand searchCommand);
	public int pd005001file(ApplySearchCommand searchCommand, HttpServletRequest request);
}
