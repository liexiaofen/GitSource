package com.lw.system.framework.fa004;

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
import com.lw.oa.common.dao.DictDAOImpl;
import com.lw.oa.common.dao.IDictDAO;
import com.lw.oa.common.service.ICommonService;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/fa/fa004/")
public class FA004Controller implements ConstantUtil{		
	//初始化画面	
	//private static final String  PAGE_INIT = "fa/fa004/fa004001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "fa/fa004/fa004001List";
	//登录画面	
	private static final String  PAGE_INSERT = "fa/fa004/fa004003Insert";	
	//编辑画面	
	private static final String  PAGE_UPDATE = "fa/fa004/fa004002Update";	
	@Autowired
	private IFA004Service fa004Service;
	@Autowired
	private ICommonService commonService;
	/**
	 * 业务字典信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001init.do" },method = RequestMethod.GET)
	public ModelAndView fa004001init(HttpServletRequest request)
	{					
		FA004001SearchCommand searchCommand = new FA004001SearchCommand();
		return fa004001search(request, searchCommand, null);
	}
	/**
	 * 业务字典信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001search.do" },method = RequestMethod.POST)
	public ModelAndView fa004001search(HttpServletRequest request, FA004001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<FA004001ResultCommand> list = (List<FA004001ResultCommand>) fa004Service.fa004001search(searchCommand);
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
	 * 业务字典信息一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001page.do" },method = RequestMethod.POST)
	public ModelAndView fa004001page(HttpServletRequest request, FA004001SearchCommand searchCommand)
	{			
		@SuppressWarnings("unchecked")
		List<FA004001ResultCommand> list = (List<FA004001ResultCommand>) fa004Service.fa004001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}	
	/**
	 * 业务字典信息一览画面删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001delete.do" }, method = RequestMethod.POST)
	public ModelAndView fa004001delete(HttpServletRequest request,
			FA004001SearchCommand searchCommand) {
		int cnt = fa004Service.fa004001delete(searchCommand, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return fa004001search(request, searchCommand, retInfo);
	}
	/**
	 * 业务字典信息编辑画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001edit.do" },method = RequestMethod.POST)
	public ModelAndView fa004001edit(HttpServletRequest request, FA004001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		FA004Command command = fa004Service.fa004001view(searchCommand);
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 业务字典信息登录画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004001insert.do" },method = RequestMethod.POST)
	public ModelAndView fa004001insert(HttpServletRequest request, FA004001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		FA004Command command = new FA004Command();
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	@RequestMapping(value = { "fa004001refreshCache.do" },method = RequestMethod.POST)
	public ModelAndView pa004001refreshCache(HttpServletRequest request, FA004001SearchCommand searchCommand, RetInfo retInfo)
	{			
		//缓存处理
		IDictDAO dictDAOImpl = new DictDAOImpl();
		dictDAOImpl.close();
		dictDAOImpl.openSession();
		return fa004001search(request, searchCommand, null);
	}
	/**
	 * 业务字典信息编辑保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004002save.do" },method = RequestMethod.POST)
	public ModelAndView fa004002save(HttpServletRequest request, FA004Command command)
	{				
		fa004Service.fa004002update(command, request);
		return fa004001search(request, command.getSearchCommand(), null);
	}	
	/**
	 * 业务字典信息登录保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004003save.do" },method = RequestMethod.POST)
	public ModelAndView fa004003save(HttpServletRequest request, FA004Command command)
	{				
		fa004Service.fa004003insert(command, request);
		return fa004001search(request, command.getSearchCommand(), null);
	}	
	/**
	 * 业务字典信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa004003back.do" },method = RequestMethod.POST)
	public ModelAndView fa004003back(HttpServletRequest request, FA004Command command)
	{			
		return fa004001search(request, command.getSearchCommand(), null);
	}
}
