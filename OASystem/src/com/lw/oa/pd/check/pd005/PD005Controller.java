package com.lw.oa.pd.check.pd005;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
// @RequestMapping("/pd/pd005/")
public class PD005Controller implements ConstantUtil {
	// 初始化画面
	// private static final String PAGE_INIT = "pd/pd005/pd005001List";
	// 查询画面
	private static final String PAGE_SEARCH = "pd/pd005/pd005001List";
	// 休假申请详细画面
	private static final String PAGE_APPLY_DETAIL_A1 = "pd/pd005/pd005002A1Detail";
	// 休假取消申请详细画面
	private static final String PAGE_APPLY_DETAIL_A2 = "design";
	// 休假申请修改画面
	private static final String PAGE_APPLY_UPDATE_A1 = "pd/pd005/pd005003A1Update";
	// 休假取消申请修改画面
	private static final String PAGE_APPLY_UPDATE_A2 = "design";
	@Autowired
	private IPD005Service pd005Service;

	/**
	 * 人事归档一览画面init
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005001init.do" }, method = RequestMethod.GET)
	public ModelAndView pd005001init(HttpServletRequest request) {
		ApplySearchCommand searchCommand = new ApplySearchCommand();
		String empid = STRING_EMPTY;
		// 从session中获取当前用户id
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			SessionEntity sessionEntity = (SessionEntity) session
					.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		searchCommand.setEmpid(empid);
		searchCommand.setStatus("5");
		return pd005001search(request, searchCommand, null);
	}

	/**
	 * 人事归档一览画面search
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005001search.do" }, method = RequestMethod.POST)
	public ModelAndView pd005001search(HttpServletRequest request,
			ApplySearchCommand searchCommand, RetInfo retInfo) {
		String empid = STRING_EMPTY;
		// 从session中获取当前用户id
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			SessionEntity sessionEntity = (SessionEntity) session
					.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		searchCommand.setEmpid(empid);
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pd005Service
				.pd005001search(searchCommand);
		RetInfo searchRetInfo = MessageUtil.getMessageNoResult(list.size());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>) searchCommand);
		resultMap.put("list", list);
		resultMap.put("searchRetInfo", searchRetInfo);
		resultMap.put("retInfo", retInfo);
		ModelAndView mav = new ModelAndView(PAGE_SEARCH, resultMap);
		return mav;
	}
	/**
	 * 人事归档一览画面翻页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005001page.do" }, method = RequestMethod.POST)
	public ModelAndView pd005001page(HttpServletRequest request,
			ApplySearchCommand searchCommand) {
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) pd005Service
				.pd005001search(searchCommand);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("searchCommand", searchCommand);
		resultMap.put("page", (Pager<?>) searchCommand);
		resultMap.put("list", list);
		ModelAndView mav = new ModelAndView(PAGE_SEARCH, resultMap);
		return mav;
	}

	/**
	 * 人事归档一览画面Link
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005001view.do" }, method = RequestMethod.POST)
	public ModelAndView pd005001view(HttpServletRequest request,
			ApplySearchCommand searchCommand) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ApplyFormCommand command = pd005Service.pd005001view(searchCommand);
		command.setSearchcommand(searchCommand);
		resultMap.put("command", command);
		// 设置申请详细画面
		String page = setApplyDetailPage(searchCommand.getApplytype_result());
		ModelAndView mav = new ModelAndView(page, resultMap);
		return mav;
	}

	/**
	 * 申请详细画面返回
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005002back.do" }, method = RequestMethod.POST)
	public ModelAndView pd005002back(HttpServletRequest request,
			ApplyFormCommand command) {
		return pd005001search(request, command.getSearchcommand(), null);
	}

	/**
	 * 人事归档一览画面归档
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005001file.do" }, method = RequestMethod.POST)
	public ModelAndView pd005001file(HttpServletRequest request,
			ApplySearchCommand searchCommand) {
		int cnt = pd005Service.pd005001file(searchCommand, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pd005001search(request, searchCommand, retInfo);
	}
	/**
	 * 申请审核画面返回
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pd005003back.do" }, method = RequestMethod.POST)
	public ModelAndView pd005003back(HttpServletRequest request,
			ApplyFormCommand command) {
		return pd005001search(request, command.getSearchcommand(), null);
	}

	public String setApplyDetailPage(String type) {
		String page = StringUtils.EMPTY;
		if (APPLY_A1.equals(type)) {
			page = PAGE_APPLY_DETAIL_A1;
		} else if (APPLY_A2.equals(type)) {
			page = PAGE_APPLY_DETAIL_A2;
		} else {
			page = PAGE_APPLY_DETAIL_A2;
		}
		return page;
	}

	public String setApplyUpdatePage(String type) {
		String page = StringUtils.EMPTY;
		if (APPLY_A1.equals(type)) {
			page = PAGE_APPLY_UPDATE_A1;
		} else if (APPLY_A2.equals(type)) {
			page = PAGE_APPLY_UPDATE_A2;
		} else {
			page = PAGE_APPLY_UPDATE_A2;
		}
		return page;
	}
}
