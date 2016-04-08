package com.lw.oa.pb.daily.pb002;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PB002Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PB002001SearchCommand pb002001searchcommand;
	private String rownum;
	// 事件id
	private String eventid;	
	// 事件类型
	private String eventtype;
	// 事件类型业务字典
	private String eventtypedict;
	// 日程设备id
	private String dailydeviceid;
	// 日程设备名称
	private String dailydevicename;	
	// 日期
	private String daily;
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

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public PB002001SearchCommand getPb002001searchcommand() {
		return pb002001searchcommand;
	}

	public void setPb002001searchcommand(PB002001SearchCommand pb002001searchcommand) {
		this.pb002001searchcommand = pb002001searchcommand;
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

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
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
}
