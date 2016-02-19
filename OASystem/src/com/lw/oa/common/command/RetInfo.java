package com.lw.oa.common.command;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class RetInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// code
	private String code;
	// message
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
