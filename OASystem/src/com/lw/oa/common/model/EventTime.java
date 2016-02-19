package com.lw.oa.common.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * *@author yuliang
 */
public class EventTime extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	// 事件时间id
	private String eventtimeid;
	// 事件id
	private String eventid;
	// 日期
	private Date daily;
	// 事件开始时间
	private Timestamp eventstarttime;
	// 事件结束时间
	private Timestamp eventendtime;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;
	public String getEventtimeid() {
		return eventtimeid;
	}
	public void setEventtimeid(String eventtimeid) {
		this.eventtimeid = eventtimeid;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public Date getDaily() {
		return daily;
	}
	public void setDaily(Date daily) {
		this.daily = daily;
	}
	public Timestamp getEventstarttime() {
		return eventstarttime;
	}
	public void setEventstarttime(Timestamp eventstarttime) {
		this.eventstarttime = eventstarttime;
	}
	public Timestamp getEventendtime() {
		return eventendtime;
	}
	public void setEventendtime(Timestamp eventendtime) {
		this.eventendtime = eventendtime;
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