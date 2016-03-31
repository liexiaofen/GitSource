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
	// 申请事由
	private String applyreason;
	// 出差地
	private String evectionaddress;
	// 出差地业务字典
	private String evectionaddressdict;
	// 出差地1
	private String evectionaddress1;
	// 出差地2
	private String evectionaddress2;
	// 同行人
	private String evectionconnects;
	// 出发自
	private String evectionstart;
	// 出发自业务字典
	private String evectionstartdict;
	// 是否利用飞机
	private String airplaneflag;
	// 是否利用飞机业务字典
	private String airplaneflagdict;
	// 状态
	private String status;
	// 状态
	private String statusalias;
	// 状态业务字典
	private String statusdict;													
	// 休假事由类型	
	private String vacatereasontype;
	// 休假事由类型业务字典	
	private String vacatereasontypedict;
	// 其他备注
	private String otherremark;
	// 申请开始日	
	private String applystart;
	// 申请结束日
	private String applyend;
	// 申请开始时分
	private String applystarthm;
	// 申请结束时分
	private String applyendhm;		
	// 申请开始时间
	private String applystarttime;
	// 申请结束时间
	private String applyendtime;
	// 总工时
	private String totalhours;											

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

	public String getApplyreason() {
		return applyreason;
	}

	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}

	public String getEvectionaddress() {
		return evectionaddress;
	}

	public void setEvectionaddress(String evectionaddress) {
		this.evectionaddress = evectionaddress;
	}

	public String getEvectionaddressdict() {
		return evectionaddressdict;
	}

	public void setEvectionaddressdict(String evectionaddressdict) {
		this.evectionaddressdict = evectionaddressdict;
	}

	public String getEvectionaddress1() {
		return evectionaddress1;
	}

	public void setEvectionaddress1(String evectionaddress1) {
		this.evectionaddress1 = evectionaddress1;
	}

	public String getEvectionaddress2() {
		return evectionaddress2;
	}

	public void setEvectionaddress2(String evectionaddress2) {
		this.evectionaddress2 = evectionaddress2;
	}

	public String getEvectionconnects() {
		return evectionconnects;
	}

	public void setEvectionconnects(String evectionconnects) {
		this.evectionconnects = evectionconnects;
	}

	public String getEvectionstart() {
		return evectionstart;
	}

	public void setEvectionstart(String evectionstart) {
		this.evectionstart = evectionstart;
	}

	public String getEvectionstartdict() {
		return evectionstartdict;
	}

	public void setEvectionstartdict(String evectionstartdict) {
		this.evectionstartdict = evectionstartdict;
	}

	public String getAirplaneflag() {
		return airplaneflag;
	}

	public void setAirplaneflag(String airplaneflag) {
		this.airplaneflag = airplaneflag;
	}

	public String getAirplaneflagdict() {
		return airplaneflagdict;
	}

	public void setAirplaneflagdict(String airplaneflagdict) {
		this.airplaneflagdict = airplaneflagdict;
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

	public String getVacatereasontype() {
		return vacatereasontype;
	}

	public void setVacatereasontype(String vacatereasontype) {
		this.vacatereasontype = vacatereasontype;
	}

	public String getVacatereasontypedict() {
		return vacatereasontypedict;
	}

	public void setVacatereasontypedict(String vacatereasontypedict) {
		this.vacatereasontypedict = vacatereasontypedict;
	}

	public String getOtherremark() {
		return otherremark;
	}

	public void setOtherremark(String otherremark) {
		this.otherremark = otherremark;
	}

	public String getApplystart() {
		return applystart;
	}

	public void setApplystart(String applystart) {
		this.applystart = applystart;
	}

	public String getApplyend() {
		return applyend;
	}

	public void setApplyend(String applyend) {
		this.applyend = applyend;
	}

	public String getApplystarthm() {
		return applystarthm;
	}

	public void setApplystarthm(String applystarthm) {
		this.applystarthm = applystarthm;
	}

	public String getApplyendhm() {
		return applyendhm;
	}

	public void setApplyendhm(String applyendhm) {
		this.applyendhm = applyendhm;
	}

	public String getApplystarttime() {
		return applystarttime;
	}

	public void setApplystarttime(String applystarttime) {
		this.applystarttime = applystarttime;
	}

	public String getApplyendtime() {
		return applyendtime;
	}

	public void setApplyendtime(String applyendtime) {
		this.applyendtime = applyendtime;
	}

	public String getTotalhours() {
		return totalhours;
	}

	public void setTotalhours(String totalhours) {
		this.totalhours = totalhours;
	}

}
