package com.lw.oa.common.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lw.oa.common.command.DictEntity;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.service.IAjaxService;

/**
 * *@author yuliang
 */
@Controller
@RequestMapping("/common/ajax/")
public class AjaxController {
	@Autowired
	private IAjaxService ajaxService;
	/**
	 * 申请单服务器目录生成
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "applyFileGenerate.do" },method = RequestMethod.GET)
	public void applyFileGenerate(HttpServletRequest request,HttpServletResponse response){	
		String empid = request.getParameter("empid");			
		int count = ajaxService.fileGenerate( request, empid);
		JSONObject jsonobj = new JSONObject();	
		if(count == 0 || count == 999){
			jsonobj.put("flag", true);
			if(count == 0)
				jsonobj.put("msgid", "ERROR_COMM_0004");
			else 
				jsonobj.put("msgid", "MSG_COMM_0044");
		}else{
			jsonobj.put("flag", false);
		}
		try {
			response.getWriter().write(JSON.toJSONString(jsonobj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查身份证唯一性
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkUniqueCardno.do" },method = RequestMethod.GET)
	public void checkUniqueCardno(HttpServletRequest request,HttpServletResponse response){
		String cardno = request.getParameter("cardno");			
		int count = ajaxService.checkUniqueCardno(cardno);
		JSONObject jsonobj = new JSONObject();	
		if(count > 0){
			jsonobj.put("flag", true);
			jsonobj.put("msgid", "ERROR_COMM_0002");
		}else{
			jsonobj.put("flag", false);
		}
		try {
			response.getWriter().write(JSON.toJSONString(jsonobj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据组织机构id获取所有的部门
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "getDepsByOrgcdid.do" },method = RequestMethod.GET)
	public void getDepsByOrgcdid(HttpServletRequest request,HttpServletResponse response){
		String orgcdid = request.getParameter("orgcdid");			
		@SuppressWarnings("unchecked")
		List<DictEntity> list = (List<DictEntity>) ajaxService.getDepsByOrgcdid(orgcdid);
		//将list转化成jsonarray
		JSONArray jsonarray = new JSONArray();	
		for(DictEntity entity:list){
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("busidictid", entity.getBusidictid());
			jsonobj.put("busidictname", entity.getBusidictname());
			jsonarray.add(jsonobj);
		}
		try {
			response.getWriter().write(JSON.toJSONString(jsonarray));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据组织机构id部门id获取所有的员工
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "getEmpsByOrgcdDepid.do" },method = RequestMethod.GET)
	public void getEmpsByOrgcdDepid(HttpServletRequest request,HttpServletResponse response){
		String orgcdid = request.getParameter("orgcdid");	
		String depid = request.getParameter("depid");		
		@SuppressWarnings("unchecked")
		List<DictEntity> list = (List<DictEntity>) ajaxService.getEmpsByOrgcdDepid(orgcdid, depid);
		//将list转化成jsonarray
		JSONArray jsonarray = new JSONArray();	
		for(DictEntity entity:list){
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("busidictid", entity.getBusidictid());
			jsonobj.put("busidictname", entity.getBusidictname());
			jsonarray.add(jsonobj);
		}
		try {
			response.getWriter().write(JSON.toJSONString(jsonarray));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查用户名唯一性
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkUniqueUsername.do" },method = RequestMethod.GET)
	public void checkUniqueUsername(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");		
		String empid = request.getParameter("empid");	
		int count = ajaxService.checkUniqueUsername(username, empid);
		Map<String,Object> resultMap = new HashMap<String,Object>();		
		if(count > 0){
			resultMap.put("flag", true);
			resultMap.put("msgid", "ERROR_PA001_0001");
		}else{
			resultMap.put("flag", false);
		}
		try {
			response.getWriter().write(JSON.toJSONString(resultMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查年历是否生成
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkLegalyear.do" }, method = RequestMethod.GET)
	public void checkLegalyear(HttpServletRequest request,HttpServletResponse response){
		String legalyear = request.getParameter("legalyear");
		int count = ajaxService.checkLegalyear(legalyear);
		Map<String,Object> resultMap = new HashMap<String,Object>();		
		if(count > 0){
			resultMap.put("flag", true);
			resultMap.put("msgid", "ERROR_PA003_0001");
		}else
			resultMap.put("flag", false);
		try {
			response.getWriter().write(JSON.toJSONString(resultMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查年假是否生成
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkAnnualVctn.do" }, method = RequestMethod.GET)
	public void checkAnnualVctn(HttpServletRequest request,HttpServletResponse response){
		String year = request.getParameter("year");
		int count = ajaxService.checkAnnualVctn(year);
		Map<String,Object> resultMap = new HashMap<String,Object>();		
		if(count > 0){
			resultMap.put("flag", true);
			resultMap.put("msgid", "ERROR_PA005_0001");
		}else
			resultMap.put("flag", false);
		try {
			response.getWriter().write(JSON.toJSONString(resultMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查设备是否已被预约
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkDeviceOrder.do" },method = RequestMethod.GET)
	public void checkDeviceOrder(HttpServletRequest request,HttpServletResponse response){
		String eventdevicesid = request.getParameter("eventdevicesid");
		String eventstart = request.getParameter("eventstart");
		String eventend = request.getParameter("eventend");
		String eventstarthm = request.getParameter("eventstarthm");
		String eventendhm = request.getParameter("eventendhm");
		String dailycycle = request.getParameter("dailycycle");
		String eventid = request.getParameter("eventid");
		RetInfo retInfo = ajaxService.checkDeviceOrder(eventdevicesid, eventstart, eventend, eventstarthm, eventendhm, dailycycle, eventid);
		Map<String,Object> resultMap = new HashMap<String,Object>();	
		if(retInfo.getCode() != null){			
			resultMap.put("flag", true);
			resultMap.put("msgid", retInfo.getCode());
			String deviceName = ajaxService.getDeviceName(retInfo.getMessage());
			resultMap.put("param1", deviceName);
		}else{
			resultMap.put("flag", false);
		}
		try {
			response.getWriter().write(JSON.toJSONString(resultMap));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 检查日程是否冲突
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "checkDailyConflict.do" },method = RequestMethod.GET)
	public void checkDailyConflict(HttpServletRequest request,HttpServletResponse response){
		String eventconnectsid = request.getParameter("eventconnectsid");
		String eventstart = request.getParameter("eventstart");	
		String eventend = request.getParameter("eventend");	
		String eventstarthm = request.getParameter("eventstarthm");
		String eventendhm = request.getParameter("eventendhm");
		String dailycycle = request.getParameter("dailycycle");
		String empid = request.getParameter("empid");
		String eventid = request.getParameter("eventid");
		RetInfo retInfo = ajaxService.checkDailyConflict(eventconnectsid, eventstart, eventend, eventstarthm, eventendhm, dailycycle, empid, eventid);
		Map<String,Object> resultMap = new HashMap<String,Object>();	
		if(retInfo.getCode() != null){			
			resultMap.put("flag", true);
			resultMap.put("msgid", retInfo.getCode());
			String empName = ajaxService.getEmpName(retInfo.getMessage());
			resultMap.put("param1", empName);
		}else{
			resultMap.put("flag", false);
		}
		try {
			response.getWriter().write(JSON.toJSONString(resultMap));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
