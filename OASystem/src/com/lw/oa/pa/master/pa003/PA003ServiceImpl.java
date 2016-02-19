package com.lw.oa.pa.master.pa003;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.NationLegalday;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;

/**
 ** @author yuliang
 */
@Service("pa003Service")
public class PA003ServiceImpl implements IPA003Service, ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;	

	public PA003ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pa003001search(PA003001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
				.queryByObj("pa.pa003.pa003001searchListByPage", searchCommand);
		return list;
	}

	@Override
	public PA003Command pa003001view(PA003001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PA003Command command = (PA003Command) mybatisDAOImpl.expandByObj(
				"pa.pa003.pa003001expandById", searchCommand);
		return command;
	}

	@Override
	public int pa003003save(PA003Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		// 获取年历集合
		List<NationLegalday> list = getCalendarList(command.getLegalyear());
		try {
			mybatisDAOImpl.openSession();
			for (NationLegalday entity : list) {
				// 获取系统时间
				Date sysdate = (Date) mybatisDAOImpl.expandByObj(
						"common.getDBSysDate", null);
				// 获取key
				String key = DataUtil.getKey(sysdate);
				// 获取共通插入字段
				CommonBean bean = DataUtil.getInsertCol(sysdate, request);
				// 设置主键
				entity.setLegalid(key);

				// 设置共通插入字段
				DataUtil.setInsertCol(entity, bean);
				mybatisDAOImpl.insert("common.insertNationlegalday", entity);
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}

		return flag;
	}

	@Override
	public int pa003002update(PA003Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			// 数据转换
			NationLegalday entity = prepareCommand(command);
			// 获取系统时间
			Date sysdate = (Date) mybatisDAOImpl.expandByObj(
					"common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			mybatisDAOImpl.openSession();
			flag = mybatisDAOImpl.update("pa.pa003.pa003002update", entity);
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	public NationLegalday prepareCommand(PA003Command command) {
		NationLegalday entity = new NationLegalday();
		entity.setExclusivefg(command.getExclusivefg());
		entity.setLegalid(command.getLegalid());
		entity.setStatus(command.getStatus());
		return entity;
	}

	public List<NationLegalday> getCalendarList(String arg1) {
		int year = Integer.parseInt(arg1);
		// 最大天数
		int maxdays;
		List<NationLegalday> list = new ArrayList<NationLegalday>();
		for (int month = 0; month < MONTHS; month++) {
			Calendar cal = Calendar.getInstance();
			//日期设定
			cal.set(year, month, 1);
			//取得当月最大天数
			maxdays = cal.getActualMaximum(Calendar.DATE);
			for (int day = 1; day <= maxdays; day++) {
				NationLegalday entity = new NationLegalday();
				cal.set(year, month, day);
				// 法定日期
				entity.setLegaldate(DateUtil.parseDate(	DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd"));
				// 法定年
				entity.setLegalyear(new StringBuffer().append( cal.get(Calendar.YEAR)).toString());
				// 法定月 月份是从0开始计数的，所以此处进行加1
				entity.setLegalmonth(new StringBuffer().append(	cal.get(Calendar.MONTH) + 1).toString());
				// 法定日
				entity.setLegalday(new StringBuffer().append( cal.get(Calendar.DATE)).toString());
				// 星期 需减一（西方一周的第一天是周日）
				entity.setDayofweek(new StringBuffer().append( cal.get(Calendar.DAY_OF_WEEK) - 1).toString());
				// 周数
				entity.setWeekofyear(new StringBuffer().append(	cal.get(Calendar.WEEK_OF_YEAR)).toString());
				// 天数
				entity.setDayofyear(new StringBuffer().append( cal.get(Calendar.DAY_OF_YEAR)).toString());
				// 每月天数
				entity.setDayofmonth(new StringBuffer().append( cal.get(Calendar.DAY_OF_MONTH)).toString());
				// 周六、周末非工作日
				if (cal.get(Calendar.DAY_OF_WEEK) == 1
						|| cal.get(Calendar.DAY_OF_WEEK) == 7) {
					entity.setStatus("1");
				} else {
					entity.setStatus("0");
				}
//				System.out.println("最大天数：" + maxdays);
//				System.out.println("时间：" + cal.getTime());
//				System.out.println("年：" + new StringBuffer().append(cal.get(Calendar.YEAR)).toString());
//				System.out.println("月：" + cal.get(Calendar.MONTH));
//				System.out.println("日：" + cal.get(Calendar.DATE));
//				System.out.println("星期几：" + cal.get(Calendar.DAY_OF_WEEK));
//				System.out.println("第几周：" + cal.get(Calendar.WEEK_OF_YEAR));
//				System.out.println("天数：" + cal.get(Calendar.DAY_OF_YEAR));
				list.add(entity);
			}
		}
		return list;
	}
}
