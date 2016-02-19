package com.lw.oa.common.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * *@author yuliang
 */
public class ApplyForm extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 申请id
	private String applyid;
	// 源id
	private String sourceid;
	// 申请单号
	private String applyno;
	// 申请人id
	private String applyempid;
	// 处理人id
	private String processempid;
	// 处理时间
	private Timestamp processtime;
	// 经理审核id
	private String managercheckid;
	// 经理审核机构id
	private String managerorgcdid;
	// 经理审核部门id
	private String managerdepid;
	// 人事审核id
	private String personnelcheckid;
	// 人事审核机构id
	private String personnelorgcdid;
	// 人事审核部门id
	private String personneldepid;
	// 副总审核id
	private String vicepresicheckid;
	// 副总审核机构id
	private String vicepresiorgcdid;
	// 副总审核部门id
	private String vicepresidepid;
	// 总经理审核id
	private String presicheckid;
	// 总经理审核机构id
	private String presiorgcdid;
	// 总经理审核部门id
	private String presidepid;
	// 人事归档审核id
	private String personfilecheckid;
	// 人事归档审核机构id
	private String personfileorgcdid;
	// 人事归档审核部门id
	private String personfiledepid;
	// 申请类型
	private String applytype;
	// 休假事由类型
	private String vacatereasontype;
	// 其他备注
	private String otherremark;
	// 申请事由
	private String applyreason;
	// 申请开始日
	private Date applystart;
	// 申请结束日
	private Date applyend;
	// 申请开始时分
	private String applystarthm;
	// 申请结束时分
	private String applyendhm;
	// 申请开始时间
	private Timestamp applystarttime;
	// 申请结束时间
	private Timestamp applyendtime;
	// 加班申请类型
	private String extraworkapplytype;
	// 是否出差地加班
	private String evectionworkflag;
	// 加班开始日
	private Date extraworkstart;
	// 加班结束日
	private Date extraworkend;
	// 加班开始时分
	private String extraworkstarthm;
	// 加班结束时分
	private String extraworkendhm;
	// 加班开始时间
	private Timestamp extraworkstarttime;
	// 加班结束时间
	private Timestamp extraworkendtime;
	// 出差国家
	private String evectioncountry;
	// 出差省
	private String evectionprovince;
	// 出差城市
	private String evectioncity;
	// 出差地1
	private String evectionaddress1;
	// 出差地2
	private String evectionaddress2;
	// 总工时
	private String totalhours;
	// 出差费用
	private BigDecimal evectionmoney;
	// 出差补贴
	private BigDecimal evectionallowance;
	// 报销总额
	private BigDecimal totalmoney;
	// 状态
	private String status;
	// 备注
	private String remark;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;
	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getSourceid() {
		return sourceid;
	}

	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
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

	public String getProcessempid() {
		return processempid;
	}

	public void setProcessempid(String processempid) {
		this.processempid = processempid;
	}

	public Timestamp getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Timestamp processtime) {
		this.processtime = processtime;
	}

	public String getManagercheckid() {
		return managercheckid;
	}

	public void setManagercheckid(String managercheckid) {
		this.managercheckid = managercheckid;
	}

	public String getManagerorgcdid() {
		return managerorgcdid;
	}

	public void setManagerorgcdid(String managerorgcdid) {
		this.managerorgcdid = managerorgcdid;
	}

	public String getManagerdepid() {
		return managerdepid;
	}

	public void setManagerdepid(String managerdepid) {
		this.managerdepid = managerdepid;
	}

	public String getPersonnelcheckid() {
		return personnelcheckid;
	}

	public void setPersonnelcheckid(String personnelcheckid) {
		this.personnelcheckid = personnelcheckid;
	}

	public String getPersonnelorgcdid() {
		return personnelorgcdid;
	}

	public void setPersonnelorgcdid(String personnelorgcdid) {
		this.personnelorgcdid = personnelorgcdid;
	}

	public String getPersonneldepid() {
		return personneldepid;
	}

	public void setPersonneldepid(String personneldepid) {
		this.personneldepid = personneldepid;
	}

	public String getVicepresicheckid() {
		return vicepresicheckid;
	}

	public void setVicepresicheckid(String vicepresicheckid) {
		this.vicepresicheckid = vicepresicheckid;
	}

	public String getVicepresiorgcdid() {
		return vicepresiorgcdid;
	}

	public void setVicepresiorgcdid(String vicepresiorgcdid) {
		this.vicepresiorgcdid = vicepresiorgcdid;
	}

	public String getVicepresidepid() {
		return vicepresidepid;
	}

	public void setVicepresidepid(String vicepresidepid) {
		this.vicepresidepid = vicepresidepid;
	}

	public String getPresicheckid() {
		return presicheckid;
	}

	public void setPresicheckid(String presicheckid) {
		this.presicheckid = presicheckid;
	}

	public String getPresiorgcdid() {
		return presiorgcdid;
	}

	public void setPresiorgcdid(String presiorgcdid) {
		this.presiorgcdid = presiorgcdid;
	}

	public String getPresidepid() {
		return presidepid;
	}

	public void setPresidepid(String presidepid) {
		this.presidepid = presidepid;
	}

	public String getPersonfilecheckid() {
		return personfilecheckid;
	}

	public void setPersonfilecheckid(String personfilecheckid) {
		this.personfilecheckid = personfilecheckid;
	}

	public String getPersonfileorgcdid() {
		return personfileorgcdid;
	}

	public void setPersonfileorgcdid(String personfileorgcdid) {
		this.personfileorgcdid = personfileorgcdid;
	}

	public String getPersonfiledepid() {
		return personfiledepid;
	}

	public void setPersonfiledepid(String personfiledepid) {
		this.personfiledepid = personfiledepid;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getVacatereasontype() {
		return vacatereasontype;
	}

	public void setVacatereasontype(String vacatereasontype) {
		this.vacatereasontype = vacatereasontype;
	}

	public String getOtherremark() {
		return otherremark;
	}

	public void setOtherremark(String otherremark) {
		this.otherremark = otherremark;
	}

	public String getApplyreason() {
		return applyreason;
	}

	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}

	public Date getApplystart() {
		return applystart;
	}

	public void setApplystart(Date applystart) {
		this.applystart = applystart;
	}

	public Date getApplyend() {
		return applyend;
	}

	public void setApplyend(Date applyend) {
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

	public Timestamp getApplystarttime() {
		return applystarttime;
	}

	public void setApplystarttime(Timestamp applystarttime) {
		this.applystarttime = applystarttime;
	}

	public Timestamp getApplyendtime() {
		return applyendtime;
	}

	public void setApplyendtime(Timestamp applyendtime) {
		this.applyendtime = applyendtime;
	}

	public String getExtraworkapplytype() {
		return extraworkapplytype;
	}

	public void setExtraworkapplytype(String extraworkapplytype) {
		this.extraworkapplytype = extraworkapplytype;
	}

	public String getEvectionworkflag() {
		return evectionworkflag;
	}

	public void setEvectionworkflag(String evectionworkflag) {
		this.evectionworkflag = evectionworkflag;
	}

	public Date getExtraworkstart() {
		return extraworkstart;
	}

	public void setExtraworkstart(Date extraworkstart) {
		this.extraworkstart = extraworkstart;
	}

	public Date getExtraworkend() {
		return extraworkend;
	}

	public void setExtraworkend(Date extraworkend) {
		this.extraworkend = extraworkend;
	}

	public String getExtraworkstarthm() {
		return extraworkstarthm;
	}

	public void setExtraworkstarthm(String extraworkstarthm) {
		this.extraworkstarthm = extraworkstarthm;
	}

	public String getExtraworkendhm() {
		return extraworkendhm;
	}

	public void setExtraworkendhm(String extraworkendhm) {
		this.extraworkendhm = extraworkendhm;
	}

	public Timestamp getExtraworkstarttime() {
		return extraworkstarttime;
	}

	public void setExtraworkstarttime(Timestamp extraworkstarttime) {
		this.extraworkstarttime = extraworkstarttime;
	}

	public Timestamp getExtraworkendtime() {
		return extraworkendtime;
	}

	public void setExtraworkendtime(Timestamp extraworkendtime) {
		this.extraworkendtime = extraworkendtime;
	}

	public String getEvectioncountry() {
		return evectioncountry;
	}

	public void setEvectioncountry(String evectioncountry) {
		this.evectioncountry = evectioncountry;
	}

	public String getEvectionprovince() {
		return evectionprovince;
	}

	public void setEvectionprovince(String evectionprovince) {
		this.evectionprovince = evectionprovince;
	}

	public String getEvectioncity() {
		return evectioncity;
	}

	public void setEvectioncity(String evectioncity) {
		this.evectioncity = evectioncity;
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

	public String getTotalhours() {
		return totalhours;
	}

	public void setTotalhours(String totalhours) {
		this.totalhours = totalhours;
	}

	public BigDecimal getEvectionmoney() {
		return evectionmoney;
	}

	public void setEvectionmoney(BigDecimal evectionmoney) {
		this.evectionmoney = evectionmoney;
	}

	public BigDecimal getEvectionallowance() {
		return evectionallowance;
	}

	public void setEvectionallowance(BigDecimal evectionallowance) {
		this.evectionallowance = evectionallowance;
	}

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}