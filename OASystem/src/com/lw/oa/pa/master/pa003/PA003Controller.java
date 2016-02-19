package com.lw.oa.pa.master.pa003;

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
//@RequestMapping("/pa/pa003/")
public class PA003Controller implements ConstantUtil{	
	
	//初始化画面	
	//private static final String  PAGE_INIT = "pa/pa003/pa003001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pa/pa003/pa003001List";
	//修改画面	
	private static final String  PAGE_UPDATE = "pa/pa003/pa003002Update";
	//登录画面	
	private static final String  PAGE_INSERT = "pa/pa003/pa003003Insert";
	
	@Autowired
	private IPA003Service pa003Service;
	/**
	 * 设备信息一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003001init.do" },method = RequestMethod.GET)
	public ModelAndView pa003001init(HttpServletRequest request)
	{						
		//初始化时间
		String legalyear = DateUtil.getSystemTime(DATE_FORMAT_YYYY);		
		PA003001SearchCommand searchCommand = new PA003001SearchCommand();
		searchCommand.setLegalyear(legalyear);
		return pa003001search(request, searchCommand, null);
	}
	/**
	 * 设备信息一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003001search.do" },method = RequestMethod.POST)
	public ModelAndView pa003001search(HttpServletRequest request, PA003001SearchCommand searchCommand, RetInfo retInfo)
	{					
		@SuppressWarnings("unchecked")
		List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) pa003Service.pa003001search(searchCommand);
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
	@RequestMapping(value = { "pa003001page.do" },method = RequestMethod.POST)
	public ModelAndView pa003001page(HttpServletRequest request, PA003001SearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<PA003001ResultCommand> list = (List<PA003001ResultCommand>) pa003Service.pa003001search(searchCommand);
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
	@RequestMapping(value = { "pa003001insert.do" },method = RequestMethod.POST)
	public ModelAndView pa003001insert(HttpServletRequest request, PA003001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		PA003Command command = new PA003Command();
		command.setPa003001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_INSERT, resultMap);				
		return mav;
	}
	/**
	 * 设备信息一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003001view.do" },method = RequestMethod.POST)
	public ModelAndView pa003001view(HttpServletRequest request, PA003001SearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PA003Command command = pa003Service.pa003001view(searchCommand);
		command.setPa003001searchcommand(searchCommand);
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView( PAGE_UPDATE, resultMap);				
		return mav;
	}
	/**
	 * 设备信息登录画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003003save.do" },method = RequestMethod.POST)
	public ModelAndView pa003003save(HttpServletRequest request, PA003Command command)
	{				
		pa003Service.pa003003save(command, request);		
		return pa003001search(request, command.getPa003001searchcommand(), null);
	}	
	/**
	 * 设备信息登录画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003003back.do" },method = RequestMethod.POST)
	public ModelAndView pa003003back(HttpServletRequest request, PA003Command command)
	{			
		return pa003001search(request, command.getPa003001searchcommand(), null);
	}
	/**
	 * 设备信息编辑画面修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003002update.do" },method = RequestMethod.POST)
	public ModelAndView pa003002update(HttpServletRequest request, PA003Command command)
	{				
		int cnt = pa003Service.pa003002update(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa003001search(request, command.getPa003001searchcommand(), retInfo);
	}
	/**
	 * 设备信息编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa003002back.do" },method = RequestMethod.POST)
	public ModelAndView pa003002back(HttpServletRequest request, PA003Command command)
	{			
		return pa003001search(request, command.getPa003001searchcommand(), null);
	}
}
