package com.lw.oa.common.command;

import com.lw.oa.common.command.ApplyResultCommand;
import com.lw.oa.common.model.ApplyForm;
import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class ApplySearchCommand extends Pager<ApplyResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplyForm[] applyform; 
	private ApplyFormCommand[] applyformcommand;
	// 申请单号
	private String applyno;
	// 申请类型
	private String applytype;
	// 状态
	private String status;
	// 状态
	private String statusalias;	
	// 员工id
	private String empid;
	// 申请id
	private String applyid;
	// 排他标识
	private String exclusivefg;
	// 查询结果申请类型
	private String applytype_result;
	
	public ApplyFormCommand[] getApplyformcommand() {
		return applyformcommand;
	}

	public void setApplyformcommand(ApplyFormCommand[] applyformcommand) {
		this.applyformcommand = applyformcommand;
	}

	public ApplyForm[] getApplyform() {
		return applyform;
	}

	public void setApplyform(ApplyForm[] applyform) {
		this.applyform = applyform;
	}

	public String getApplyno() {
		return applyno;
	}

	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusalias() {
		return statusalias;
	}

	public void setStatusalias(String statusalias) {
		this.statusalias = statusalias;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getApplytype_result() {
		return applytype_result;
	}

	public void setApplytype_result(String applytype_result) {
		this.applytype_result = applytype_result;
	}

}
