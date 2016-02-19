package com.lw.oa.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * @author yuliang
 *
 */
public class CryptUtil {
	/**
	 * 编码明文
	 * 
	 * @param strMing
	 * @return
	 */
	public static String base64Encode(String strMing) throws Exception{
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = byteMing;
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			throw e;
		}
		
		return strMi;
	}
	
	/**
	 * 解码密文
	 * 
	 * @param strMing
	 * @return
	 */
	public static String base64Decode(String strMi) throws Exception{
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = byteMi;
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			throw e;
		}		
		return strMing;
	}

}
