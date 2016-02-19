package com.lw.oa.common.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * *@author yuliang
 */
public class DailyPlan extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 日程id
	private String dailyid;
	// 员工id
	private String empid;
	// 事件id
	private String eventid;
	// 发起人
	private String originateid;
	// 定期模式
	private String dailycycle;
	// 冲突标识
	private String conflictflag;
	// 事件类型
	private String eventtype;
	// 日期
	private Date daily;
	// 日程开始时分
	private String dailystarthm;
	// 日程开始时间
	private Timestamp dailystarttime;
	// 日程结束时分
	private String dailyendhm;
	// 日程结束时间
	private Timestamp dailyendtime;
	// 标题
	private String title;
	// 内容
	private String comment;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;
	public String getDailyid() {
		return dailyid;
	}
	public void setDailyid(String dailyid) {
		this.dailyid = dailyid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public String getOriginateid() {
		return originateid;
	}
	public void setOriginateid(String originateid) {
		this.originateid = originateid;
	}
	public String getDailycycle() {
		return dailycycle;
	}
	public void setDailycycle(String dailycycle) {
		this.dailycycle = dailycycle;
	}
	public String getConflictflag() {
		return conflictflag;
	}
	public void setConflictflag(String conflictflag) {
		this.conflictflag = conflictflag;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public Date getDaily() {
		return daily;
	}
	public void setDaily(Date daily) {
		this.daily = daily;
	}
	public String getDailystarthm() {
		return dailystarthm;
	}
	public void setDailystarthm(String dailystarthm) {
		this.dailystarthm = dailystarthm;
	}
	public Timestamp getDailystarttime() {
		return dailystarttime;
	}
	public void setDailystarttime(Timestamp dailystarttime) {
		this.dailystarttime = dailystarttime;
	}
	public String getDailyendhm() {
		return dailyendhm;
	}
	public void setDailyendhm(String dailyendhm) {
		this.dailyendhm = dailyendhm;
	}
	public Timestamp getDailyendtime() {
		return dailyendtime;
	}
	public void setDailyendtime(Timestamp dailyendtime) {
		this.dailyendtime = dailyendtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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