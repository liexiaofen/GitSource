package com.lw.oa.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.service.ICommonService;
import com.lw.oa.common.util.ConstantUtil;
/**
 * *@author yuliang
 */
@Controller
public class CommonController implements ConstantUtil{		
	// 申请单下载
	private static final String  PAGE_APPLY_DOWNLOAD = "download/Apply_Download";
	@Autowired
	private ICommonService commonService;
	/**
	 * 申请单下载
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "applyFormDownload.do" },method = RequestMethod.POST)
	public ModelAndView applyFormDownload(HttpServletRequest request)
	{			
		String applyid = request.getParameter("applyid");	
		String exclusivefg = request.getParameter("exclusivefg");
		String applytype = request.getParameter("applytype");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ApplyFormCommand command = commonService.expandApplyForm(applyid, exclusivefg, applytype);
		resultMap.put("command", command);	
		ModelAndView mav = new ModelAndView( PAGE_APPLY_DOWNLOAD, resultMap);				
		return mav;
	}
	
}
