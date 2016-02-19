package com.lw.oa.common.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * *@author yuliang
 */
public class Event extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 事件id
	private String eventid;
	// 发起人
	private String originateid;
	// 定期模式
	private String dailycycle;
	// 事件类型
	private String eventtype;
	// 日期开始
	private Date eventstart;
	// 日期结束
	private Date eventend;
	// 事件开始时分
	private String eventstarthm;
	// 事件结束时分
	private String eventendhm;
	// 事件开始时间
	private Timestamp eventstarttime;
	// 事件结束时间
	private Timestamp eventendtime;
	// 标题
	private String title;
	// 内容
	private String comment;
	// 状态
	private String status;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

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

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public Date getEventstart() {
		return eventstart;
	}

	public void setEventstart(Date eventstart) {
		this.eventstart = eventstart;
	}

	public Date getEventend() {
		return eventend;
	}

	public void setEventend(Date eventend) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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