package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class EventConnect extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 事件id
	private String eventid;
	// 员工id
	private String empid;

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

}