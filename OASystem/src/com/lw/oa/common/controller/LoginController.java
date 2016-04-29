package com.lw.oa.common.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.command.RetInfo;
import com.lw.oa.common.service.ICommonService;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.MessageUtil;
/**
 * *@author yuliang
 */
@Controller
@RequestMapping("/common/login/")
public class LoginController implements ConstantUtil{
	//登录画面	
	private static final String  PAGE_INIT = "login";	
	//主画面	
	private static final String  PAGE_MAIN = "main";	
	//top画面	
	private static final String  PAGE_TOP = "top";	
	//用户名
	private static final String  LOGIN_USERNAME = "username";	
	//复选框
	private static final String  LOGIN_CHECKED = "checked";	
	@Autowired
	private ICommonService commonService;
	/**
	 * 初始化登录画面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "init.do" },method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response)
	{	
		Cookie[] cookies = request.getCookies();
		String username = STRING_EMPTY;
		String checked = STRING_EMPTY;
		if(cookies != null&& cookies.length > 0){
			for(Cookie cookie:cookies){
				if(LOGIN_USERNAME.equals(cookie.getName())){
					try {
						username = URLDecoder.decode(cookie.getValue(), CHARATER_ENCODING);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(LOGIN_CHECKED.equals(cookie.getName())){
					checked = cookie.getValue();
				}
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("username", username);
		resultMap.put("checked", checked);
		ModelAndView mav = new ModelAndView(PAGE_INIT,resultMap);	
		return mav;
	}
	/**
	 * 登录画面登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "login.do" },method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
	{	
		ModelAndView mav = null;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null||password==null){
			mav = new ModelAndView( PAGE_INIT, resultMap);
			return mav;
		}
		String orgcdid = request.getParameter("orgcdid");
		String save = request.getParameter("save");				
		ResultCommand command = commonService.checkUserAndPwd(username, password, null);
		//用户名或者密码错误
		if(command == null){
			RetInfo retInfo = MessageUtil.getMessageErrorUserPwd();
			resultMap.put("retInfo", retInfo);
			mav = new ModelAndView( PAGE_INIT, resultMap);
			return mav;
		}
		//用户所在机构验证
		ResultCommand command1 = commonService.checkUserAndPwd(username, password, orgcdid);
		if(command1 == null){
			RetInfo retInfo = MessageUtil.setMessageError("ERROR_COMM_0040");
			resultMap.put("retInfo", retInfo);
			mav = new ModelAndView( PAGE_INIT, resultMap);
			return mav;
		}
		//是否将cookie保存到客户端硬盘上
		saveCookie(username, save, response);
		HttpSession session = request.getSession();
		SessionEntity sessionEntity = new SessionEntity();
		sessionEntity.setOrgcdid(orgcdid);
		sessionEntity.setEmpid(command.getEmpid());
		sessionEntity.setEmpname(command.getEmpname());
		//保存session信息
		session.setAttribute("user", sessionEntity);			
		mav = new ModelAndView(PAGE_MAIN,resultMap);	
		return mav;
	}
	/**
	 * top画面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "top.do" }, method = RequestMethod.GET)
	public ModelAndView top(HttpServletRequest request,
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
		ModelAndView mav = new ModelAndView(PAGE_TOP, resultMap);
		return mav;
	}
	private void saveCookie( String username, String save, HttpServletResponse response){
		Cookie usernameCookie = null;
		Cookie checkedCookie = null;
		//创建保存用户名的cookie
		if(username != null && !STRING_EMPTY.equals(username.trim())){
			try {
				usernameCookie = new Cookie("username", URLEncoder.encode(username, CHARATER_ENCODING));
				usernameCookie.setPath("/");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		//复选框选中，在客户端浏览器保存cookie 7天
		if(save != null){
			if(usernameCookie != null){
				usernameCookie.setMaxAge(7*24*60*60);
			}
			checkedCookie = new Cookie("checked", "checked");
			checkedCookie.setMaxAge(7*24*60*60);
			checkedCookie.setPath("/");
		}else{
			if(usernameCookie != null){
				usernameCookie.setMaxAge(0);
			}		
			checkedCookie = new Cookie("checked", "");
			checkedCookie.setMaxAge(0);
			checkedCookie.setPath("/");
		}
		//加入cookie到response
		if(usernameCookie != null){
			response.addCookie(usernameCookie);
		}	
		if(checkedCookie != null){
			response.addCookie(checkedCookie);
		}
	}
}
