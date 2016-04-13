package com.lw.oa.pb.daily.pb001;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PB001Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PB001001SearchCommand pb001001searchcommand;
	private String rownum;
	// JSON对象
	private String jsonstr;
	// 创建日
	private String createtime;
	// 更新日
	private String updatetime;
	// 更新者
	private String updator;
	// 事件排他标识
	private String eventexclusivefg;
	// 日程id
	private String dailyid;
	// 事件id
	private String eventid;
	// 员工id
	private String empid;
	// 发起人
	private String originateid;
	// 发起人
	private String originatename;
	// 定期模式
	private String dailycycle;
	// 定期模式业务字典
	private String dailycycledict;
	// 冲突标识
	private String conflictflag;
	// 事件类型
	private String eventtype;
	// 事件类型业务字典
	private String eventtypedict;
	// 日期
	private String daily;
	// 日程开始时分
	private String dailystarthm;
	// 日程结束时分
	private String dailyendhm;
	// 事件开始日
	private String eventstart;
	// 事件结束日
	private String eventend;
	// 事件开始时分
	private String eventstarthm;
	// 事件结束时分
	private String eventendhm;
	// 事件开始时间
	private String eventstarttime;
	// 事件结束时间
	private String eventendtime;
	// 日程开始时间
	private String dailystarttime;
	// 日程结束时间
	private String dailyendtime;
	// 标题
	private String title;
	// 内容
	private String comment;
	// 事件设备
	private String eventdevices;
	// 事件设备id
	private String eventdevicesid;
	// 事件关联者
	private String eventconnects;
	// 事件关联id
	private String eventconnectsid;

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public String getJsonstr() {
		return jsonstr;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getDailyid() {
		return dailyid;
	}

	public void setDailyid(String dailyid) {
		this.dailyid = dailyid;
	}

	public PB001001SearchCommand getPb001001searchcommand() {
		return pb001001searchcommand;
	}

	public void setPb001001searchcommand(
			PB001001SearchCommand pb001001searchcommand) {
		this.pb001001searchcommand = pb001001searchcommand;
	}

	public String getEventexclusivefg() {
		return eventexclusivefg;
	}

	public void setEventexclusivefg(String eventexclusivefg) {
		this.eventexclusivefg = eventexclusivefg;
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

	public String getOriginateid() {
		return originateid;
	}

	public void setOriginateid(String originateid) {
		this.originateid = originateid;
	}

	public String getOriginatename() {
		return originatename;
	}

	public void setOriginatename(String originatename) {
		this.originatename = originatename;
	}

	public String getDailycycle() {
		return dailycycle;
	}

	public void setDailycycle(String dailycycle) {
		this.dailycycle = dailycycle;
	}

	public String getDailycycledict() {
		return dailycycledict;
	}

	public void setDailycycledict(String dailycycledict) {
		this.dailycycledict = dailycycledict;
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

	public String getEventtypedict() {
		return eventtypedict;
	}

	public void setEventtypedict(String eventtypedict) {
		this.eventtypedict = eventtypedict;
	}

	public String getDaily() {
		return daily;
	}

	public void setDaily(String daily) {
		this.daily = daily;
	}

	public String getDailystarthm() {
		return dailystarthm;
	}

	public void setDailystarthm(String dailystarthm) {
		this.dailystarthm = dailystarthm;
	}

	public String getDailyendhm() {
		return dailyendhm;
	}

	public void setDailyendhm(String dailyendhm) {
		this.dailyendhm = dailyendhm;
	}

	public String getEventstart() {
		return eventstart;
	}

	public void setEventstart(String eventstart) {
		this.eventstart = eventstart;
	}

	public String getEventend() {
		return eventend;
	}

	public void setEventend(String eventend) {
		this.eventend = eventend;
	}

	public String getEventstarthm() {
		return eventstarthm;
	}

	public void setEventstarthm(String eventstarthm) {
		this.eventstarthm = eventstarthm;
	}

	public String getEventendhm() {
		return eventendhm;
	}

	public void setEventendhm(String eventendhm) {
		this.eventendhm = eventendhm;
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

	public String getDailystarttime() {
		return dailystarttime;
	}

	public void setDailystarttime(String dailystarttime) {
		this.dailystarttime = dailystarttime;
	}

	public String getDailyendtime() {
		return dailyendtime;
	}

	public void setDailyendtime(String dailyendtime) {
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

	public String getEventdevices() {
		return eventdevices;
	}

	public void setEventdevices(String eventdevices) {
		this.eventdevices = eventdevices;
	}

	public String getEventdevicesid() {
		return eventdevicesid;
	}

	public void setEventdevicesid(String eventdevicesid) {
		this.eventdevicesid = eventdevicesid;
	}

	public String getEventconnects() {
		return eventconnects;
	}

	public void setEventconnects(String eventconnects) {
		this.eventconnects = eventconnects;
	}

	public String getEventconnectsid() {
		return eventconnectsid;
	}

	public void setEventconnectsid(String eventconnectsid) {
		this.eventconnectsid = eventconnectsid;
	}

}
