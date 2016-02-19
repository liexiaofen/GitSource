package com.winsolution.weixin.entity;

import java.io.Serializable;

public class TPostmpEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户ID
	private String uid;
	//创建时间
	private String createTime;
	//纬度
	private float latitude;
	//经度
	private float longitude;
	//精度precision
	private float prec;
	//应用ID
	private int appid;
	
	
	public float getPrec() {
		return prec;
	}

	public void setPrec(float prec) {
		this.prec = prec;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	
	
}
