package com.lw.oa.common.util;

public interface ConstantUtil {
	//工龄20
	public static final int WORKAGE_TWENTY = 20;
	//工龄20以上对应的年假
	public static final String WORKAGE_TWENTY_HOURS = "120";
	//工龄10
	public static final int WORKAGE_TEN = 10;
	//工龄10以上对应的年假
	public static final String WORKAGE_TEN_HOURS = "80";
	//工龄0-10
	public static final int WORKAGE_ZERO = 0;
	//工龄工龄0-10对应的年假
	public static final String WORKAGE_ZERO_HOURS = "40";
	//福利年假
	public static final String WEAL_HOURS = "0";
	//月份
	public static final int MONTHS = 12;
	//编码格式
	public static final String  CHARATER_ENCODING = "UTF-8";
	//日期格式yyyy
	public static final String  DATE_FORMAT_YYYY = "yyyy";
	//日期格式yyyy-MM-dd
	public static final String  DATE_FORMAT_YMD = "yyyy-MM-dd";
	//日期格式yyyyMMdd
	public static final String  DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	//日期格式yyyy-MM-dd HH:mm:ss
	public static final String  DATE_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	//日程
	public static final String  DAILY_DAY = "0";
	//周程
	public static final String  DAILY_WEEK = "1";
	//月程
	public static final String  DAILY_MONTH = "2";
	//其他
	public static final String  DAILY_OTHER = "3";
	//空格
	public static final String  STRING_SPACE = " ";
	//空字符串
	public static final String  STRING_EMPTY = "";
	//字符串0
	public static final String  STRING_ZERO = "0";
	//秒
	public static final String  TIME_SS = ":00";
	//周日
	public static final String WEEK_ZERO = "0";
	//周一
	public static final String WEEK_ONE = "1";
	//周二
	public static final String WEEK_TWO = "2";
	//周三
	public static final String WEEK_THREE = "3";
	//周四
	public static final String WEEK_FOUR = "4";
	//周五
	public static final String WEEK_FIVE = "5";
	//周六
	public static final String WEEK_SIX = "6";
	//周日
	public static final String MONDAY = "周一";
	//周一
	public static final String TUESDAY = "周二";
	//周二
	public static final String WEDNESDAY = "周三";
	//周三
	public static final String THURSDAY = "周四";
	//周四
	public static final String FRIDAY = "周五";
	//周五
	public static final String SATURDAY = "周六";
	//周六
	public static final String SUNDAY = "周日";
	//已驳回
	public static final String APPLY_STATUS_0 = "0";
	//已申请										
	public static final String APPLY_STATUS_1 = "1";
	//经理已审批									
	public static final String APPLY_STATUS_2 = "2";
	//人事已审批									
	public static final String APPLY_STATUS_3 = "3";
	//副总已审批											
	public static final String APPLY_STATUS_4 = "4";
	//总经理已审批											
	public static final String APPLY_STATUS_5 = "5";
	//人事已归档											
	public static final String APPLY_STATUS_6 = "6";
	//文件已生成											
	public static final String APPLY_STATUS_7 = "7";
	//已删除											
	public static final String APPLY_STATUS_9 = "9";
	//请假事由带薪休假
	public static final String VACATEREASON_TYPE_0 = "0";
	//请假事由调休								
	public static final String VACATEREASON_TYPE_1 = "1";
	//请假事由病假						
	public static final String VACATEREASON_TYPE_2 = "2";
	//请假事由事假								
	public static final String VACATEREASON_TYPE_3 = "3";
	//请假事由产假										
	public static final String VACATEREASON_TYPE_4 = "4";
	//请假事由婚假									
	public static final String VACATEREASON_TYPE_5 = "5";
	//请假事由丧假									
	public static final String VACATEREASON_TYPE_6 = "6";
	//请假事由其他									
	public static final String VACATEREASON_TYPE_7 = "7";
	//出差地加班否
	public static final String EVECTION_WORKFLAG_0 = "0";
	//出差地加班是								
	public static final String EVECTION_WORKFLAG_1 = "1";	
	//审批流程等级1
	public static final String CHECKLEVEL_1 = "1";
	//审批流程等级2							
	public static final String CHECKLEVEL_2 = "2";
	//休假申请
	public static final String APPLY_A1 = "A1";
	//休假取消申请
	public static final String APPLY_A2 = "A2";
	//加班申请
	public static final String APPLY_A3 = "A3";
	//出差申请
	public static final String APPLY_A4 = "A4";
	//模板休假申请文件
	public static final String TEMPLATE_A1_FILE = "template\\Apply_A1.xlsx";
	//模板休假取消申请文件
	public static final String TEMPLATE_A2_FILE = "template\\Apply_A2.xlsx";
	//模板加班申请文件
	public static final String TEMPLATE_A3_FILE = "template\\Apply_A3.xlsx";
}
