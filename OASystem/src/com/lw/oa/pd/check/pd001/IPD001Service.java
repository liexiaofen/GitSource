package com.lw.oa.pd.check.pd001;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;
/**
 **@author yuliang
 */
public interface IPD001Service {
	public List<?> pd001001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pd001001view(ApplySearchCommand searchCommand);
	public int pd001003update(ApplyFormCommand command, HttpServletRequest request);
	public int pd001003delete(ApplyFormCommand command, HttpServletRequest request);
}
