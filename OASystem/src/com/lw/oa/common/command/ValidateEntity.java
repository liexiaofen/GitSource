package com.lw.oa.common.command;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class ValidateEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 数量
	private int count;
	// id
	private String id;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
