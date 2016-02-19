package com.lw.oa.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplyResultCommand;
import com.lw.oa.common.command.ApplySearchCommand;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.command.ResumeEntity;
import com.lw.oa.common.command.ValidateEntity;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.ApplyForm;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.EventConnect;
import com.lw.oa.common.model.EventDevice;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.util.CalendarUtil;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.POIUtil;
import com.lw.oa.common.util.ResumeUtil;
import com.lw.oa.pa.master.pa003.PA003001ResultCommand;
import com.lw.system.framework.fa004.FA004001ResultCommand;
import com.lw.system.framework.fa004.FA004001SearchCommand;

/**
 ** @author yuliang
 */
@Service("ajaxService")
public class AjaxServiceImpl implements IAjaxService,ConstantUtil {
	
	private IMybatisDAO mybatisDAOImpl;
	public AjaxServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}
	@Override
	public int fileGenerate(HttpServletRequest request, String empid) {
		// TODO Auto-generated method stub
		int flag = 1;
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empid", empid);
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("common.ajax.searchApplyList", map);		
		if(list == null || list.size() == 0){
			flag = 999;
			return flag;
		}
		try {
			for(ApplyResultCommand command:list){
				ApplyForm entity = new ApplyForm();
				// 设置状态
				entity.setStatus("7");
				entity.setApplyid(command.getApplyid());
				entity.setExclusivefg(command.getExclusivefg());
				// 获取系统时间
				Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
				// 获取共通更新字段
				CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
				// 设置共通更新字段
				DataUtil.setUpdateCol(entity, bean);
				// 设置处理人
				entity.setProcessempid(bean.getUpdator());
				entity.setProcesstime(bean.getUpdatetime());			
				flag = mybatisDAOImpl.update( "common.ajax.updateApplyFormStatus", entity);		
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}
				// 获取履历id
				String hisid = DataUtil.getKey(sysdate);
				// 创建履历对象
				HashMap<String,Object> hismap  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, entity.getApplyid(), "A012", "0", "0", "", bean, request);
				mybatisDAOImpl.insert("common.insertHis", hismap);			
			}
			mybatisDAOImpl.commit();
			applyProcess(request, list);			
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}
	
	public void applyProcess(HttpServletRequest request,List<ApplyResultCommand> list){
		if(list != null){
			if(list.size() != 0){
				for(ApplyResultCommand resultCommand:list){		
					ApplySearchCommand searchCommand = new ApplySearchCommand();
					searchCommand.setApplyid(resultCommand.getApplyid());
					ApplyFormCommand command = (ApplyFormCommand) mybatisDAOImpl.expandByObj(
							"common.expandApplyForm", searchCommand);
					// 设置查询条件
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("empid", command.getApplyempid());
					@SuppressWarnings("unchecked")
					List<ResultCommand> emporg = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchOrgsByEmpid", map);
					command.setEmporg(emporg);
					// 组织机构拼接处理
					if(emporg != null){
						if(emporg.size() != 0){
							StringBuffer orgcddepposes = new StringBuffer();
							for(ResultCommand entity:emporg){
								orgcddepposes.append(entity.getOrgshortname()).append(":").append(entity.getDepiddict()).append(":").append(entity.getPosiddict()).append(",");		
							}
							command.setOrgcddepposes(orgcddepposes.substring(0, orgcddepposes.length()-1));
						}
					}
					// 获取履历
					String resume = ResumeUtil.getResumeByPid(command.getApplyid(), "OA_PC001_Operationcd", "[dbo].[his_applyform]");
					List<ResumeEntity> resumelist = ResumeUtil.getResumeListByPid(command.getApplyid(), "OA_PC001_Operationcd", "[dbo].[his_applyform]");
					command.setResume(resume);
					command.setList(resumelist);
					// 模板文件名取得
					String tempFileName = POIUtil.getTemplateFileName(command.getApplytype());
					String tempPath = request.getSession().getServletContext().getRealPath("/");
					// 获取服务器目录
					String serverDir = getServerDir(command.getApplytype(), "OA_Apply_ServerDir");
					//判断模板文件是否存在
					java.io.File f=new java.io.File(tempPath+tempFileName);
					if(f.exists() && f.canRead()){
						// 生成文件
						try {
							POIUtil.fileGenerate(tempPath, tempFileName, serverDir, command);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
					}else{
						System.out.println("文件不存在或无法打开");
					}					
				}
			}
		}
	}
	
	
	public String getServerDir(String type, String busitypeid){
		FA004001SearchCommand searchCommand = new FA004001SearchCommand();
		searchCommand.setBusidicttypeid(busitypeid);
		searchCommand.setBusidictid(type);		
		String busidictname = StringUtils.EMPTY;
		FA004001ResultCommand command = (FA004001ResultCommand) mybatisDAOImpl.expandByObj("fa.fa004.fa004001searchDictById", searchCommand);	
		if(command == null)
			busidictname = StringUtils.EMPTY;
		else
			busidictname = command.getBusidictname();
		return busidictname;
	}
	
	@Override
	public int checkUniqueCardno(String cardno) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cardno", cardno);
		int count = (int) mybatisDAOImpl.expandByObj(
				"common.ajax.checkUniqueCardno", map);
		mybatisDAOImpl.close();
		if (count > 0) {
			count = 1;
		}
		return count;
	}
	@Override
	public List<?> getDepsByOrgcdid(String orgcdid) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("orgcdid", orgcdid);
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl.queryByObj(
				"common.ajax.getDepsByOrgcdid", map);
		mybatisDAOImpl.close();
		return list;
	}	
	@Override
	public List<?> getEmpsByOrgcdDepid(String orgcdid, String depid) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("orgcdid", orgcdid);
		map.put("depid", depid);
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl.queryByObj(
				"common.ajax.getEmpsByOrgcdDepid", map);
		mybatisDAOImpl.close();
		return list;
	}	
	@Override
	public int checkUniqueUsername(String username, String empid){
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("empid", empid);
		int count = (int) mybatisDAOImpl.expandByObj(
				"common.ajax.checkUniqueUsername", map);
		mybatisDAOImpl.close();
		if (count > 0) {
			count = 1;
		}
		return count;
	}
	@Override
	public int checkLegalyear(String legalyear) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("legalyear", legalyear);
		int count = (int) mybatisDAOImpl.expandByObj(
				"common.ajax.checkLegalyear", map);
		mybatisDAOImpl.close();
		if (count > 0) {
			count = 1;
		}
		return count;
	}	
	@Override
	public int checkAnnualVctn(String year) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("year", year);
		int count = (int) mybatisDAOImpl.expandByObj(
				"common.ajax.checkAnnualVctn", map);
		mybatisDAOImpl.close();
		if (count > 0) {
			count = 1;
		}
		return count;
	}
	@Override
	public RetInfo checkDeviceOrder(String eventdevicesid, String eventstart, String eventend,
			String eventstarthm, String eventendhm, String dailycycle, String eventid) {	
		List<EventDevice> devices = creatEventDevice( eventdevicesid);
		RetInfo retInfo = new RetInfo();
		ValidateEntity validate = null;
		mybatisDAOImpl.openSession();
		// TODO Auto-generated method stub
		if(DAILY_DAY.equals(dailycycle)){	
			validate = checkDeviceOrderCount(devices, eventstart, eventstarthm, eventendhm, eventid);	
			if(validate.getCount() > 0){
				retInfo.setCode("ERROR_PB001_0001");
				retInfo.setMessage(validate.getId());	
				return retInfo;
			}		
		}else if(DAILY_WEEK.equals(dailycycle)){
			HashMap<String,String> dailymap = new HashMap<String, String>();
			dailymap.put("date", eventstart);
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryWeekByDate", dailymap);
			for(PA003001ResultCommand entity: list){
				validate = checkDeviceOrderCount(devices, entity.getLegaldate(), eventstarthm, eventendhm, eventid);	
				if(validate.getCount() > 0){
					retInfo.setCode("ERROR_PB001_0001");
					retInfo.setMessage(validate.getId());	
					return retInfo;
				}
			}
		}else if(DAILY_MONTH.equals(dailycycle)){
			HashMap<String,String> dailymap = new HashMap<String, String>();
			dailymap.put("date", eventstart);
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryMonthByDate", dailymap);
			for(PA003001ResultCommand entity: list){
				validate = checkDeviceOrderCount(devices, entity.getLegaldate(), eventstarthm, eventendhm, eventid);	
				if(validate.getCount() > 0){
					retInfo.setCode("ERROR_PB001_0001");
					retInfo.setMessage(validate.getId());	
					return retInfo;
				}
			}
		}else if(DAILY_OTHER.equals(dailycycle)){
			List<String> list = CalendarUtil.findDates(eventstart, eventend);
			if(list != null){
				if(list.size() != 0){
					for(String date:list){							
						String starthm = STRING_EMPTY;
						String endhm = STRING_EMPTY;
						//连续日期开始时间，结束时间的处理
						if(eventstart.equals(eventend)){
							starthm = eventstarthm;
							endhm = eventendhm;		
						}else if(date.equals(eventstart)){
							starthm = eventstarthm;
							endhm = "23:59";		
						}else if(date.equals(eventend)){
							starthm = "00:00";
							endhm = eventendhm;
						}else{
							starthm = "00:00";
							endhm = "23:59";
						}						
						validate = checkDeviceOrderCount(devices, date, starthm, endhm, eventid);	
						if(validate.getCount() > 0){
							retInfo.setCode("ERROR_PB001_0001");
							retInfo.setMessage(validate.getId());	
							return retInfo;
						}
					}
				}
			}			
		}
		mybatisDAOImpl.close();
		return retInfo;
	}
	
	public ValidateEntity checkDeviceOrderCount(List<EventDevice> devices, String date, String starthm, String endhm, String eventid){
		ValidateEntity entity = new ValidateEntity();
		int count = 0;
		if(devices != null){
			if(devices.size() != 0){
				for(EventDevice device:devices){
					String deviceid = device.getDailydeviceid();
					String start = date+STRING_SPACE+starthm+TIME_SS;
					String end = date+STRING_SPACE+endhm+TIME_SS;
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("deviceid", deviceid);
					map.put("start", start);
					map.put("end", end);
					map.put("eventid", eventid);
					count = (int) mybatisDAOImpl.expandByObj(
							"common.ajax.checkDeviceOrder", map);
					if(count > 0){
						entity.setCount(count);
						entity.setId(deviceid);
						return entity;
					}
				}
			}
		}
		entity.setCount(count);
		return entity;		
	}
	
	@Override
	public RetInfo checkDailyConflict(String eventconnectsid, String eventstart, String eventend,
			String eventstarthm, String eventendhm, String dailycycle, String empid, String eventid) {	
		List<EventConnect> connects = creatEventConnect( eventconnectsid, empid);
		RetInfo retInfo = new RetInfo();
		ValidateEntity validate = null;
		mybatisDAOImpl.openSession();
		// TODO Auto-generated method stub
		if(DAILY_DAY.equals(dailycycle)){	
			validate = checkDailyConflictCount(connects, eventstart, eventstarthm, eventendhm, eventid);								
			if(validate.getCount() > 0){
				retInfo.setCode("MSG_IC_PB001_0001");
				retInfo.setMessage(validate.getId());	
				return retInfo;
			}	
		}else if(DAILY_WEEK.equals(dailycycle)){
			HashMap<String,String> dailymap = new HashMap<String, String>();
			dailymap.put("date", eventstart);
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryWeekByDate", dailymap);
			for(PA003001ResultCommand entity: list){
				validate = checkDailyConflictCount(connects, entity.getLegaldate(), eventstarthm, eventendhm, eventid);								
				if(validate.getCount() > 0){
					retInfo.setCode("MSG_IC_PB001_0001");
					retInfo.setMessage(validate.getId());	
					return retInfo;
				}
			}
		}else if(DAILY_MONTH.equals(dailycycle)){
			HashMap<String,String> dailymap = new HashMap<String, String>();
			dailymap.put("date", eventstart);
			@SuppressWarnings("unchecked")
			List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) mybatisDAOImpl
					.queryByObj("pb.pb001.pb001001searchEveryMonthByDate", dailymap);
			for(PA003001ResultCommand entity: list){
				validate = checkDailyConflictCount(connects, entity.getLegaldate(), eventstarthm, eventendhm, eventid);								
				if(validate.getCount() > 0){
					retInfo.setCode("MSG_IC_PB001_0001");
					retInfo.setMessage(validate.getId());	
					return retInfo;
				}
			}
		}else if(DAILY_OTHER.equals(dailycycle)){
			List<String> list = CalendarUtil.findDates(eventstart, eventend);
			if(list != null){
				if(list.size() != 0){
					for(String date:list){	
						String starthm = STRING_EMPTY;
						String endhm = STRING_EMPTY;
						//连续日期开始时间，结束时间的处理
						if(eventstart.equals(eventend)){
							starthm = eventstarthm;
							endhm = eventendhm;		
						}else if(date.equals(eventstart)){
							starthm = eventstarthm;
							endhm = "23:59";		
						}else if(date.equals(eventend)){
							starthm = "00:00";
							endhm = eventendhm;
						}else{
							starthm = "00:00";
							endhm = "23:59";
						}		
						validate = checkDailyConflictCount(connects, date, starthm, endhm, eventid);								
						if(validate.getCount() > 0){
							retInfo.setCode("MSG_IC_PB001_0001");
							retInfo.setMessage(validate.getId());	
							return retInfo;
						}						
					}
				}
			}	
		}
		mybatisDAOImpl.close();
		return retInfo;
	}
	
	public ValidateEntity checkDailyConflictCount( List<EventConnect> connects, String date, String starthm, String endhm, String eventid){
		ValidateEntity entity = new ValidateEntity();
		int count = 0;
		if(connects != null){
			if(connects.size() != 0){
				for(EventConnect connect:connects){
					String id = connect.getEmpid();
					String start = date+STRING_SPACE+starthm+TIME_SS;
					String end = date+STRING_SPACE+endhm+TIME_SS;
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("id", id);
					map.put("start", start);
					map.put("end", end);
					map.put("eventid", eventid);
					count = (int) mybatisDAOImpl.expandByObj(
							"common.ajax.checkDailyConflict", map);
					if(count > 0){	
						entity.setCount(count);
						entity.setId(id);
						return entity;
					}
				}
			}
		}
		entity.setCount(count);
		return entity;
	}
	
	@Override
	public String getDeviceName(String dailydeviceid) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("dailydeviceid", dailydeviceid);
		String deviceName = (String) mybatisDAOImpl.expandByObj(
				"common.ajax.getDeviceName", map);
		mybatisDAOImpl.close();
		return deviceName;
	}
	
	@Override
	public String getEmpName(String empid) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empid", empid);
		String empName = (String) mybatisDAOImpl.expandByObj(
				"common.ajax.getEmpName", map);
		mybatisDAOImpl.close();
		return empName;
	}

	public List<EventDevice> creatEventDevice(String eventdevicesid){
		if(StringUtils.isEmpty( eventdevicesid)){
				return null;
		}
		List<EventDevice> list = new ArrayList<EventDevice>();
		String[] str = eventdevicesid.split(",");
		for(String dailydeviceid:str){
			EventDevice eventDevice= new EventDevice();
			eventDevice.setDailydeviceid(dailydeviceid);;
			list.add(eventDevice);
		}
		return list;
	}
	
	public List<EventConnect> creatEventConnect(String eventconnectsid, String empid){
		if(StringUtils.isEmpty( eventconnectsid)){
			eventconnectsid = empid; 
		}else{//判断当前empid是否包含在列表中
			if(eventconnectsid.indexOf(empid) < 0){
				eventconnectsid += "," + empid; 
			}
		}
		List<EventConnect> list = new ArrayList<EventConnect>();		
		String[] str = eventconnectsid.split(",");
		for(String id:str){
			EventConnect eventConnect = new EventConnect();
			eventConnect.setEmpid(id);
			list.add(eventConnect);
		}
		return list;
	}	
}
