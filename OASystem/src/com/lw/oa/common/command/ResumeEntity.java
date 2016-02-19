package com.lw.oa.common.command;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class ResumeEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 更新时间
	private String updatetime;
	// 操作履历id
	private String hisid;
	// 主id
	private String pid;
	// 操作者id
	private String operatorid;
	// 操作者名称
	private String operatorname;
	// 操作代码
	private String operationcd;
	// 操作代码业务字典
	private String operationcddict;
	// 查看标识
	private String viewflg;
	// 替换标识
	private String replaceflg;
	// 审批意见
	private String remark;

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getHisid() {
		return hisid;
	}

	public void setHisid(String hisid) {
		this.hisid = hisid;
	}	

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public String getOperationcd() {
		return operationcd;
	}

	public void setOperationcd(String operationcd) {
		this.operationcd = operationcd;
	}

	public String getOperationcddict() {
		return operationcddict;
	}

	public void setOperationcddict(String operationcddict) {
		this.operationcddict = operationcddict;
	}

	public String getViewflg() {
		return viewflg;
	}

	public void setViewflg(String viewflg) {
		this.viewflg = viewflg;
	}

	public String getReplaceflg() {
		return replaceflg;
	}

	public void setReplaceflg(String replaceflg) {
		this.replaceflg = replaceflg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}