package com.lw.oa.pc.apply.pc002;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPC002Service {
	public List<?> pc002001search(ApplySearchCommand searchCommand);
	public int pc002003update(ApplyFormCommand command, HttpServletRequest request);
	public int pc002003delete(ApplyFormCommand command, HttpServletRequest request);
}
