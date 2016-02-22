package com.lw.oa.pc.apply.pc001;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DateUtil;
/**
 * *@author yuliang
 */
@Controller
//@RequestMapping("/pc/pc001/")
public class PC001Controller implements ConstantUtil{	
	
	//初始化画面	
	private static final String  PAGE_INIT = "pc/pc001/pc001001List";	
	//休假申请画面	
	private static final String  PAGE_APPLY_A1 = "pc/pc001/pc001002A1";
	//休假取消申请画面	
	private static final String  PAGE_APPLY_A2 = "pc/pc001/pc001002A2";	
	@Autowired
	private IPC001Service pc001Service;
	/**
	 * 申请单填写init画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc001001init.do" },method = RequestMethod.GET)
	public ModelAndView pc001001init(HttpServletRequest request)
	{	
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PC001001SearchCommand searchCommand = new PC001001SearchCommand();
		searchCommand.setApplytype("A1");
		resultMap.put("searchCommand", searchCommand);
		ModelAndView mav = new ModelAndView( PAGE_INIT, resultMap);	
		return mav;
	}
	/**
	 * 申请单填写申请画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc001001apply.do" },method = RequestMethod.POST)
	public ModelAndView pc001001apply(HttpServletRequest request, PC001001SearchCommand searchCommand)
	{			
		//初始化时间
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMD);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PC001Command command = pc001Service.pc001001apply(searchCommand);
		command.setCurrentdate(sysdate);
		resultMap.put("command", command);
		//设置申请画面
		String page = setApplypage(searchCommand.getApplytype());
		ModelAndView mav = new ModelAndView( page, resultMap);				
		return mav;
	}
	/**
	 * 申请单申请画面保存
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc001002save.do" },method = RequestMethod.POST)
	public ModelAndView pc001002save(HttpServletRequest request, PC001Command command)
	{				
		pc001Service.pc001002save(command, request);		
		return pc001002back(request, command);
	}
	/**
	 * 员工登录返回
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "pc001002back.do" },method = RequestMethod.POST)
	public ModelAndView pc001002back(HttpServletRequest request, PC001Command command)
	{		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PC001001SearchCommand searchCommand = command.getPc001001searchcommand();
		resultMap.put("searchCommand", searchCommand);
		ModelAndView mav = new ModelAndView( PAGE_INIT, resultMap);	
		return mav;
	}
	
	public String setApplypage( String type){
		String page = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			page = PAGE_APPLY_A1;
		}else if(APPLY_A2.equals(type)){
			page = PAGE_APPLY_A2;
		}else{
			page = PAGE_APPLY_A2;
		}
		return page;
	}
}
