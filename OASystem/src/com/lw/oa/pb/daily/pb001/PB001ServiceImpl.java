package com.lw.oa.pb.daily.pb001;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.DailyPlan;
import com.lw.oa.common.model.Event;
import com.lw.oa.common.model.EventConnect;
import com.lw.oa.common.model.EventDevice;
import com.lw.oa.common.model.EventTime;
import com.lw.oa.common.model.NationLegalday;
import com.lw.oa.common.util.CalendarUtil;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.StringUtil;
import com.lw.oa.pa.master.pa003.PA003001ResultCommand;
/**
 ** @author yuliang
 */
@Service("pb001Service")
public class PB001ServiceImpl implements IPB001Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;		
	
	public PB001ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public PB001001ResultTitleCommand getLegalDateListByWeek( PB001001SearchCommand searchCommand){
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA003001ResultCommand> list = (List<PA003001ResultCommand>)mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchWeekListByDisplayDT", searchCommand);
		PB001001ResultTitleCommand title = new PB001001ResultTitleCommand();
		List<NationLegalday> listweek = new ArrayList<NationLegalday>();
		for(int i=0; i<list.size();i++){
			NationLegalday entity = new NationLegalday();
			entity.setLegaldate(DateUtil.parseDate(list.get(i).getLegaldate(), DATE_FORMAT_YMD));
			entity.setDayofweek(list.get(i).getDayofweek());
			entity.setStatus(list.get(i).getStatus());
			listweek.add(entity);				
		}
		title.setList(listweek);
		return title;	
	}
	
	@Override
	public List<?> pb001001search(PB001001SearchCommand searchCommand, PB001001ResultTitleCommand title) {
		//in条件处理
		String orgcdid = searchCommand.getOrgcdid();
		String[] array = StringUtil.split(SEPERATORS_COMMA, orgcdid);
		searchCommand.setOrgcdids(array);
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<PB001001ResultCommand> list = (List<PB001001ResultCommand>) mybatisDAOImpl
				.queryByObj("pb.pb001.pb001001searchListByPage", searchCommand);		
		for(int i=0; i<list.size(); i++){
			PB001001ResultCommand entity = list.get(i);
			String empid = entity.getEmpid();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("empid", empid);
			int j = 0;
			//第一天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> one = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setOne(one);
				entity.setDateofone( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第二天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> two = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setTwo(two);
				entity.setDateoftwo( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第三天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> three = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setThree(three);
				entity.setDateofthree( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第四天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> four = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setFour(four);
				entity.setDateoffour( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第五天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> five = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setFive(five);
				entity.setDateoffive( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第六天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> six = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setSix(six);
				entity.setDateofsix( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
			j++;
			//第七天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB001Command> seven = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDailyPlanListByIdDate", map);
				entity.setSeven(seven);
				entity.setDateofseven( DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
			}
		}
		return list;
	}		
	
	@Override
	public PB001Command pb001001edit(PB001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("dailyid", searchCommand.getDailyid());		
		mybatisDAOImpl.openSession();
		PB001Command command = (PB001Command) mybatisDAOImpl.expandByObj(
				"pb.pb001.pb001001expandById", map);
		map.put("eventid", command.getEventid());
		@SuppressWarnings("unchecked")
		List<ResultCommand> listEmp = (List<ResultCommand>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchConnectsByEventid", map);
		// 事件关联拼接处理
		if(listEmp != null){
			if(listEmp.size() != 0){
				StringBuffer eventconnectsid = new StringBuffer();
				StringBuffer eventconnects = new StringBuffer();
				for(ResultCommand entity:listEmp){
					eventconnectsid.append(entity.getEmpid()).append(",");
					eventconnects.append(entity.getEmpname()).append(",");				
				}
				command.setEventconnectsid(eventconnectsid.substring(0, eventconnectsid.length()-1));
				command.setEventconnects(eventconnects.substring(0, eventconnects.length()-1));
			}
		}
		@SuppressWarnings("unchecked")
		List<ResultCommand> listDevice = (List<ResultCommand>) mybatisDAOImpl.queryByObj("pb.pb001.pb001001searchDevicesByEventid", map);
		// 事件设备拼接处理
		if(listDevice != null){ 
			if(listDevice.size() != 0){
				StringBuffer eventdevicesid = new StringBuffer();
				StringBuffer eventdevices = new StringBuffer();
				for(ResultCommand entity:listDevice){
					eventdevicesid.append(entity.getDailydeviceid()).append(",");
					eventdevices.append(entity.getDailydevicename()).append(",");				
				}
				command.setEventdevicesid(eventdevicesid.substring(0, eventdevicesid.length()-1));
				command.setEventdevices(eventdevices.substring(0, eventdevices.length()-1));
			}
		}
		return command;
	}

	@Override
	public PB001Command pb001001month(PB001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("monthempid", searchCommand.getMonthempid());	
		map.put("date", searchCommand.getDisplaydate().substring(0, 4));	
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PB001Command> list = (List<PB001Command>) mybatisDAOImpl.queryByObj(
				"pb.pb001.pb001001queryById", map);
		PB001Command command = new PB001Command();
		if(list != null){ 
			if(list.size() != 0){
				//将list转化成jsonarray
				JSONArray jsonarray = new JSONArray();	
				for(PB001Command entity:list){
					JSONObject jsonobj = new JSONObject();
					jsonobj.put("sid", 1);
					jsonobj.put("title", entity.getTitle());
					jsonobj.put("start", entity.getDailystarttime());
					jsonobj.put("end", entity.getDailyendtime());
					jsonobj.put("uid", entity.getTitle());
					jsonobj.put("fullname", entity.getOriginatename());
					jsonobj.put("confname", entity.getTitle());
					jsonobj.put("confshortname", entity.getTitle());
					jsonobj.put("confcolor", "#5386ac");
					jsonobj.put("confid", entity.getTitle());
					jsonobj.put("allDay", false);
					jsonobj.put("topic", entity.getTitle());
					jsonobj.put("description", entity.getComment());
					jsonobj.put("id", 1);
					jsonarray.add(jsonobj);
				}
				command.setJsonstr(JSON.toJSONString( jsonarray));
			}
		}
		return command;
	}

	@Override
	public int pb001003save(PB001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		// 创建事件对象
		Event event = createEvent(command);
		// 创建事件时间对象
		EventTime eventTime = createEventTime(command);
		// 创建事件关联者对象
		List<EventConnect> eventConnectList = creatEventConnect(command);
		// 创建事件设备对象
		List<EventDevice> eventDeviceList = creatEventDevice(command);
		// 创建日程安排对象
		List<DailyPlan> dailyPlanList = createDailyPlan( command, eventConnectList);
		// 定期模式
		String dailycycle = command.getDailycycle();
		try {
			mybatisDAOImpl.openSession();
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取事件id
			String eventid = DataUtil.getKey(sysdate);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 设置主键
			event.setEventid(eventid);
			// 设置共通插入字段
			DataUtil.setInsertCol(event, bean);		
			// 插入事件表
			mybatisDAOImpl.insert("common.insertEvent", event);
			// 共通插入处理
			commonProcess(eventid, dailycycle, bean, command, sysdate, eventConnectList, eventDeviceList, dailyPlanList, eventTime);
			//日程冲突处理
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("eventid", eventid);
			@SuppressWarnings("unchecked")
			List<PB001Command> list = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001002cancelSearchDailyPlan", map);			
			dailyConflictProcess(list, bean);
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 999;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}

		return flag;
	}
	
	@Override
	public int pb001002update(PB001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		// 创建事件对象
		Event event = createEvent(command);
		// 创建事件时间对象
		EventTime eventTime = createEventTime(command);
		// 创建事件关联者对象
		List<EventConnect> eventConnectList = creatEventConnect(command);
		// 创建事件设备对象
		List<EventDevice> eventDeviceList = creatEventDevice(command);
		// 创建日程安排对象
		List<DailyPlan> dailyPlanList = createDailyPlan( command, eventConnectList);
		// 定期模式
		String dailycycle = command.getDailycycle();
		try {
			mybatisDAOImpl.openSession();
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean updatebean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(event, updatebean);	
			DataUtil.setUpdateCol(eventTime, updatebean);
			//更新事件表
			flag = mybatisDAOImpl.update("pb.pb001.pb001002updateEvent", event);
			if(flag == 0){
				return flag;
			}
			//删除事件时间表
			mybatisDAOImpl.update("pb.pb001.pb001002deleteEventTime", eventTime);
			//删除事件关联表
			mybatisDAOImpl.delete("pb.pb001.pb001002deleteEventConnect", event.getEventid());
			//删除事件设备表
			mybatisDAOImpl.delete("pb.pb001.pb001002deleteEventDevice", event.getEventid());
			//逻辑删除日程安排表
			mybatisDAOImpl.update("pb.pb001.pb001002deleteDailyPlan", event);			
			// 获取事件id
			String eventid = command.getEventid();
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 共通插入处理
			commonProcess(eventid, dailycycle, bean, command, sysdate, eventConnectList, eventDeviceList, dailyPlanList, eventTime);
			//日程冲突处理
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("eventid", command.getEventid());
			@SuppressWarnings("unchecked")
			List<PB001Command> list = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001002cancelSearchDailyPlan", map);			
			dailyConflictProcess(list, updatebean);
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 999;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}
	
	public void commonProcess(String eventid, String dailycycle, CommonBean bean, PB001Command command, Date sysdate, List<EventConnect> eventConnectList, List<EventDevice> eventDeviceList, List<DailyPlan> dailyPlanList, EventTime eventTime){
		for(EventConnect connect:eventConnectList){
			connect.setEventid(eventid);
			// 设置共通插入字段
			DataUtil.setInsertCol(connect, bean);
			// 插入事件关联表
			mybatisDAOImpl.insert("common.insertEventConnect", connect);
		}
		if(eventDeviceList != null){
			if(eventDeviceList.size() != 0){
				for(EventDevice device:eventDeviceList){
					device.setEventid(eventid);
					// 设置共通插入字段
					DataUtil.setInsertCol(device, bean);
					// 插入事件设备表
					mybatisDAOImpl.insert("common.insertEventDevice", device);
				}
			}
		}
		if(DAILY_DAY.equals(dailycycle)){
			//插入日程安排表
			insertDailyPlan(dailyPlanList, eventid, sysdate, bean, DateUtil.parseDate( command.getEventstart(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());
			//插入事件时间表
			insertEventTime(eventTime, eventid, sysdate, bean, DateUtil.parseDate( command.getEventstart(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());
		}else if(DAILY_WEEK.equals(dailycycle)){
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("date", command.getEventstart());
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryWeekByDate", map);
			
			for(PA003001ResultCommand entity:list){			
				//插入日程安排表
				insertDailyPlan(dailyPlanList, eventid, sysdate, bean, DateUtil.parseDate( entity.getLegaldate(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());	
				//插入事件时间表
				insertEventTime(eventTime, eventid, sysdate, bean, DateUtil.parseDate( entity.getLegaldate(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());
			}				
		}else if(DAILY_MONTH.equals(dailycycle)){
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("date", command.getEventstart());
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryMonthByDate", map);
			
			for(PA003001ResultCommand entity:list){		
				//插入日程安排表
				insertDailyPlan(dailyPlanList, eventid, sysdate, bean, DateUtil.parseDate( entity.getLegaldate(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());	
				//插入事件时间表
				insertEventTime(eventTime, eventid, sysdate, bean, DateUtil.parseDate( entity.getLegaldate(), DATE_FORMAT_YMD), command.getEventstarthm(), command.getEventendhm());
			}	
		}else if(DAILY_OTHER.equals(dailycycle)){
			List<String> list = CalendarUtil.findDates(command.getEventstart(), command.getEventend());			
			for(String date:list){		
				String starthm = STRING_EMPTY;
				String endhm = STRING_EMPTY;
				//连续日期开始时间，结束时间的处理
				if(command.getEventstart().equals(command.getEventend())){
					starthm = command.getEventstarthm();
					endhm = command.getEventendhm();		
				}else if(date.equals(command.getEventstart())){
					starthm = command.getEventstarthm();
					endhm = "23:59";		
				}else if(date.equals(command.getEventend())){
					starthm = "00:00";
					endhm = command.getEventendhm();
				}else{
					starthm = "00:00";
					endhm = "23:59";
				}
				//插入日程安排表
				insertDailyPlan(dailyPlanList, eventid, sysdate, bean, DateUtil.parseDate( date, DATE_FORMAT_YMD), starthm, endhm);	
				//插入事件时间表
				insertEventTime(eventTime, eventid, sysdate, bean, DateUtil.parseDate( date, DATE_FORMAT_YMD), starthm, endhm);
			}	
		}
	}
	
	@Override
	public int pb001002cancel(PB001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		String originateid = command.getOriginateid();
		String empid = command.getEmpid();
		// 创建事件对象
		Event event = new Event();
		event.setEventid(command.getEventid());
		event.setExclusivefg(command.getEventexclusivefg());
		try {
			mybatisDAOImpl.openSession();
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean updatebean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(event, updatebean);	
			//个人取消
			if(!originateid.equals(empid)){			
				//更新事件表
				flag = mybatisDAOImpl.update("pb.pb001.pb001002personCancelEvent", event);
				if(flag == 0){
					return flag;
				}
				//创建事件关联删除条件
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("empid", empid);
				map.put("eventid", command.getEventid());				
				mybatisDAOImpl.delete("pb.pb001.pb001002personCancelEventConnect", map);
				//创建日程安排逻辑删除条件
				map.put("updator", updatebean.getUpdator());
				map.put("updatetime", updatebean.getUpdatetime());
				map.put("exclusivefg", updatebean.getUpdateexclusivefg());
				map.put("orgid", updatebean.getOrgid());				
				mybatisDAOImpl.update("pb.pb001.pb001002personCancelDailyPlan", map);
				@SuppressWarnings("unchecked")
				List<PB001Command> list = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001002personCancelSearchDailyPlan", map);
				//日程冲突处理
				dailyConflictProcess(list, updatebean);				
			}else{
			//发起人取消	
				//更新事件表
				flag = mybatisDAOImpl.update("pb.pb001.pb001002CancelEvent", event);
				if(flag == 0){
					return flag;
				}
				//创建事件关联逻辑删除条件
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("eventid", command.getEventid());
				map.put("updator", updatebean.getUpdator());
				map.put("updatetime", updatebean.getUpdatetime());
				map.put("exclusivefg", updatebean.getUpdateexclusivefg());
				map.put("orgid", updatebean.getOrgid());	
				mybatisDAOImpl.update("pb.pb001.pb001002CancelEventConnect", map);
				//逻辑删除事件设备表
				mybatisDAOImpl.update("pb.pb001.pb001002CancelEventDevice", map);					
				//创建日程安排逻辑删除条件							
				mybatisDAOImpl.update("pb.pb001.pb001002CancelDailyPlan", map);
				//逻辑删除事件时间表
				mybatisDAOImpl.update("pb.pb001.pb001002CancelEventTime", map);
				@SuppressWarnings("unchecked")
				List<PB001Command> list = (List<PB001Command>) mybatisDAOImpl.queryByObj("pb.pb001.pb001002cancelSearchDailyPlan", map);
				//日程冲突处理
				dailyConflictProcess(list, updatebean);	
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 999;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}
	
	public void dailyConflictProcess( List<PB001Command> list, CommonBean updatebean){
		if(list !=null ){
			if(list.size() != 0){
				for(PB001Command entity:list){
					if(entity.getRownum().equals("1")){
						entity.setConflictflag("0");
					}else{
						String id = entity.getEmpid();
						String start = entity.getDailystarttime();
						String end = entity.getDailyendtime();
						String eventid = entity.getEventid();
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("id", id);
						map.put("start", start);
						map.put("end", end);
						map.put("eventid", eventid);
						int count = (int) mybatisDAOImpl.expandByObj(
								"common.ajax.checkDailyConflict", map);
						if(count > 0){
							entity.setConflictflag("1");
						}else{
							entity.setConflictflag("0");
						}
					}
				}
				for(PB001Command entity:list){
					//创建日程冲突更新条件
					HashMap<String, Object> map = new HashMap<String, Object>();
//					map.put("updator", updatebean.getUpdator());
//					map.put("updatetime", updatebean.getUpdatetime());
//					map.put("exclusivefg", updatebean.getUpdateexclusivefg());
//					map.put("orgid", updatebean.getOrgid());
					map.put("conflictflag", entity.getConflictflag());
					map.put("dailyid", entity.getDailyid());
					mybatisDAOImpl.update("pb.pb001.pb001002updateDailyPlanConflict", map);
					System.out.println(entity.getEmpid()+"||"+entity.getDailystarttime()+"||"+entity.getDailyendtime()+"||"+entity.getConflictflag());
				}				
			}
		}
	}
	
	public void insertDailyPlan(List<DailyPlan> dailyPlanList, String eventid, Date sysdate, CommonBean bean, Date date, String starthm, String endhm){
		for(DailyPlan daily:dailyPlanList){
			// 设定事件id
			daily.setEventid(eventid);
			// 获取日程安排id
			String dailyid = DataUtil.getKey(sysdate);
			// 设置主键
			daily.setDailyid(dailyid);
			// 设定日期
			daily.setDaily(date);
			daily.setDailystarthm(starthm);
			daily.setDailyendhm(endhm);
			daily.setDailystarttime( new Timestamp(DateUtil.parseDate(DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+starthm+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			daily.setDailyendtime( new Timestamp(DateUtil.parseDate(DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+endhm+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			// 设置日程冲突标识
			String id = daily.getEmpid();
			String start = DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+starthm+TIME_SS;
			String end = DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+endhm+TIME_SS;
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("start", start);
			map.put("end", end);
			map.put("eventid", daily.getEventid());
			int count = (int) mybatisDAOImpl.expandByObj(
					"common.ajax.checkDailyConflict", map);
			if(count > 0){
				daily.setConflictflag("1");
			}else{
				daily.setConflictflag("0");
			}
			// 设置共通插入字段
			DataUtil.setInsertCol(daily, bean);
			// 日程安排表
			mybatisDAOImpl.insert("common.insertDailyPlan", daily);
		}
	}
	
	public void insertEventTime(EventTime eventTime, String eventid, Date sysdate, CommonBean bean, Date date, String starthm, String endhm){		
		// 设定事件id
		eventTime.setEventid(eventid);
		// 获取事件时间id
		String eventtimeid = DataUtil.getKey(sysdate);
		// 设置主键
		eventTime.setEventtimeid(eventtimeid);
		// 设定日期
		eventTime.setDaily(date);
		eventTime.setEventstarttime( new Timestamp(DateUtil.parseDate(DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+starthm+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		eventTime.setEventendtime( new Timestamp(DateUtil.parseDate(DateUtil.formatDate( date, DATE_FORMAT_YMD)+STRING_SPACE+endhm+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		// 设置共通插入字段
		DataUtil.setInsertCol(eventTime, bean);
		// 事件事件表
		mybatisDAOImpl.insert("common.insertEventTime", eventTime);	
	}

	public Event createEvent(PB001Command command){
		Event event = new Event();
		event.setEventid(command.getEventid());
		event.setExclusivefg(command.getEventexclusivefg());
		event.setOriginateid( command.getOriginateid());
		event.setDailycycle( command.getDailycycle());
		event.setEventtype( command.getEventtype());
		event.setEventstart( DateUtil.parseDate( command.getEventstart(), DATE_FORMAT_YMD));
		event.setEventend( DateUtil.parseDate( command.getEventend(), DATE_FORMAT_YMD));
		event.setEventstarthm(command.getEventstarthm());
		event.setEventendhm(command.getEventendhm());
		event.setEventstarttime( new Timestamp(DateUtil.parseDate(command.getEventstart()+STRING_SPACE+command.getEventstarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		event.setEventendtime( new Timestamp(DateUtil.parseDate(command.getEventend()+STRING_SPACE+command.getEventendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		event.setTitle(command.getTitle());
		event.setComment(command.getComment());
		event.setStatus("0");
		return event;
	}
	
	public EventTime createEventTime(PB001Command command){
		EventTime eventTime = new EventTime();
		eventTime.setEventid(command.getEventid());
		eventTime.setDaily( DateUtil.parseDate( command.getEventstart(), DATE_FORMAT_YMD));
		eventTime.setEventstarttime( new Timestamp(DateUtil.parseDate(command.getEventstart()+STRING_SPACE+command.getEventstarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		eventTime.setEventendtime( new Timestamp(DateUtil.parseDate(command.getEventstart()+STRING_SPACE+command.getEventendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));		
		return eventTime;
	}
	
	public List<DailyPlan> createDailyPlan( PB001Command command, List<EventConnect> eventConnectList){
		List<DailyPlan> list = new ArrayList<DailyPlan>();
		for(EventConnect entity:eventConnectList){
			DailyPlan dailyPlan = new DailyPlan();
			dailyPlan.setEmpid(entity.getEmpid());
			dailyPlan.setOriginateid( command.getOriginateid());
			dailyPlan.setDailycycle( command.getDailycycle());
			dailyPlan.setEventtype( command.getEventtype());			
			dailyPlan.setDailystarthm(command.getEventstarthm());			
			dailyPlan.setDailyendhm(command.getEventendhm());			
			dailyPlan.setTitle(command.getTitle());
			dailyPlan.setComment(command.getComment());
			list.add(dailyPlan);
		}
		return list;
	}
	
	public List<EventConnect> creatEventConnect(PB001Command command){
		String id = command.getEmpid(); 
		String connectsid = command.getEventconnectsid();
		if(StringUtils.isEmpty( connectsid)){
			connectsid = command.getEmpid(); 
		}else{//判断当前id是否包含在列表中
			if(connectsid.indexOf(id) < 0){
				connectsid += "," + command.getEmpid(); 
			}
		}
		command.setEventconnectsid(connectsid);
		List<EventConnect> list = new ArrayList<EventConnect>();		
		String[] str = connectsid.split(",");
		for(String empid:str){
			EventConnect eventConnect = new EventConnect();
			eventConnect.setEmpid(empid);
			list.add(eventConnect);
		}
		return list;
	}
	
	public List<EventDevice> creatEventDevice(PB001Command command){
		if(StringUtils.isEmpty( command.getEventdevicesid())){
				return null;
		}
		List<EventDevice> list = new ArrayList<EventDevice>();
		String devicesid = command.getEventdevicesid();
		String[] str = devicesid.split(",");
		for(String dailydeviceid:str){
			EventDevice eventDevice= new EventDevice();
			eventDevice.setDailydeviceid(dailydeviceid);;
			list.add(eventDevice);
		}
		return list;
	}

}
