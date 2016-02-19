package com.lw.oa.pc.apply.pc001;

import java.io.Serializable;
import com.lw.oa.common.command.ApplyFormCommand;

/**
 * *@author yuliang
 */
public class PC001Command extends ApplyFormCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PC001001SearchCommand pc001001searchcommand;
	
	public PC001001SearchCommand getPc001001searchcommand() {
		return pc001001searchcommand;
	}

	public void setPc001001searchcommand(
			PC001001SearchCommand pc001001searchcommand) {
		this.pc001001searchcommand = pc001001searchcommand;
	}
}
