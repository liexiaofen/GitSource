package com.lw.oa.common.util;

import java.io.UnsupportedEncodingException;

public class CheckUtil {
	public static final String UTF_8 = "UTF-8";
	public static final String DATE_NULL = "00000000";
	/**
	 * 验证对象是否为空
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNull(Object o) {
		if (o == null || "".equals(o.toString().trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断日期是否为空。（业务上，日期为00000000表示空）
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNullDate(Object o) {
		return isNull(o) || DATE_NULL.equals(o.toString().trim());
	}

	/**
	 * 验证是否是整数
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isInteger(Object o) {
		if (isNull(o)) {
			return false;
		}
		boolean rt = true;
		try {
			if (o instanceof Integer) {
				rt = true;
			}

			Integer.valueOf(o.toString());
			rt = true;
		} catch (Exception e) {
			rt = false;
		}
		return rt;
	}

	/**
	 * 验证是否是长整型
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isLong(Object o) {
		if (isNull(o)) {
			return false;
		}
		boolean rt = true;
		try {
			if (o instanceof Long) {
				rt = true;
			}

			Long.valueOf(o.toString());
			rt = true;
		} catch (Exception e) {
			rt = false;
		}
		return rt;
	}

	/**
	 * 验证是否是浮点数
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isDecimal(Object o) {
		if (isNull(o)) {
			return false;
		}
		boolean rt = true;
		try {
			if (o instanceof Double) {
				rt = true;
			}
			Double.valueOf(o.toString());
			rt = true;
		} catch (Exception e) {
			rt = false;
		}
		return rt;
	}

	/**
	 * 验证最大长度
	 * 
	 * @param value
	 * @param maxlength
	 * @return
	 */
	public static boolean checkMaxLen(String value, int maxlength) {
		if (isNull(value)) {
			return true;
		}
		int len;
		try {
			len = value.getBytes(UTF_8).length;
			if (len > maxlength) {
				return false;
			}
			return true;
		} catch (UnsupportedEncodingException e) {
			return false;
		}
	}

	/**
	 * 验证是否是ASCII
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAscii(String value) {
		if (isNull(value)) {
			return false;
		}
		char[] c = value.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int v_ascii = (int) c[i];
			if (v_ascii < 0 || v_ascii > 127) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 验证字符串是否包含汉字
	 * 
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isChnCharacter(String value) {
		if (isNull(value)) {
			return false;
		}
		char[] charArray = value.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fa5)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证有效范围
	 * 
	 * @param o
	 * @param maxvalue
	 * @return
	 */
	public static boolean checkMaxScale(Object o, long maxvalue){
		if (isNull(o)) {
			return true;
		}
		long value = Long.valueOf(o.toString()).longValue();
		if (value > maxvalue) {
			return false;
		}
		return true;
	}

	/**
	 * 验证有效范围
	 * 
	 * @param o
	 * @param maxvalue
	 * @return
	 */
	public static boolean checkMaxScale(Object o, double maxvalue) {
		if (isNull(o)) {
			return true;
		}
		double value = Double.valueOf(o.toString()).doubleValue();
		if (value > maxvalue) {
			return false;
		}
		return true;
	}

	/**
	 * 验证有效范围
	 * 
	 * @param o
	 * @param minvalue
	 * @param maxvalue
	 * @return
	 */
	public static boolean checkLongMaxScale(Object o, long minvalue,
			long maxvalue) {
		if (isNull(o)) {
			return true;
		}
		long value = Long.valueOf(o.toString()).longValue();
		if (value > maxvalue || value < minvalue) {
			return false;
		}
		return true;
	}

	/**
	 * 验证有效范围
	 * 
	 * @param o
	 * @param minvalue
	 * @param maxvalue
	 * @return
	 */
	public static boolean checkDoubleMaxScale(Object o, double minvalue,
			double maxvalue) {
		if (isNull(o)) {
			return true;
		}
		double value = Double.valueOf(o.toString()).doubleValue();
		if (value > maxvalue || value < minvalue) {
			return false;
		}
		return true;
	}

	/**
	 * 验证是否日期YYYY-MM-DD或YYYY-M-D
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDate(String value) {
		if (null == value || "".equals(value.trim())) {
			return true;
		}
		if (!DateUtil.isDate(value)) {
			return false;
		}
		if (value.indexOf('-') > 0 && value.lastIndexOf('-') > 0
				&& value.indexOf('-') != value.lastIndexOf('-')) {
			return true;
		}
		return false;
	}

	/**
	 * 验证是否日期YYYYMMDD
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDateYYYYMMDD(String value) {
		if (null == value || "".equals(value.trim())) {
			return true;
		}
		if (value.length() != 8) {
			return false;
		}
		StringBuffer datetext = new StringBuffer();
		datetext.append(value.substring(0, 4));
		datetext.append("-");
		datetext.append(value.substring(4, 6));
		datetext.append("-");
		datetext.append(value.substring(6, 8));
		if (!DateUtil.isDate(datetext.toString())) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(CheckUtil.isDecimal("a"));
		System.out.println(CheckUtil.isDecimal("1."));

		System.out.println(CheckUtil.checkMaxLen("中文测中文测中文测中文测中文文测", 32));
		System.out.println(CheckUtil.isAscii("asf12"));
		System.out.println(CheckUtil.isChnCharacter("過の@#$%"));
		System.out.println(CheckUtil.isChnCharacter("カの@#$%"));
		System.out.println(CheckUtil.isChnCharacter("123の@#$%人"));

	}

}
