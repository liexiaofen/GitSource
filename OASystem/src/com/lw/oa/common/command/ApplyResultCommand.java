package com.lw.oa.common.command;

import java.io.Serializable;

public class ApplyResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 更新日
	private String updatetime;
	// 排他标识
	private String exclusivefg;
	// 申请id
	private String applyid;
	// 申请单号
	private String applyno;
	// 申请人id
	private String applyempid;
	// 申请人
	private String applyempname;
	// 处理人id
	private String processempid;
	// 处理人
	private String processempname;
	// 处理时间
	private String processtime;
	// 申请类型
	private String applytype;
	// 申请类型业务字典
	private String applytypedict;
	// 状态
	private String status;
	// 状态
	private String statusalias;
	// 状态业务字典
	private String statusdict;

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getApplyno() {
		return applyno;
	}

	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

	public String getApplyempid() {
		return applyempid;
	}

	public void setApplyempid(String applyempid) {
		this.applyempid = applyempid;
	}

	public String getApplyempname() {
		return applyempname;
	}

	public void setApplyempname(String applyempname) {
		this.applyempname = applyempname;
	}

	public String getProcessempid() {
		return processempid;
	}

	public void setProcessempid(String processempid) {
		this.processempid = processempid;
	}

	public String getProcessempname() {
		return processempname;
	}

	public void setProcessempname(String processempname) {
		this.processempname = processempname;
	}

	public String getProcesstime() {
		return processtime;
	}

	public void setProcesstime(String processtime) {
		this.processtime = processtime;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getApplytypedict() {
		return applytypedict;
	}

	public void setApplytypedict(String applytypedict) {
		this.applytypedict = applytypedict;
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

	public String getStatusdict() {
		return statusdict;
	}

	public void setStatusdict(String statusdict) {
		this.statusdict = statusdict;
	}

}
