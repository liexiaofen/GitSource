package com.lw.oa.pa.master.pa005;

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
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pa/pa005/")
public class PA005Controller implements ConstantUtil{		
	//查询画面	
	private static final String  PAGE_SEARCH = "pa/pa005/pa005001List";
	//详细画面	
	private static final String  PAGE_DETAIL = "pa/pa005/pa005002Detail";
	//登录画面	
	private static final String  PAGE_INSERT = "pa/pa005/pa005003Insert";
	//修改画面	
	private static final String  PAGE_UPDATE = "pa/pa005/pa005004Update";
	@Autowired
	private IPA005Service pa005Service;
	/**
	 * 年假信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001init.do" },method = RequestMethod.GET)
	public ModelAndView pa005001init(HttpServletRequest request)
	{						
		//初始化时间
		String year = DateUtil.getSystemTime(DATE_FORMAT_YYYY);		
		PA005001SearchCommand searchCommand = new PA005001SearchCommand();
		searchCommand.setYear(year);
		return pa005001search(request, searchCommand, null);
	}
	/**
	 * 年假信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001search.do" },method = RequestMethod.POST)
	public ModelAndView pa005001search(HttpServletRequest request, PA005001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<PA005001ResultCommand> list = (List<PA005001ResultCommand>) pa005Service.pa005001search(searchCommand);
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
	 * 年假信息一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001page.do" },method = RequestMethod.POST)
	public ModelAndView pa005001page(HttpServletRequest request, PA005001SearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<PA005001ResultCommand> list = (List<PA005001ResultCommand>) pa005Service.pa005001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 *年假信息一览画面登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001insert.do" },method = RequestMethod.POST)
	public ModelAndView pa005001insert(HttpServletRequest request, PA005001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PA005Command command = new PA005Command();
		command.setPa005001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 年假信息一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001view.do" },method = RequestMethod.POST)
	public ModelAndView pa005001view(HttpServletRequest request, PA005001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA005Command command = pa005Service.pa005001view(searchCommand);
		command.setPa005001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_DETAIL, resultMap);				
		return mav;
	}
	/**
	 * 年假信息一览画面编辑
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005001edit.do" },method = RequestMethod.POST)
	public ModelAndView pa005001edit(HttpServletRequest request, PA005001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA005Command command = pa005Service.pa005001view(searchCommand);
		command.setPa005001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 年假信息详细画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005002back.do" },method = RequestMethod.POST)
	public ModelAndView pa005002back(HttpServletRequest request, PA005Command command)
	{			
		return pa005001search(request, command.getPa005001searchcommand(), null);
	}
	/**
	 * 年假信息登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005003save.do" },method = RequestMethod.POST)
	public ModelAndView pa005003save(HttpServletRequest request, PA005Command command)
	{				
		pa005Service.pa005003save(command, request);		
		return pa005001search(request, command.getPa005001searchcommand(), null);
	}	
	/**
	 * 年假信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005003back.do" },method = RequestMethod.POST)
	public ModelAndView pa005003back(HttpServletRequest request, PA005Command command)
	{			
		return pa005001search(request, command.getPa005001searchcommand(), null);
	}
	/**
	 * 年假信息编辑画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005004update.do" },method = RequestMethod.POST)
	public ModelAndView pa005004update(HttpServletRequest request, PA005Command command)
	{				
		int cnt = pa005Service.pa005004update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa005001search(request, command.getPa005001searchcommand(), retInfo);
	}
	/**
	 * 年假信息编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa005004back.do" },method = RequestMethod.POST)
	public ModelAndView pa005004back(HttpServletRequest request, PA005Command command)
	{			
		return pa005001search(request, command.getPa005001searchcommand(), null);
	}
}
