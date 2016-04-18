package com.lw.oa.pb.daily.pb001;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.util.CalendarUtil;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pb/pb001/")
public class PB001Controller implements ConstantUtil {	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pb/pb001/pb001001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pb/pb001/pb001001List";
	//修改画面	
	private static final String  PAGE_UPDATE = "pb/pb001/pb001002Update";
	//登录画面	
	private static final String  PAGE_INSERT = "pb/pb001/pb001003Insert";	
	//详细画面模式窗口	
	private static final String  PAGE_DETAIL = "pb/pb001/pb001004Detail";
	//月预定画面	
	private static final String  PAGE_MONTH = "pb/pb001/pb001001MonthList1";
	
	@Autowired
	private IPB001Service pb001Service;
	
	/**
	 * 日程安排一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001init.do" },method = RequestMethod.GET)
	public ModelAndView pb001001init(HttpServletRequest request)
	{				
		//初始化时间
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMD);		
		PB001001SearchCommand searchCommand = new PB001001SearchCommand();
		String empid = STRING_EMPTY;
		//从session中获取当前用户id
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		searchCommand.setDisplaydate(sysdate);
		searchCommand.setEmpid(empid);
		return pb001001search(request, searchCommand, null);
	}
	/**
	 * 日程安排一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001search.do" },method = RequestMethod.POST)
	public ModelAndView pb001001search(HttpServletRequest request, PB001001SearchCommand searchCommand, RetInfo retInfo)
	{					
		//根据显示日历，查询一周的所有日期，并进行title的赋值处理
		PB001001ResultTitleCommand title = pb001Service.getLegalDateListByWeek(searchCommand);
		@SuppressWarnings("unchecked")
		List<PB001001ResultCommand> list = (List<PB001001ResultCommand>) pb001Service.pb001001search(searchCommand,title);
		RetInfo searchRetInfo = MessageUtil.getMessageNoResult(list.size());
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		resultMap.put("title", title);
		resultMap.put("searchRetInfo", searchRetInfo);
		resultMap.put("retInfo", retInfo);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 * 日程安排一览画面上一周
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001lastWeek.do" },method = RequestMethod.POST)
	public ModelAndView pb001001lastWeek(HttpServletRequest request, PB001001SearchCommand searchCommand, RetInfo retInfo)
	{			
		String displaydate = CalendarUtil.getLastWeekByDate(searchCommand.getDisplaydate());
		searchCommand.setDisplaydate(displaydate);
		return pb001001search(request, searchCommand, null);
	}
	/**
	 * 日程安排一览画面下一周
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001nextWeek.do" },method = RequestMethod.POST)
	public ModelAndView pb001001nextWeek(HttpServletRequest request, PB001001SearchCommand searchCommand, RetInfo retInfo)
	{					
		String displaydate = CalendarUtil.getNextWeekByDate(searchCommand.getDisplaydate());
		searchCommand.setDisplaydate(displaydate);
		return pb001001search(request, searchCommand, null);
	}
	/**
	 * 日程安排一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001page.do" },method = RequestMethod.POST)
	public ModelAndView pb001001page(HttpServletRequest request, PB001001SearchCommand searchCommand)
	{			
		//根据显示日历，查询一周的所有日期，并进行title的赋值处理
		PB001001ResultTitleCommand title = pb001Service.getLegalDateListByWeek(searchCommand);
		@SuppressWarnings("unchecked")
		List<PB001001ResultCommand> list = (List<PB001001ResultCommand>) pb001Service.pb001001search(searchCommand, title);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		resultMap.put("title", title);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 *日程安排一览画面登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001insert.do" },method = RequestMethod.POST)
	public ModelAndView pb001001insert(HttpServletRequest request, PB001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PB001Command command = new PB001Command();
		command.setPb001001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 日程安排一览画面编辑
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001edit.do" },method = RequestMethod.POST)
	public ModelAndView pb001001edit(HttpServletRequest request, PB001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PB001Command command = pb001Service.pb001001edit(searchCommand);
		command.setPb001001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 日程安排一览画面月预定
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001001month.do" },method = RequestMethod.POST)
	public ModelAndView pb001001month(HttpServletRequest request, PB001001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();			
		PB001Command command = pb001Service.pb001001month(searchCommand);
		command.setPb001001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_MONTH, resultMap);	
		return mav;
	}
	/**
	 * Modal日程安排详细画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001searchDailyDetail.do" },method = RequestMethod.GET)
	public ModelAndView pb001searchDailyDetail(HttpServletRequest request)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String dailyid = request.getParameter("dailyid");
		PB001001SearchCommand searchCommand = new PB001001SearchCommand();
		searchCommand.setDailyid(dailyid);
		PB001Command command = pb001Service.pb001001edit(searchCommand);		
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_DETAIL, resultMap);				
		return mav;
	}		
	/**
	 * 日程安排登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001003save.do" },method = RequestMethod.POST)
	public ModelAndView pb001003save(HttpServletRequest request, PB001Command command)
	{				
		pb001Service.pb001003save(command, request);		
		return pb001001search(request, command.getPb001001searchcommand(), null);
	}	
	/**
	 * 日程安排登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001003back.do" },method = RequestMethod.POST)
	public ModelAndView pb001003back(HttpServletRequest request, PB001Command command)
	{			
		return pb001001search(request, command.getPb001001searchcommand(), null);
	}	
	/**
	 * 日程安排编辑画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001002update.do" },method = RequestMethod.POST)
	public ModelAndView pb001002update(HttpServletRequest request, PB001Command command)
	{				
		int cnt = pb001Service.pb001002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pb001001search(request, command.getPb001001searchcommand(), retInfo);
	}
	/**
	 * 日程安排编辑画面取消
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001002cancel.do" },method = RequestMethod.POST)
	public ModelAndView pb001002cancel(HttpServletRequest request, PB001Command command)
	{				
		int cnt = pb001Service.pb001002cancel(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pb001001search(request, command.getPb001001searchcommand(), retInfo);
	}	
	/**
	 * 日程安排编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb001002back.do" },method = RequestMethod.POST)
	public ModelAndView pb001002back(HttpServletRequest request, PB001Command command)
	{			
		return pb001001search(request, command.getPb001001searchcommand(), null);
	}
}
