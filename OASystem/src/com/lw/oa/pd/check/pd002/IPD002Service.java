package com.lw.oa.pd.check.pd002;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPD002Service {
	public List<?> pd002001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pd002001view(ApplySearchCommand searchCommand);
	public int pd002003update(ApplyFormCommand command, HttpServletRequest request);
	public int pd002003delete(ApplyFormCommand command, HttpServletRequest request);
}
