package com.lw.oa.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author yuliang
 *
 */
public class CryptUtil {
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";
	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 * HmacMD5  
	 * HmacSHA1  
	 * HmacSHA256  
	 * HmacSHA384  
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";
	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64(String key) throws Exception {
		byte[] byteMing = null;
		String strMing = "";
		byteMing = (new BASE64Decoder()).decodeBuffer(key);
		strMing = new String(byteMing, "UTF-8");
		return strMing;
	}
	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String strMing) throws Exception {
		byte[] byteMing = null;
		byteMing = strMing.getBytes("UTF-8");
		return (new BASE64Encoder()).encode(byteMing);
	}
	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}
	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}
	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(new String( secretKey.getEncoded(), "UTF-8"));
	}
	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
		SecretKey secretKey = new SecretKeySpec( decryptBASE64(key).getBytes("UTF-8"), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}

	@Test
	public void test() throws Exception {
		String inputStr = "000000";
		System.err.println("原文:\n" + inputStr);
		byte[] inputData = inputStr.getBytes();
		String code = encryptBASE64( new String( inputData, "UTF-8"));
		System.err.println("BASE64加密后:\n" + code);
		String outputStr = decryptBASE64(code);
		System.err.println("BASE64解密后:\n" + outputStr);
		// 验证BASE64加密解密一致性
		// assertEquals(inputStr, outputStr);
		// 验证MD5对于同一内容加密是否一致
		// assertArrayEquals(encryptMD5(inputData), encryptMD5(inputData));
		// 验证SHA对于同一内容加密是否一致
		// assertArrayEquals(encryptSHA(inputData), encryptSHA(inputData));
		// String key = initMacKey();
		// System.err.println("Mac密钥:\n" + key);
		// 验证HMAC对于同一内容，同一密钥加密是否一致
		// assertArrayEquals(encryptHMAC(inputData, key), encryptHMAC(inputData,
		// key));
		BigInteger md5 = new BigInteger(encryptMD5(inputData));
		System.err.println("MD5:\n" + md5.toString(16));
		BigInteger sha = new BigInteger(encryptSHA(inputData));
		System.err.println("SHA:\n" + sha.toString(32));
		BigInteger mac = new BigInteger(encryptHMAC(inputData, inputStr));
		System.err.println("HMAC:\n" + mac.toString(16));
	}
}
