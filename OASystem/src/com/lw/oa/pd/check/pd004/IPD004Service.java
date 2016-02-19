package com.lw.oa.pd.check.pd004;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPD004Service {
	public List<?> pd004001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pd004001view(ApplySearchCommand searchCommand);
	public int pd004003update(ApplyFormCommand command, HttpServletRequest request);
	public int pd004003delete(ApplyFormCommand command, HttpServletRequest request);
}
