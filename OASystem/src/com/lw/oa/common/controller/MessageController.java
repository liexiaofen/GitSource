package com.lw.oa.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.service.ICommonService;
import com.lw.oa.common.util.ConstantUtil;

/**
 * *@author yuliang
 */
@Controller
@RequestMapping("/common/message/")
public class MessageController implements ConstantUtil {
	// 消息
	private static final String PAGE_MESSAGE = "message";
	@Autowired
	private ICommonService commonService;

	/**
	 * 初始化消息画面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "init.do" }, method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request,
			HttpServletResponse response) {
		String empid = STRING_EMPTY;
		//从session中获取当前用户id
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		ApplyFormCommand command = commonService.getMessageCount(empid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("command", command);
		ModelAndView mav = new ModelAndView(PAGE_MESSAGE, resultMap);
		return mav;
	}
}
