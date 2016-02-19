package com.winsolution.weixin.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 概要：用于时间的Util类
 * 
 * @author GaoShuren
 */
public final class DatetimeUtils {

    /**
     * 类型：日
     */
    public static final DateType DATE = DateType.Date;

    /**
     * 类型：时
     */
    public static final DateType HOUR = DateType.Hour;

    /**
     * 类型：分
     */
    public static final DateType MINUTE = DateType.Minute;

    /**
     * 类型：月
     */
    public static final DateType MONTH = DateType.Month;

    /**
     * 类型：秒
     */
    public static final DateType SECOND = DateType.Second;

    /**
     * 类型：年
     */
    public static final DateType YEAR = DateType.Year;
    
	public static final String PATTERN_1 = "yyyyMMddHHmmssSSS";
	public static final String PATTERN_2 = "yyyyMMddHHmmss";
	public static final String PATTERN_3 = "yyMMdd";
	public static final String PATTERN_4 = "yyyy/MM/dd";
	public static final String PATTERN_5 = "yyyy年MM月";
	public static final String PATTERN_6 = "yyyy/MM/dd";
	public static final String PATTERN_7 = "yyyy/MM/dd HH:mm:ss";
	public static final String PATTERN_8 = "yyyy年MM月dd日";
	public static final String PATTERN_9 = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String PATTERN_10 = "yyyy/MM/dd HH:mm";
	public static final String PATTERN_11 = "HH:mm:ss";
	public static final String PATTERN_12 = "yyyy-MM-dd";
	public static final String PATTERN_13 = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_14 = "yyyy";
	public static final String PATTERN_15 = "yyyyMMdd";
	public static final String PATTERN_16 ="yyyy/MM";
	public static final String PATTERN_17 ="yyyyMM";
	public static final String PATTERN_18 ="dd-MMM-yy";
	public static final String PATTERN_19 ="MM/dd/yyyy";
	public static final String PATTERN_20 = "yy/MM/dd";
	public static final String PATTERN_21 = "MMddyy";
	public static final String PATTERN_22 = "yyyyMMdd HH:mm:ss";
	public static final String PATTERN_23 = "yyyy-MM-dd HHmmss";
	/**
     * 日期类型
     * 
     * @author xuzhili
     */
    public enum DateType {

        /**
         * 类型：日
         */
        Date(Calendar.DATE),

        /**
         * 类型：时
         */
        Hour(Calendar.HOUR_OF_DAY),

        /**
         * 类型：分
         */
        Minute(Calendar.MINUTE),

        /**
         * 类型：月
         */
        Month(Calendar.MONTH),

        /**
         * 类型：秒
         */
        Second(Calendar.SECOND),

        /**
         * 类型：年
         */
        Year(Calendar.YEAR);

        /**
         * 值
         */
        private int value;

        /**
         * 构造函数
         * 
         * @param value
         *            值
         */
        DateType(int value) {
            this.value = value;
        }

        /**
         * 获取值
         * 
         * @return 值
         */
        public int value() {
            return value;
        }
    }

    /**
     * 日期增减计算
     * 
     * @param dt
     *            日期
     * @param type
     *            增减单位
     * @param amount
     *            增减量
     * @return 计算后的日期
     */
    public static Date addDate(Date dt, DateType type, int amount) {

        if (null == dt) {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(dt);
        cal.add(type.value(), amount);
        return cal.getTime();
    }

    /**
     * 年月日取得
     * 
     * @param dt
     *            日期
     * @param type
     *            年月日
     * @return 取得的年月日
     */
    public static int getField(Date dt, DateType type) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int retval = cal.get(type.value);
        if (type == MONTH) {
            retval++;
        }
        return retval;
    }

    /**
     * 清除时分秒
     * 
     * @param dt
     *            日期
     * @return 新日期
     */
    public static Date clearHMS(Date dt) {
        return getDate(getField(dt, YEAR), getField(dt, MONTH), getField(dt,
            DATE));
    }

    /**
     * 创建日期
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param date
     *            日
     * @return 日期
     */
    public static Date getDate(int year, int month, int date) {
        return getDate(year, month, date, 0, 0, 0);
    }

    /**
     * 创建日期
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param date
     *            日
     * @param hour
     *            时
     * @param minute
     *            分
     * @param second
     *            秒
     * @return 日期
     */
    public static Date getDate(int year, int month, int date, int hour,
        int minute, int second) {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回当前Web服务器时间（Date）
     * 
     * @return 当前Web服务器时间
     */
    public static Date currentAppDate() {
        return new GregorianCalendar().getTime();
    }

    /**
     * 返回当前数据库服务器时间（Date）
     * 
     * @return 当前数据库服务器时间
     */
//    public static Date currentDbDate() {
//        return ((SystemDao) ClassUtil.getComponent(SystemDao.class))
//            .selectDbServerDate();
//    }

    /**
     * 转换Date型到Timestamp
     * 
     * @param dt
     *            Date型变量
     * @return Timestamp型变量
     */
    public static Timestamp dateToTimestamp(Date dt) {

        // 如果为null，则返回null
        if (null == dt) {
            return null;
        }

        return new Timestamp(dt.getTime());
    }

    /**
     * 转换Date型到java.sql.Date
     * 
     * @param dt
     *            Date型变量
     * @return java.sql.Date型变量
     */
    public static java.sql.Date dateToSQLDate(Date dt) {

        // 如果为null，则返回null
        if (null == dt) {
            return null;
        }
        
        return new java.sql.Date(clearHMS(dt).getTime());
    }

	/**
	* Parse a datetime string.
	* @param param datetime string, pattern example: "yyyy-MM-dd HH:mm:ss".
	* @return java.util.Date
	*/
	public static Date parse(String param,String patten) {
		if(param == null){
			return null;
		}
		
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat(patten);
		try {
			date = sdf.parse(param);
		}catch (ParseException ex) {
			//ex.printStackTrace();
		}
		return date;
	}

	/**
	* Return short format datetime string.
	* @param date java.util.Date
	* @return short format datetime
	*/
	public static String getDateTimeStr(Date date,String pattern)  {
		if(date == null){
			return null;
		}

		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	* Return current datetime string.
	* @param pattern format pattern
	* @return current datetime
	*/
	public static String getDateTimeStr(String pattern)  {		
		return getDateTimeStr(new Date(), pattern);
	}

	public static String formatDate(Date dt,String ft){
		if(dt!=null)
		{
			SimpleDateFormat sf=new SimpleDateFormat(ft);
			return sf.format(dt);
		}else{
			return null;
		}
		
	}
}