package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class EventDevice extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 事件id
	private String eventid;
	// 日程设备id
	private String dailydeviceid;

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getDailydeviceid() {
		return dailydeviceid;
	}

	public void setDailydeviceid(String dailydeviceid) {
		this.dailydeviceid = dailydeviceid;
	}

}