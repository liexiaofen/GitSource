package com.lw.system.framework.fa001;

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
import com.lw.oa.common.service.ICommonService;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/fa/fa001/")
public class FA001Controller implements ConstantUtil{		
	//初始化画面	
	//private static final String  PAGE_INIT = "fa/fa001/fa001001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "fa/fa001/fa001001List";
	//主菜单登录画面	
	private static final String  PAGE_INSERT = "fa/fa001/fa001003MenuInsert";	
	//子菜单登录画面	
	private static final String  PAGE_SUB_INSERT = "fa/fa001/fa001004SubMenuInsert";	
	//编辑画面	
	private static final String  PAGE_UPDATE = "fa/fa001/fa001002Update";	
	@Autowired
	private IFA001Service fa001Service;
	@Autowired
	private ICommonService commonService;
	/**
	 * 菜单信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001init.do" },method = RequestMethod.GET)
	public ModelAndView fa001001init(HttpServletRequest request)
	{					
		FA001001SearchCommand searchCommand = new FA001001SearchCommand();
		return fa001001search(request, searchCommand, null);
	}
	/**
	 * 菜单信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001search.do" },method = RequestMethod.POST)
	public ModelAndView fa001001search(HttpServletRequest request, FA001001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<FA001001ResultCommand> list = (List<FA001001ResultCommand>) fa001Service.fa001001search(searchCommand);
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
	 * 菜单信息一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001page.do" },method = RequestMethod.POST)
	public ModelAndView fa001001page(HttpServletRequest request, FA001001SearchCommand searchCommand)
	{			
		@SuppressWarnings("unchecked")
		List<FA001001ResultCommand> list = (List<FA001001ResultCommand>) fa001Service.fa001001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}	
	/**
	 * 菜单信息一览画面删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001delete.do" }, method = RequestMethod.POST)
	public ModelAndView fa001001delete(HttpServletRequest request,
			FA001001SearchCommand searchCommand) {
		int cnt = fa001Service.fa001001delete(searchCommand, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
 		return fa001001search(request, searchCommand, retInfo);
	}
	/**
	 * 菜单数跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001edit.do" },method = RequestMethod.GET)
	public ModelAndView fa001001edit(HttpServletRequest request)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String id = request.getParameter("id");
		FA001001SearchCommand searchCommand = new FA001001SearchCommand();
		searchCommand.setResourceid(id);
		resultMap.put("searchCommand", searchCommand);
		FA001Command command = fa001Service.fa001001view(searchCommand);
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 菜单信息编辑画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001view.do" },method = RequestMethod.POST)
	public ModelAndView fa001001view(HttpServletRequest request, FA001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		FA001Command command = fa001Service.fa001001view(searchCommand);
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 菜单信息登录画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001001insert.do" },method = RequestMethod.POST)
	public ModelAndView fa001001insert(HttpServletRequest request, FA001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		FA001Command command = new FA001Command();
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 菜单信息编辑保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001002update.do" },method = RequestMethod.POST)
	public ModelAndView fa001002update(HttpServletRequest request, FA001Command command)
	{				
		int cnt = fa001Service.fa001002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return fa001001search(request, command.getSearchCommand(), retInfo);
	}
	/**
	 * 菜单信息编辑增加子菜单
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001002subadd.do" },method = RequestMethod.POST)
	public ModelAndView fa001002subadd(HttpServletRequest request, FA001Command command)
	{				
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", command.getSearchCommand());
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_SUB_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 菜单信息登录保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001003save.do" },method = RequestMethod.POST)
	public ModelAndView fa001003save(HttpServletRequest request, FA001Command command)
	{				
		fa001Service.fa001003insert(command, request);
		return fa001001search(request, command.getSearchCommand(), null);
	}	
	/**
	 * 子菜单信息登录保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001004save.do" },method = RequestMethod.POST)
	public ModelAndView fa001004save(HttpServletRequest request, FA001Command command)
	{				
		fa001Service.fa001003insert(command, request);
		return fa001001search(request, command.getSearchCommand(), null);
	}	
	/**
	 * 菜单信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa001003back.do" },method = RequestMethod.POST)
	public ModelAndView fa001003back(HttpServletRequest request, FA001Command command)
	{			
		return fa001001search(request, command.getSearchCommand(), null);
	}
}
