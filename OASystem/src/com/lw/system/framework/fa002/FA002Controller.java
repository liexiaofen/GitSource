package com.lw.system.framework.fa002;

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
//@RequestMapping("/fa/fa002/")
public class FA002Controller implements ConstantUtil{		
	//初始化画面	
	//private static final String  PAGE_INIT = "fa/fa002/fa002001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "fa/fa002/fa002001List";
	//主菜单登录画面	
	private static final String  PAGE_INSERT = "fa/fa002/fa002002Insert";	
	//权限树画面	
	private static final String  PAGE_AUTHORITY_TREE = "fa/fa002/ztree";	
	@Autowired
	private IFA002Service fa002Service;
	@Autowired
	private ICommonService commonService;
	/**
	 * 角色信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001init.do" },method = RequestMethod.GET)
	public ModelAndView fa002001init(HttpServletRequest request)
	{					
		FA002001SearchCommand searchCommand = new FA002001SearchCommand();
		return fa002001search(request, searchCommand, null);
	}
	/**
	 * 角色信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001search.do" },method = RequestMethod.POST)
	public ModelAndView fa002001search(HttpServletRequest request, FA002001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<FA002001ResultCommand> list = (List<FA002001ResultCommand>) fa002Service.fa002001search(searchCommand);
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
	 * 角色信息一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001page.do" },method = RequestMethod.POST)
	public ModelAndView fa002001page(HttpServletRequest request, FA002001SearchCommand searchCommand)
	{			
		@SuppressWarnings("unchecked")
		List<FA002001ResultCommand> list = (List<FA002001ResultCommand>) fa002Service.fa002001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}	
	/**
	 * 角色信息一览画面删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001delete.do" }, method = RequestMethod.POST)
	public ModelAndView fa002001delete(HttpServletRequest request,
			FA002001SearchCommand searchCommand) {
		int cnt = fa002Service.fa002001delete(searchCommand, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
 		return fa002001search(request, searchCommand, retInfo);
	}
	
	/**
	 * 角色信息权限树保存
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001setAuthority.do" }, method = RequestMethod.POST)
	public ModelAndView fa002001setAuthority(HttpServletRequest request,
			FA002001SearchCommand searchCommand) {
		fa002Service.fa002001setAuthority(searchCommand, request);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView( PAGE_AUTHORITY_TREE, resultMap);		
 		return mav;
	}
	/**
	 * 角色信息登录画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002001insert.do" },method = RequestMethod.POST)
	public ModelAndView fa002001insert(HttpServletRequest request, FA002001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		FA002Command command = new FA002Command();
		command.setSearchCommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 角色信息登录保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002002save.do" },method = RequestMethod.POST)
	public ModelAndView fa002003save(HttpServletRequest request, FA002Command command)
	{				
		fa002Service.fa002002insert(command, request);
		return fa002001search(request, command.getSearchCommand(), null);
	}	
	/**
	 * 角色信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "fa002002back.do" },method = RequestMethod.POST)
	public ModelAndView fa002003back(HttpServletRequest request, FA002Command command)
	{			
		return fa002001search(request, command.getSearchCommand(), null);
	}
}
