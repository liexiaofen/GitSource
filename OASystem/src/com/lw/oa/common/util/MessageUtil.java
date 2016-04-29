package com.lw.oa.common.util;

import com.lw.oa.common.command.RetInfo;

/**
 * *@author yuliang
 */
public class MessageUtil {
	/**
	 * 取得无查询结果的消息输出到前台
	 * 
	 * @param count
	 * 
	 * @return RetInfo
	 */
	public static RetInfo getMessageNoResult(int count){
		RetInfo retInfo = null;
		if(count == 0){
			retInfo = new RetInfo();
			retInfo.setCode("ERROR_COMM_0001");			
		}
		return retInfo;
	}
	/**
	 * 取得排他报错消息输出到前台
	 * 
	 * @param count
	 * 
	 * @return RetInfo
	 */
	public static RetInfo getMessageExclusive(int count){
		RetInfo retInfo = null;
		if(count == 0){
			retInfo = new RetInfo();
			retInfo.setCode("ERROR_COMM_0004");			
		}
		return retInfo;
	}
	/**
	 * 取得用户名密码报错消息输出到前台
	 * 
	 * @param count
	 * 
	 * @return RetInfo
	 */
	public static RetInfo getMessageErrorUserPwd(){
		RetInfo retInfo =  new RetInfo();		
		retInfo.setCode("ERROR_COMM_0038");	
		return retInfo;
	}
	/**
	 * 设置错误消息输出到前台
	 * 
	 * @param count
	 * 
	 * @return RetInfo
	 */
	public static RetInfo setMessageError(String code){
		RetInfo retInfo =  new RetInfo();		
		retInfo.setCode(code);	
		return retInfo;
	}
}
