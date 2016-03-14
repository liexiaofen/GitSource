package com.lw.oa.pc.apply.pc003;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;
/**
 **@author yuliang
 */
public interface IPC003Service {
	public List<?> pc003001search(ApplySearchCommand searchCommand);
	public ApplyFormCommand pc003001view(ApplySearchCommand searchCommand);
	public int pc003003update(ApplyFormCommand command, HttpServletRequest request);
	public int pc003003reject(ApplyFormCommand command, HttpServletRequest request);
	public int pc003003delete(ApplyFormCommand command, HttpServletRequest request);
}
