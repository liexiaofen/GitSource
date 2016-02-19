package com.lw.oa.common.service;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ResultCommand;

/**
 **@author yuliang
 */
public interface ICommonService {
	public ResultCommand checkUserAndPwd(String username, String password, String orgcdid);
	public ApplyFormCommand expandApplyForm(String applyid, String exclusivefg, String applytype);
	public ApplyFormCommand getMessageCount(String empid);
}
