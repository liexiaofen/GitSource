package com.lw.oa.common.command;

import java.io.Serializable;
import java.util.List;

import com.lw.oa.common.command.ResultCommand;

/**
 * *@author yuliang
 */
public class ApplyFormCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplySearchCommand searchcommand;
	List<ResumeEntity> list;
	// 操作代码
	private String operationcd;
	// 排他标识
	private String exclusivefg;
	// 当前日期
	private String currentdate;
	// 申请id
	private String applyid;
	// 源id
	private String sourceid;
	// 申请单号
	private String applyno;
	// 源申请单号
	private String sourceapplyno;
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
	// 机构 部门 职称
	private String orgcddepposes;
	// 员工组织
	List<ResultCommand> emporg;
	// 经理审核id
	private String managercheckid;
	// 经理审核者
	private String managercheckname;
	// 经理审核机构id
	private String managerorgcdid;
	// 经理审核机构名称
	private String managerorgcdname;
	// 经理审核部门id
	private String managerdepid;
	// 经理审核部门名称
	private String managerdepname;
	// 人事审核id
	private String personnelcheckid;
	// 人事审核者
	private String personnelcheckname;
	// 人事审核机构id
	private String personnelorgcdid;
	// 人事审核机构名称
	private String personnelorgcdname;
	// 人事审核部门id
	private String personneldepid;
	// 人事审核部门名称
	private String personneldepname;
	// 副总审核id
	private String vicepresicheckid;
	// 副总审核者
	private String vicepresicheckname;
	// 副总审核机构id
	private String vicepresiorgcdid;
	// 副总审核机构名称
	private String vicepresiorgcdname;
	// 副总审核部门id
	private String vicepresidepid;
	// 副总审核部门名称
	private String vicepresidepname;
	// 总经理审核id
	private String presicheckid;
	// 总经理审核者
	private String presicheckname;
	// 总经理审核机构id
	private String presiorgcdid;
	// 总经理审核机构名称
	private String presiorgcdname;
	// 总经理审核部门id
	private String presidepid;
	// 总经理审核部门名称
	private String presidepname;
	// 人事归档审核id
	private String personfilecheckid;
	// 人事归档审核者
	private String personfilecheckname;
	// 人事归档审核机构id
	private String personfileorgcdid;
	// 人事归档审核机构名称
	private String personfileorgcdname;
	// 人事归档审核部门id
	private String personfiledepid;
	// 人事归档审核部门名称
	private String personfiledepname;	
	// 申请类型
	private String applytype;
	// 休假事由类型
	private String vacatereasontype;
	// 休假事由类型业务字典	
	private String vacatereasontypedict;
	// 其他备注
	private String otherremark;
	// 申请事由
	private String applyreason;
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
	// 加班申请类型
	private String extraworkapplytype;
	// 是否出差地加班
	private String evectionworkflag;
	// 加班开始日
	private String extraworkstart;
	// 加班结束日
	private String extraworkend;
	// 加班开始时分
	private String extraworkstarthm;
	// 加班结束时分
	private String extraworkendhm;
	// 加班开始时间
	private String extraworkstarttime;
	// 加班结束时间
	private String extraworkendtime;
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
	private String evectionmoney;
	// 出差补贴
	private String evectionallowance;
	// 报销总额
	private String totalmoney;
	// 状态
	private String status;
	// 审批流程等级
	private String checklevel;
	// 备注
	private String remark;
	// 履历
	private String resume;
	// 未休法定休假
	private String unlegalvctn;
	// 未休福利休假
	private String unwealvctn;
	// 未休加班调休
	private String unextraworkvctn;
	// 总件数
	private String totalcount;
	// 未审核件数
	private String uncheckcount;
	// 经理未审核件数
	private String unmanagercheckcount;
	// 人事未审核件数
	private String unpersonnelcheckcount;
	// 副总未审核件数
	private String unvicepresicheckcount;
	// 总经理未审核件数
	private String unpresicheckcount;
	// 人事未归档审核件数
	private String unpersonfilecheckcount;
	public ApplySearchCommand getSearchcommand() {
		return searchcommand;
	}

	public void setSearchcommand(ApplySearchCommand searchcommand) {
		this.searchcommand = searchcommand;
	}

	public List<ResumeEntity> getList() {
		return list;
	}

	public void setList(List<ResumeEntity> list) {
		this.list = list;
	}

	public String getOperationcd() {
		return operationcd;
	}

	public void setOperationcd(String operationcd) {
		this.operationcd = operationcd;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

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

	public String getSourceapplyno() {
		return sourceapplyno;
	}

	public void setSourceapplyno(String sourceapplyno) {
		this.sourceapplyno = sourceapplyno;
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

	public String getOrgcddepposes() {
		return orgcddepposes;
	}

	public void setOrgcddepposes(String orgcddepposes) {
		this.orgcddepposes = orgcddepposes;
	}

	public List<ResultCommand> getEmporg() {
		return emporg;
	}

	public void setEmporg(List<ResultCommand> emporg) {
		this.emporg = emporg;
	}

	public String getManagercheckid() {
		return managercheckid;
	}

	public void setManagercheckid(String managercheckid) {
		this.managercheckid = managercheckid;
	}

	public String getManagercheckname() {
		return managercheckname;
	}

	public void setManagercheckname(String managercheckname) {
		this.managercheckname = managercheckname;
	}

	public String getManagerorgcdname() {
		return managerorgcdname;
	}

	public void setManagerorgcdname(String managerorgcdname) {
		this.managerorgcdname = managerorgcdname;
	}

	public String getManagerdepname() {
		return managerdepname;
	}

	public void setManagerdepname(String managerdepname) {
		this.managerdepname = managerdepname;
	}

	public String getPersonnelorgcdname() {
		return personnelorgcdname;
	}

	public void setPersonnelorgcdname(String personnelorgcdname) {
		this.personnelorgcdname = personnelorgcdname;
	}

	public String getPersonneldepname() {
		return personneldepname;
	}

	public void setPersonneldepname(String personneldepname) {
		this.personneldepname = personneldepname;
	}

	public String getVicepresiorgcdname() {
		return vicepresiorgcdname;
	}

	public void setVicepresiorgcdname(String vicepresiorgcdname) {
		this.vicepresiorgcdname = vicepresiorgcdname;
	}

	public String getVicepresidepname() {
		return vicepresidepname;
	}

	public void setVicepresidepname(String vicepresidepname) {
		this.vicepresidepname = vicepresidepname;
	}

	public String getPresiorgcdname() {
		return presiorgcdname;
	}

	public void setPresiorgcdname(String presiorgcdname) {
		this.presiorgcdname = presiorgcdname;
	}

	public String getPresidepname() {
		return presidepname;
	}

	public void setPresidepname(String presidepname) {
		this.presidepname = presidepname;
	}

	public String getPersonfileorgcdname() {
		return personfileorgcdname;
	}

	public void setPersonfileorgcdname(String personfileorgcdname) {
		this.personfileorgcdname = personfileorgcdname;
	}

	public String getPersonfiledepname() {
		return personfiledepname;
	}

	public void setPersonfiledepname(String personfiledepname) {
		this.personfiledepname = personfiledepname;
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

	public String getPersonnelcheckname() {
		return personnelcheckname;
	}

	public void setPersonnelcheckname(String personnelcheckname) {
		this.personnelcheckname = personnelcheckname;
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

	public String getVicepresicheckname() {
		return vicepresicheckname;
	}

	public void setVicepresicheckname(String vicepresicheckname) {
		this.vicepresicheckname = vicepresicheckname;
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

	public String getPresicheckname() {
		return presicheckname;
	}

	public void setPresicheckname(String presicheckname) {
		this.presicheckname = presicheckname;
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

	public String getPersonfilecheckname() {
		return personfilecheckname;
	}

	public void setPersonfilecheckname(String personfilecheckname) {
		this.personfilecheckname = personfilecheckname;
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

	public String getApplyreason() {
		return applyreason;
	}

	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
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

	public String getExtraworkstart() {
		return extraworkstart;
	}

	public void setExtraworkstart(String extraworkstart) {
		this.extraworkstart = extraworkstart;
	}

	public String getExtraworkend() {
		return extraworkend;
	}

	public void setExtraworkend(String extraworkend) {
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

	public String getExtraworkstarttime() {
		return extraworkstarttime;
	}

	public void setExtraworkstarttime(String extraworkstarttime) {
		this.extraworkstarttime = extraworkstarttime;
	}

	public String getExtraworkendtime() {
		return extraworkendtime;
	}

	public void setExtraworkendtime(String extraworkendtime) {
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

	public String getEvectionmoney() {
		return evectionmoney;
	}

	public void setEvectionmoney(String evectionmoney) {
		this.evectionmoney = evectionmoney;
	}

	public String getEvectionallowance() {
		return evectionallowance;
	}

	public void setEvectionallowance(String evectionallowance) {
		this.evectionallowance = evectionallowance;
	}

	public String getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getChecklevel() {
		return checklevel;
	}

	public void setChecklevel(String checklevel) {
		this.checklevel = checklevel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getUnlegalvctn() {
		return unlegalvctn;
	}

	public void setUnlegalvctn(String unlegalvctn) {
		this.unlegalvctn = unlegalvctn;
	}

	public String getUnwealvctn() {
		return unwealvctn;
	}

	public void setUnwealvctn(String unwealvctn) {
		this.unwealvctn = unwealvctn;
	}

	public String getUnextraworkvctn() {
		return unextraworkvctn;
	}

	public void setUnextraworkvctn(String unextraworkvctn) {
		this.unextraworkvctn = unextraworkvctn;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public String getUncheckcount() {
		return uncheckcount;
	}

	public void setUncheckcount(String uncheckcount) {
		this.uncheckcount = uncheckcount;
	}

	public String getUnmanagercheckcount() {
		return unmanagercheckcount;
	}

	public void setUnmanagercheckcount(String unmanagercheckcount) {
		this.unmanagercheckcount = unmanagercheckcount;
	}

	public String getUnpersonnelcheckcount() {
		return unpersonnelcheckcount;
	}

	public void setUnpersonnelcheckcount(String unpersonnelcheckcount) {
		this.unpersonnelcheckcount = unpersonnelcheckcount;
	}

	public String getUnvicepresicheckcount() {
		return unvicepresicheckcount;
	}

	public void setUnvicepresicheckcount(String unvicepresicheckcount) {
		this.unvicepresicheckcount = unvicepresicheckcount;
	}

	public String getUnpresicheckcount() {
		return unpresicheckcount;
	}

	public void setUnpresicheckcount(String unpresicheckcount) {
		this.unpresicheckcount = unpresicheckcount;
	}

	public String getUnpersonfilecheckcount() {
		return unpersonfilecheckcount;
	}

	public void setUnpersonfilecheckcount(String unpersonfilecheckcount) {
		this.unpersonfilecheckcount = unpersonfilecheckcount;
	}

}
