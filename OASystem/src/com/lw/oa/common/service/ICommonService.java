package com.lw.oa.common.service;

import java.util.List;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;
import com.lw.oa.common.command.ResultCommand;

/**
 **@author yuliang
 */
public interface ICommonService {
	public ResultCommand checkUserAndPwd(String username, String password, String orgcdid);
	public ApplyFormCommand expandApplyForm(ApplySearchCommand searchCommand);
	public ApplyFormCommand getMessageCount(String empid);
	public List<?> queryResourceByEmpid(String empid);
}
