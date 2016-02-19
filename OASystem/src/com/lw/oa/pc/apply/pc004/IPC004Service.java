package com.lw.oa.pc.apply.pc004;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;

/**
 **@author yuliang
 */
public interface IPC004Service {
	public List<?> pc004001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pc004001view(ApplySearchCommand searchCommand);
	public int pc004001file(ApplySearchCommand searchCommand, HttpServletRequest request);
}
