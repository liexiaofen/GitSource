package com.lw.oa.pa.master.pa001;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pa/pa001/")
public class PA001Controller {	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pa/pa001/pa001001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pa/pa001/pa001001List";
	//修改画面	
	private static final String  PAGE_UPDATE = "pa/pa001/pa001002Update";
	//登录画面	
	private static final String  PAGE_INSERT = "pa/pa001/pa001003Insert";	
	@Autowired
	private IPA001Service pa001Service;
	/**
	 * 员工信息init画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001001init.do" },method = RequestMethod.GET)
	public ModelAndView pa001001init(HttpServletRequest request)
	{	
		return pa001001search(request, new PA001001SearchCommand(), null);
	}
	/**
	 * 员工信息search画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001001search.do" },method = RequestMethod.POST)
	public ModelAndView pa001001search(HttpServletRequest request, PA001001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<PA001001ResultCommand> list = (List<PA001001ResultCommand>) pa001Service.pa001001search(searchCommand);
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
	 * 员工信息一览翻页画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001001page.do" },method = RequestMethod.POST)
	public ModelAndView pa001001page(HttpServletRequest request, PA001001SearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<PA001001ResultCommand> list = (List<PA001001ResultCommand>) pa001Service.pa001001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 * 员工登录画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001001insert.do" },method = RequestMethod.POST)
	public ModelAndView pa001001insert(HttpServletRequest request, PA001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PA001Command command = new PA001Command();
		command.setPa001001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 员工详细画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001001view.do" },method = RequestMethod.POST)
	public ModelAndView pa001001view(HttpServletRequest request, PA001001SearchCommand searchCommand,@RequestParam("empid") String id)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA001Command command = pa001Service.pa001001view(searchCommand);
		command.setPa001001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 员工登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001003save.do" },method = RequestMethod.POST)
	public ModelAndView pa001003save(HttpServletRequest request, PA001Command command)
	{				
		pa001Service.pa001003save(command, request);		
		return pa001001search(request, command.getPa001001searchcommand(), null);
	}	
	/**
	 * 员工登录返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001003back.do" },method = RequestMethod.POST)
	public ModelAndView pa001003back(HttpServletRequest request, PA001Command command)
	{			
		return pa001001search(request, command.getPa001001searchcommand(), null);
	}
	/**
	 * 员工详细画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001002update.do" },method = RequestMethod.POST)
	public ModelAndView pa001002update(HttpServletRequest request, PA001Command command)
	{				
		int cnt = pa001Service.pa001002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa001001search(request, command.getPa001001searchcommand(), retInfo);
	}
	/**
	 * 员工详细画面删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001002delete.do" },method = RequestMethod.POST)
	public ModelAndView pa001002delete(HttpServletRequest request, PA001Command command)
	{				
		int cnt = pa001Service.pa001002delete(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa001001search(request, command.getPa001001searchcommand(), retInfo);
	}	
	/**
	 * 员工修改返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa001002back.do" },method = RequestMethod.POST)
	public ModelAndView pa001002back(HttpServletRequest request, PA001Command command){
		return pa001001search(request, command.getPa001001searchcommand(), null);
	}	
}
