package com.lw.oa.pa.master.pa006;

import java.util.HashMap;
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
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.MessageUtil;

/**
 * *@author yuliang
 */
@Controller
// @RequestMapping("/pa/pa006/")
public class PA006Controller implements ConstantUtil {
	// 密码修改画面
	private static final String PAGE_UPDATE = "pa/pa006/pa006001Update";
	@Autowired
	private IPA006Service pa006Service;

	/**
	 * 密码修改画面init
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa006001init.do" }, method = RequestMethod.GET)
	public ModelAndView pa006001init(HttpServletRequest request, RetInfo retInfo) {
		String empid = STRING_EMPTY;
		//从session中获取当前用户id
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		PA006Command command = pa006Service.pa006001view(empid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("command", command);
		resultMap.put("retInfo", retInfo);
		ModelAndView mav = new ModelAndView(PAGE_UPDATE, resultMap);
		return mav;
	}
	/**
	 * 密码修改画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pa006001save.do" },method = RequestMethod.POST)
	public ModelAndView pa006001save(HttpServletRequest request, PA006Command command)
	{				
		int cnt = pa006Service.pa006001save(command, request);
		RetInfo retInfo = MessageUtil.getMessageExclusive(cnt);
		return pa006001init(request, retInfo);
	}
}
