package com.lw.oa.pa.master.pa004;

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
//@RequestMapping("/pa/pa004/")
public class PA004Controller {	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pa/pa004/pa004001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pa/pa004/pa004001List";
	//修改画面	
	private static final String  PAGE_UPDATE = "pa/pa004/pa004002Update";
	//登录画面	
	private static final String  PAGE_INSERT = "pa/pa004/pa004003Insert";
	
	@Autowired
	private IPA004Service pa004Service;
	/**
	 * 设备信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004001init.do" },method = RequestMethod.GET)
	public ModelAndView pa004001init(HttpServletRequest request)
	{						
		return pa004001search(request, new PA004001SearchCommand(), null);
	}
	/**
	 * 设备信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004001search.do" },method = RequestMethod.POST)
	public ModelAndView pa004001search(HttpServletRequest request, PA004001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<PA004001ResultCommand> list = (List<PA004001ResultCommand>) pa004Service.pa004001search(searchCommand);
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
	@RequestMapping(value = { "pa004001page.do" },method = RequestMethod.POST)
	public ModelAndView pa004001page(HttpServletRequest request, PA004001SearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<PA004001ResultCommand> list = (List<PA004001ResultCommand>) pa004Service.pa004001search(searchCommand);
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
	@RequestMapping(value = { "pa004001insert.do" },method = RequestMethod.POST)
	public ModelAndView pa004001insert(HttpServletRequest request, PA004001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PA004Command command = new PA004Command();
		command.setPa004001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 设备信息一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004001view.do" },method = RequestMethod.POST)
	public ModelAndView pa004001view(HttpServletRequest request, PA004001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA004Command command = pa004Service.pa004001view(searchCommand);
		command.setPa004001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 设备信息登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004003save.do" },method = RequestMethod.POST)
	public ModelAndView pa004003save(HttpServletRequest request, PA004Command command)
	{				
		pa004Service.pa004003save(command, request);		
		return pa004001search(request, command.getPa004001searchcommand(), null);
	}	
	/**
	 * 设备信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004003back.do" },method = RequestMethod.POST)
	public ModelAndView pa004003back(HttpServletRequest request, PA004Command command)
	{			
		return pa004001search(request, command.getPa004001searchcommand(), null);
	}
	/**
	 * 设备信息编辑画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004002update.do" },method = RequestMethod.POST)
	public ModelAndView pa004002update(HttpServletRequest request, PA004Command command)
	{				
		int cnt = pa004Service.pa004002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa004001search(request, command.getPa004001searchcommand(), retInfo);
	}
	/**
	 * 设备信息编辑画面删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004002delete.do" },method = RequestMethod.POST)
	public ModelAndView pa004002delete(HttpServletRequest request, PA004Command command)
	{				
		int cnt = pa004Service.pa004002delete(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa004001search(request, command.getPa004001searchcommand(), retInfo);
	}	
	/**
	 * 设备信息编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa004002back.do" },method = RequestMethod.POST)
	public ModelAndView pa004002back(HttpServletRequest request, PA004Command command)
	{			
		return pa004001search(request, command.getPa004001searchcommand(), null);
	}
}
