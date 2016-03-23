package com.lw.oa.pc.apply.pc002;

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
//@RequestMapping("/pc/pc002/")
public class PC002Controller implements ConstantUtil{		
	//初始化画面	
	//private static final String  PAGE_INIT = "pc/pc002/pc002001List";
	//查询画面	
	private static final String  PAGE_SEARCH = "pc/pc002/pc002001List";
	//休假申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A1 = "pc/pc002/pc002002A1Detail";
	//休假取消申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A2 = "pc/pc002/pc002002A2Detail";
	//加班申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A3 = "pc/pc002/pc002002A3Detail";
	//出差申请详细画面	
	private static final String  PAGE_APPLY_DETAIL_A4 = "pc/pc002/pc002002A4Detail";
	//休假申请修改画面	
	private static final String  PAGE_APPLY_UPDATE_A1 = "pc/pc002/pc002003A1Update";
	//休假取消申请修改画面
	private static final String  PAGE_APPLY_UPDATE_A2 = "pc/pc002/pc002003A2Update";
	//加班申请修改画面	
	private static final String  PAGE_APPLY_UPDATE_A31 = "pc/pc002/pc002003A3Update1";
	//加班确认申请修改画面	
	private static final String  PAGE_APPLY_UPDATE_A32 = "pc/pc002/pc002003A3Update2";
	//出差申请修改画面
	private static final String  PAGE_APPLY_UPDATE_A4 = "pc/pc002/pc002003A4Update";
	@Autowired
	private IPC002Service pc002Service;
	/**
	 * 申请管理一览画面init
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002001init.do" },method = RequestMethod.GET)
	public ModelAndView pc002001init(HttpServletRequest request)
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
		return pc002001search(request, searchCommand, null);
	}
	/**
	 * 申请管理一览画面search
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002001search.do" },method = RequestMethod.POST)
	public ModelAndView pc002001search(HttpServletRequest request, ApplySearchCommand searchCommand, RetInfo retInfo)
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
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pc002Service.pc002001search(searchCommand);
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
	 * 申请管理一览画面翻页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002001page.do" },method = RequestMethod.POST)
	public ModelAndView pc002001page(HttpServletRequest request, ApplySearchCommand searchCommand)
	{			
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pc002Service.pc002001search(searchCommand);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>)searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView( PAGE_SEARCH, resultMap);	
		return mav;
	}	
	/**
	 * 申请管理一览画面Link
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002001view.do" },method = RequestMethod.POST)
	public ModelAndView pc002001view(HttpServletRequest request, ApplySearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ApplyFormCommand command = pc002Service.pc002001view(searchCommand);
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
	@RequestMapping(value = { "pc002002back.do" },method = RequestMethod.POST)
	public ModelAndView pc002002back(HttpServletRequest request, ApplyFormCommand command)
	{			
		return pc002001search(request, command.getSearchcommand(), null);
	}
	/**
	 * 申请管理一览画面编辑
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002001edit.do" },method = RequestMethod.POST)
	public ModelAndView pc002001edit(HttpServletRequest request, ApplySearchCommand searchCommand)
	{					
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ApplyFormCommand command = pc002Service.pc002001view(searchCommand);
		command.setSearchcommand(searchCommand);
		resultMap.put("command", command);		
		//设置申请修改画面
		String page = setApplyUpdatePage( searchCommand.getApplytype_result(), command);
		ModelAndView mav = new ModelAndView( page, resultMap);				
		return mav;
	}
	/**
	 * 申请编辑画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002003update.do" },method = RequestMethod.POST)
	public ModelAndView pc002003update(HttpServletRequest request, ApplyFormCommand command)
	{			
		// 设置状态
		command.setStatus("1");
		int cnt = pc002Service.pc002003update(command, request);	
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pc002001search(request, command.getSearchcommand(), retInfo);
	}	
	/**
	 * 申请编辑画面删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002003delete.do" },method = RequestMethod.POST)
	public ModelAndView pc002003delete(HttpServletRequest request, ApplyFormCommand command)
	{				
		// 设置状态
		command.setStatus("9");
		// 设置操作代码
		command.setOperationcd("A999");
		int cnt = pc002Service.pc002003delete(command, request);	
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pc002001search(request, command.getSearchcommand(), retInfo);
	}
	/**
	 * 申请编辑画面返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc002003back.do" },method = RequestMethod.POST)
	public ModelAndView pc002003back(HttpServletRequest request, ApplyFormCommand command)
	{			
		return pc002001search(request, command.getSearchcommand(), null);
	}	
	public String setApplyDetailPage( String type){
		String page = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			page = PAGE_APPLY_DETAIL_A1;
		}else if(APPLY_A2.equals(type)){
			page = PAGE_APPLY_DETAIL_A2;
		}else if(APPLY_A3.equals(type)){
			page = PAGE_APPLY_DETAIL_A3;
		}else if(APPLY_A4.equals(type)){
			page = PAGE_APPLY_DETAIL_A4;
		}
		return page;
	}
	public String setApplyUpdatePage( String type, ApplyFormCommand command){
		String page = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			page = PAGE_APPLY_UPDATE_A1;
		}else if(APPLY_A2.equals(type)){
			page = PAGE_APPLY_UPDATE_A2;
		}else if(APPLY_A3.equals(type) && "1".equals(command.getChecklevel())){
			page = PAGE_APPLY_UPDATE_A31;
		}else if(APPLY_A3.equals(type) && "2".equals(command.getChecklevel())){
			page = PAGE_APPLY_UPDATE_A32;
		}else if(APPLY_A4.equals(type)){
			page = PAGE_APPLY_UPDATE_A4;
		}
		return page;
	}
}
