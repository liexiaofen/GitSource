package com.lw.oa.pb.daily.pb002;

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

import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.util.CalendarUtil;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pb/pb002/")
public class PB002Controller implements ConstantUtil {	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pb/pb002/pb002001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pb/pb002/pb002001List";
	//月预定画面	
	private static final String  PAGE_MONTH = "pb/pb002/pb002001MonthList";
	@Autowired
	private IPB002Service pb002Service;
	
	/**
	 * 设备空闲一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001init.do" },method = RequestMethod.GET)
	public ModelAndView pb002001init(HttpServletRequest request)
	{				
		//初始化时间
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMD);	
		String orgcdid = STRING_EMPTY;
		PB002001SearchCommand searchCommand = new PB002001SearchCommand();
		searchCommand.setDisplaydate(sysdate);
		//从session中获取当前用户id对应的orgcdid
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			orgcdid = sessionEntity.getOrgcdid();
		}
		searchCommand.setOrgcdid(SYMBOL_SINGLEQUOTES+orgcdid+SYMBOL_SINGLEQUOTES);	
		return pb002001search(request, searchCommand, null);
	}
	/**
	 * 设备空闲一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001search.do" },method = RequestMethod.POST)
	public ModelAndView pb002001search(HttpServletRequest request, PB002001SearchCommand searchCommand, RetInfo retInfo)
	{					
		//根据显示日历，查询一周的所有日期，并进行title的赋值处理
		PB002001ResultTitleCommand title = pb002Service.getLegalDateListByWeek(searchCommand);
		@SuppressWarnings("unchecked")
		List<PB002001ResultCommand> list = (List<PB002001ResultCommand>) pb002Service.pb002001search(searchCommand,title);
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
	 * 设备空闲一览画面上一周
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001lastWeek.do" },method = RequestMethod.POST)
	public ModelAndView pb002001lastWeek(HttpServletRequest request, PB002001SearchCommand searchCommand, RetInfo retInfo)
	{			
		String displaydate = CalendarUtil.getLastWeekByDate(searchCommand.getDisplaydate());
		searchCommand.setDisplaydate(displaydate);
		return pb002001search(request, searchCommand, null);
	}
	/**
	 * 设备空闲一览画面下一周
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001nextWeek.do" },method = RequestMethod.POST)
	public ModelAndView pb002001nextWeek(HttpServletRequest request, PB002001SearchCommand searchCommand, RetInfo retInfo)
	{					
		String displaydate = CalendarUtil.getNextWeekByDate(searchCommand.getDisplaydate());
		searchCommand.setDisplaydate(displaydate);
		return pb002001search(request, searchCommand, null);
	}
	/**
	 * 设备空闲一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001page.do" },method = RequestMethod.POST)
	public ModelAndView pb002001page(HttpServletRequest request, PB002001SearchCommand searchCommand)
	{			
		//根据显示日历，查询一周的所有日期，并进行title的赋值处理
		PB002001ResultTitleCommand title = pb002Service.getLegalDateListByWeek(searchCommand);
		@SuppressWarnings("unchecked")
		List<PB002001ResultCommand> list = (List<PB002001ResultCommand>) pb002Service.pb002001search(searchCommand, title);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		resultMap.put("title", title);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}
	/**
	 *  设备空闲一览画面月预定
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002001month.do" },method = RequestMethod.POST)
	public ModelAndView pb002001month(HttpServletRequest request, PB002001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();			
		PB002Command command = pb002Service.pb002001month(searchCommand);
		command.setPb002001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_MONTH, resultMap);	
		return mav;
	}
	/**
	 * 月预定画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pb002002back.do" },method = RequestMethod.POST)
	public ModelAndView pb001002back(HttpServletRequest request, PB002Command command)
	{			
		return pb002001search(request, command.getPb002001searchcommand(), null);
	}
}
