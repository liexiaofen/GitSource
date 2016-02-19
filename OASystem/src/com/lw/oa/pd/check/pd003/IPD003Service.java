package com.lw.oa.pd.check.pd003;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPD003Service {
	public List<?> pd003001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pd003001view(ApplySearchCommand searchCommand);
	public int pd003003update(ApplyFormCommand command, HttpServletRequest request);
	public int pd003003delete(ApplyFormCommand command, HttpServletRequest request);
}
