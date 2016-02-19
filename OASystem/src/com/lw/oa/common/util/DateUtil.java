package com.lw.oa.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * *@author yuliang
 */
public class DateUtil {
	public static String getSystemTime(String format) {
		Date now = new Date();
		if (CheckUtil.isNull(format)) {
			format = "yyyyMMdd";
		}
		return formatDate(now, format);
	}

	
	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 日期转换
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat(format);
			date = (Date) df.parse(dateStr);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 两个日期间的天数
	 * 
	 * @param days
	 *            距离现在之后的天数
	 * @return Date:距离现在之后的若干天的日期;
	 */
	public static int getIntervalDays(Date startday, Date endday) {
		return (int) ((getMillis(startday) - getMillis(endday)) / (24 * 3600 * 1000));
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static Date diffDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, day);
		return c.getTime();

	}
	public static String diffDate(String srcdate,String format, int day) {
		Date dt = parseDate(srcdate, format);
		
		
		return formatDate(diffDate(dt,day),format);
		
	}
	public static String diffNowDate(String format, int day) {
		Date dt = new Date();
		
		
		return formatDate(diffDate(dt,day),format);
		
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 
	 * 取得某月的的最后一天
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * @return
	 * 
	 */
	public static Date getLastDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);// 年

		cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1

		cal.set(Calendar.DATE, 1);// 日，设为一号

		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号

		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天

		return cal.getTime();// 获得月末是几号

	}

	/**
	 * 
	 * 取得某天是一年中的多少周
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * @return
	 * 
	 */
	public static int getWeekOfYear(Date date) {

		Calendar c = new GregorianCalendar();

		c.setFirstDayOfWeek(Calendar.MONDAY);

		c.setMinimalDaysInFirstWeek(7);

		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);

	}

	/** */
	/**
	 * 
	 * 取得某天所在周的第一天
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * @return
	 * 
	 */
	public static Date getFirstDayOfWeek(Date date) {

		Calendar c = new GregorianCalendar();

		c.setFirstDayOfWeek(Calendar.MONDAY);

		c.setTime(date);

		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());

		return c.getTime();

	}

	/** */
	/**
	 * 
	 * 取得某天所在周的最后一天
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * @return
	 * 
	 */
	public static Date getLastDayOfWeek(Date date) {

		Calendar c = new GregorianCalendar();

		c.setFirstDayOfWeek(Calendar.MONDAY);

		c.setTime(date);

		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);

		return c.getTime();

	}

	/** */
	/**
	 * 
	 * 取得某一年共有多少周
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @return
	 * 
	 */
	public static int getMaxWeekNumOfYear(int year) {

		Calendar c = new GregorianCalendar();

		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());

	}

	/** */
	/**
	 * 
	 * 取得某年某周的第一天
	 * 
	 * 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,2009-01-05为2009年第一周的第一天
	 * 
	 * @param year
	 * 
	 * @param week
	 * 
	 * @return
	 * 
	 */
	public static Date getFirstDayOfWeek(int year, int week) {

		Calendar calFirst = Calendar.getInstance();

		calFirst.set(year, 0, 7);

		Date firstDate = getFirstDayOfWeek(calFirst.getTime());

		Calendar firstDateCal = Calendar.getInstance();

		firstDateCal.setTime(firstDate);

		Calendar c = new GregorianCalendar();

		c.set(Calendar.YEAR, year);

		c.set(Calendar.MONTH, Calendar.JANUARY);

		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

		Calendar cal = (GregorianCalendar) c.clone();

		cal.add(Calendar.DATE, (week - 1) * 7);

		firstDate = getFirstDayOfWeek(cal.getTime());

		return firstDate;

	}

	/** */
	/**
	 * 
	 * 取得某年某周的最后一天
	 * 
	 * 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,
	 * 
	 * 2009-01-04为 2008年最后一周的最后一天
	 * 
	 * @param year
	 * 
	 * @param week
	 * 
	 * @return
	 * 
	 */
	public static Date getLastDayOfWeek(int year, int week) {

		Calendar calLast = Calendar.getInstance();

		calLast.set(year, 0, 7);

		Date firstDate = getLastDayOfWeek(calLast.getTime());

		Calendar firstDateCal = Calendar.getInstance();

		firstDateCal.setTime(firstDate);

		Calendar c = new GregorianCalendar();

		c.set(Calendar.YEAR, year);

		c.set(Calendar.MONTH, Calendar.JANUARY);

		c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

		Calendar cal = (GregorianCalendar) c.clone();

		cal.add(Calendar.DATE, (week - 1) * 7);

		Date lastDate = getLastDayOfWeek(cal.getTime());

		return lastDate;

	}
	
	public static boolean isDate(String yyyymmdd) {
		boolean rt = false;
		// (((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9]))|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9]))|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9]))|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29))|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29))|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29))|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29))|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29))|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29))|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29))|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)))((\s+(0?[1-9]|1[012])(:[0-5]\d){0,2}(\s[AP]M))?$|(\s+([01]\d|2[0-3])(:[0-5]\d){0,2})?$))
		//
		// 它可以验证
		// 日期:是闰年的情况,一年只有12个月，一个月内有多少天(包括闰年)
		// 时间:可以验证一天只有24小时、60分、60秒,AM、PM

		Pattern pattern = Pattern
				.compile("((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9]))|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9]))|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9]))|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29))|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)))");
		Matcher matcher = pattern.matcher(yyyymmdd);
		rt = matcher.matches();
		return rt;
	}
	
	public static String formatDate(String date, String format_from,
			String format_to) {
		return formatDate(parseDate(date, format_from), format_to);
	}
	
	/**
	 * 日期比较
	 * @param datestr1
	 * @param datestr2
	 * @return
	 */
	public static boolean compareDate(String datestr1, String datestr2) {
		
		if (null == datestr1 || "".equals(datestr1.trim()) || null == datestr2 || "".equals(datestr2.trim())) {
			return false;
		}
		Date date1 = null;
		Date date2 = null;
		if (datestr1.length() == 10) {
			date1 = parseDate(datestr1, "yyyy-MM-dd");
		} else {
			date1 = parseDate(datestr1, "yyyy-M-d");
		}
		
		if (datestr2.length() == 10) {
			date2 = parseDate(datestr2, "yyyy-MM-dd");
		} else {
			date2 = parseDate(datestr2, "yyyy-M-d");
		}

		if (date1.compareTo(date2) != 0) {
			return false;
		}
		
		
		return true;
	}

	/**
	 * 第n期支付日
	 * 
	 * @param paymentDate 支付预定日(yyyy-MM-dd)
	 * @param addMonth 加n月
	 * @return 下期支付日
	 */
	public static Date getNextPaymentDate(Date paymentDate, int addMonth) {
		Calendar calDate = Calendar.getInstance();
		try {
	    	calDate.setTime(paymentDate);
	    	calDate.add(Calendar.MONTH, addMonth);
			int monthOrg = calDate.get(Calendar.MONTH); 
			int dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
			boolean plusflg = false;
			// 周六，周日时前推
			while (dayofweek == Calendar.SUNDAY || dayofweek == Calendar.SATURDAY) {
				calDate.add(Calendar.DATE, -1);
				dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				// 前推至跨月
				if (calDate.get(Calendar.MONTH) != monthOrg) {
					plusflg = true;
					break;
				}
			}
			// 周六，周日时后推
			if (plusflg) {
				calDate.setTime(paymentDate);
				calDate.add(Calendar.MONTH, addMonth);
				dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				while (dayofweek == Calendar.SUNDAY || dayofweek == Calendar.SATURDAY) {
					calDate.add(Calendar.DATE, 1);
					dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				}
			}
		} catch (Exception e) {
        }
		return calDate.getTime();
	}

	/**
	 * 支付开始日取得
	 * 
	 * @param paymentDate 支付预定日(yyyy-MM-dd)
	 * @return 支付开始日
	 */
	public static Date getPaybgnDate(Date payschdate) {
		Calendar calDate = Calendar.getInstance();
		try {
	    	calDate.setTime(payschdate);
			int monthOrg = calDate.get(Calendar.MONTH); 
			int dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
			boolean plusflg = false;
			// 周六，周日时前推
			while (dayofweek == Calendar.SUNDAY || dayofweek == Calendar.SATURDAY) {
				calDate.add(Calendar.DATE, -1);
				dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				// 前推至跨月
				if (calDate.get(Calendar.MONTH) != monthOrg) {
					plusflg = true;
					break;
				}
			}
			// 周六，周日时后推
			if (plusflg) {
				calDate.setTime(payschdate);
				dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				while (dayofweek == Calendar.SUNDAY || dayofweek == Calendar.SATURDAY) {
					calDate.add(Calendar.DATE, 1);
					dayofweek = calDate.get(Calendar.DAY_OF_WEEK);
				}
			}
		} catch (Exception e) {
        }
		return calDate.getTime();
	}
}
