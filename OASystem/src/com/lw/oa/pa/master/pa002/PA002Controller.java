package com.lw.oa.pa.master.pa002;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pa/pa002/")
public class PA002Controller {	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pa/pa002/pa002001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pa/pa002/pa002001List";
	//修改画面	
	private static final String  PAGE_UPDATE = "pa/pa002/pa002002Update";
	//登录画面	
	private static final String  PAGE_INSERT = "pa/pa002/pa002003Insert";
	
	@Autowired
	private IPA002Service pa002Service;
	/**
	 * 设备信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002001init.do" },method = RequestMethod.GET)
	public ModelAndView pa002001init(HttpServletRequest request){
		return pa002001search(request, new PA002001SearchCommand(), null);
	}
	/**
	 * 设备信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002001search.do" },method = RequestMethod.POST)
	public ModelAndView pa002001search(HttpServletRequest request, PA002001SearchCommand searchCommand, RetInfo retInfo){
		@SuppressWarnings("unchecked")
		List<PA002001ResultCommand> list = (List<PA002001ResultCommand>) pa002Service.pa002001search(searchCommand);
		RetInfo searchRetInfo = MessageUtil.getMessageNoResult(list.size());
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		resultMap.put("searchRetInfo", searchRetInfo);
		resultMap.put("retInfo", retInfo);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 * 设备信息一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002001page.do" },method = RequestMethod.POST)
	public ModelAndView pa002001page(HttpServletRequest request, PA002001SearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<PA002001ResultCommand> list = (List<PA002001ResultCommand>) pa002Service.pa002001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 *设备信息一览画面登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002001insert.do" },method = RequestMethod.POST)
	public ModelAndView pa002001insert(HttpServletRequest request, PA002001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PA002Command command = new PA002Command();
		command.setPa002001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 设备信息一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002001view.do" },method = RequestMethod.POST)
	public ModelAndView pa002001view(HttpServletRequest request, PA002001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA002Command command = pa002Service.pa002001view(searchCommand);
		command.setPa002001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 设备信息登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002003save.do" },method = RequestMethod.POST)
	public ModelAndView pa002003save(HttpServletRequest request, PA002Command command)
	{				
		pa002Service.pa002003save(command, request);		
		return pa002001search(request, command.getPa002001searchcommand(), null);
	}	
	/**
	 * 设备信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002003back.do" },method = RequestMethod.POST)
	public ModelAndView pa002003back(HttpServletRequest request, PA002Command command)
	{			
		return pa002001search(request, command.getPa002001searchcommand(), null);
	}
	/**
	 * 设备信息编辑画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002002update.do" },method = RequestMethod.POST)
	public ModelAndView pa002002update(HttpServletRequest request, PA002Command command)
	{				
		int cnt = pa002Service.pa002002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa002001search(request, command.getPa002001searchcommand(), retInfo);
	}
	/**
	 * 设备信息编辑画面删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002002delete.do" },method = RequestMethod.POST)
	public ModelAndView pa002002delete(HttpServletRequest request, PA002Command command)
	{				
		int cnt = pa002Service.pa002002delete(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa002001search(request, command.getPa002001searchcommand(), retInfo);
	}	
	/**
	 * 设备信息编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa002002back.do" },method = RequestMethod.POST)
	public ModelAndView pa002002back(HttpServletRequest request, PA002Command command)
	{			
		return pa002001search(request, command.getPa002001searchcommand(), null);
	}
}
