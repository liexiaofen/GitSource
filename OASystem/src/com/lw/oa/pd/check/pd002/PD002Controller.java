package com.lw.oa.pd.check.pd002;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplyResultCommand;
import com.lw.oa.common.command.ApplySearchCommand;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.MessageUtil;
import com.lw.oa.mybatis.interceptor.Pager;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pd/pd002/")
public class PD002Controller implements ConstantUtil{		
	//初始化画面	
	//private static final String  PAGE_INIT = "pd/pd002/pd002001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pd/pd002/pd002001List";
	//休假申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A1 = "pd/pd002/pd002002A1Detail";
	//休假取消申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A2 = "design";
	//休假申请修改画面	
	private static final String  PAGE_APPLY_UPDATE_A1 = "pd/pd002/pd002003A1Update";
	//休假取消申请修改画面
	private static final String  PAGE_APPLY_UPDATE_A2 = "design";	
	@Autowired
	private IPD002Service pd002Service;
	/**
	 * 人事审核一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002001init.do" },method = RequestMethod.GET)
	public ModelAndView pd002001init(HttpServletRequest request)
	{					
		ApplySearchCommand searchCommand = new ApplySearchCommand();
		String empid = STRING_EMPTY;
		//从session中获取当前用户id
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		searchCommand.setEmpid(empid);
		searchCommand.setStatus("2");
		return pd002001search(request, searchCommand, null);
	}
	/**
	 * 人事审核一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002001search.do" },method = RequestMethod.POST)
	public ModelAndView pd002001search(HttpServletRequest request, ApplySearchCommand searchCommand, RetInfo retInfo)
	{					
		String empid = STRING_EMPTY;
		//从session中获取当前用户id
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		searchCommand.setEmpid(empid);
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pd002Service.pd002001search(searchCommand);
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
	 * 人事审核一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002001page.do" },method = RequestMethod.POST)
	public ModelAndView pd002001page(HttpServletRequest request, ApplySearchCommand searchCommand)
	{					
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pd002Service.pd002001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}	
	/**
	 * 人事审核一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002001view.do" },method = RequestMethod.POST)
	public ModelAndView pd002001view(HttpServletRequest request, ApplySearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ApplyFormCommand command = pd002Service.pd002001view(searchCommand);
		command.setSearchcommand(searchCommand);
		resultMap.put("command", command);		
		//设置申请详细画面
		String page = setApplyDetailPage(searchCommand.getApplytype_result());
		ModelAndView mav = new ModelAndView( page, resultMap);				
		return mav;
	}
	/**
	 * 申请详细画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002002back.do" },method = RequestMethod.POST)
	public ModelAndView pd002002back(HttpServletRequest request, ApplyFormCommand command)
	{			
		return pd002001search(request, command.getSearchcommand(), null);
	}
	/**
	 * 人事审核一览画面审核
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002001check.do" },method = RequestMethod.POST)
	public ModelAndView pd002001check(HttpServletRequest request, ApplySearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ApplyFormCommand command = pd002Service.pd002001view(searchCommand);
		command.setSearchcommand(searchCommand);
		resultMap.put("command", command);		
		//设置申请修改画面
		String page = setApplyUpdatePage(searchCommand.getApplytype_result());
		ModelAndView mav = new ModelAndView( page, resultMap);				
		return mav;
	}
	/**
	 * 申请审核画面审核
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002003agree.do" },method = RequestMethod.POST)
	public ModelAndView pd002003agree(HttpServletRequest request, ApplyFormCommand command)
	{				
		// 设置状态
		command.setStatus("3");
		// 设置操作代码
		command.setOperationcd("A005");
		int cnt = pd002Service.pd002003update(command, request);	
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pd002001search(request, command.getSearchcommand(), retInfo);
	}
	/**
	 * 申请审核画面驳回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002003reject.do" },method = RequestMethod.POST)
	public ModelAndView pd002003reject(HttpServletRequest request, ApplyFormCommand command)
	{				
		// 设置状态
		command.setStatus("0");
		// 设置操作代码
		command.setOperationcd("A006");
		int cnt = pd002Service.pd002003update(command, request);	
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pd002001search(request, command.getSearchcommand(), retInfo);
	}
	/**
	 * 申请审核画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd002003back.do" },method = RequestMethod.POST)
	public ModelAndView pd002003back(HttpServletRequest request, ApplyFormCommand command)
	{			
		return pd002001search(request, command.getSearchcommand(), null);
	}	
	public String setApplyDetailPage( String type){
		String page = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			page = PAGE_APPLY_DETAIL_A1;
		}else if(APPLY_A2.equals(type)){
			page = PAGE_APPLY_DETAIL_A2;
		}else{
			page = PAGE_APPLY_DETAIL_A2;
		}
		return page;
	}
	public String setApplyUpdatePage( String type){
		String page = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			page = PAGE_APPLY_UPDATE_A1;
		}else if(APPLY_A2.equals(type)){
			page = PAGE_APPLY_UPDATE_A2;
		}else{
			page = PAGE_APPLY_UPDATE_A2;
		}
		return page;
	}
}
