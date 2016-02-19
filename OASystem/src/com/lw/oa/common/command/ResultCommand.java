package com.lw.oa.common.command;

import java.io.Serializable;
import java.util.List;

/**
 * *@author yuliang
 */
public class ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ResultCommand> list;
	// 事件id
	private String eventid;
	// 员工id
	private String empid;
	// 员工姓名
	private String empname;
	// 工龄
	private String workage;
	// 区域id
	private String regionid;
	// 区域id业务字典
	private String regioniddict;
	// 机构id
	private String orgcdid;	
	// 机构全称
	private String orgname;
	// 机构简称
	private String orgshortname;
	// 部门id
	private String depid;
	// 部门id业务字典
	private String depiddict;
	// 职称id
	private String posid;
	// 职称id业务字典
	private String posiddict;
	// 角色id 
	private String roleid;
	// 角色名称
	private String rolename;
	// 日程设备id
	private String dailydeviceid;
	// 日程设备id
	private String dailydevicename;
	// 内容
	private String comment; 
	//日期
	private String daily;					
	//事件开始时间						
	private String eventstarttime;					
	//事件结束时间						
	private String eventendtime;		
	// 申请单号
	private String applyno;
	
	public List<ResultCommand> getList() {
		return list;
	}

	public void setList(List<ResultCommand> list) {
		this.list = list;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getWorkage() {
		return workage;
	}

	public void setWorkage(String workage) {
		this.workage = workage;
	}

	public String getRegionid() {
		return regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	public String getRegioniddict() {
		return regioniddict;
	}

	public void setRegioniddict(String regioniddict) {
		this.regioniddict = regioniddict;
	}

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgshortname() {
		return orgshortname;
	}

	public void setOrgshortname(String orgshortname) {
		this.orgshortname = orgshortname;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	public String getDepiddict() {
		return depiddict;
	}

	public void setDepiddict(String depiddict) {
		this.depiddict = depiddict;
	}

	public String getPosid() {
		return posid;
	}

	public void setPosid(String posid) {
		this.posid = posid;
	}

	public String getPosiddict() {
		return posiddict;
	}

	public void setPosiddict(String posiddict) {
		this.posiddict = posiddict;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDaily() {
		return daily;
	}

	public void setDaily(String daily) {
		this.daily = daily;
	}

	public String getEventstarttime() {
		return eventstarttime;
	}

	public void setEventstarttime(String eventstarttime) {
		this.eventstarttime = eventstarttime;
	}

	public String getEventendtime() {
		return eventendtime;
	}

	public void setEventendtime(String eventendtime) {
		this.eventendtime = eventendtime;
	}

	public String getDailydeviceid() {
		return dailydeviceid;
	}

	public void setDailydeviceid(String dailydeviceid) {
		this.dailydeviceid = dailydeviceid;
	}

	public String getDailydevicename() {
		return dailydevicename;
	}

	public void setDailydevicename(String dailydevicename) {
		this.dailydevicename = dailydevicename;
	}

	public String getApplyno() {
		return applyno;
	}

	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

}