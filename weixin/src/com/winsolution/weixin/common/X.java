package com.winsolution.weixin.common;

import java.awt.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import net.sf.json.JSONSerializer;
//import com.fft.domain.User;

public class X {

//	public static boolean isLogin(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User)session .getAttribute("user");
//		return user != null;
//	}
//	
//	public static User getUser(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User)session .getAttribute("user");
//		return user;
//	}
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public static ModelAndView withSessionCheck(HttpServletRequest request,String MaV,Map resultMap) {
//		String rtnMav = (MaV==null)?BizContextNames.MODELANDVIEW_LOGIN:MaV;
//		if (!isLogin(request)) {
//			rtnMav = BizContextNames.MODELANDVIEW_LOGIN;
//		}
//		return new ModelAndView(rtnMav,resultMap);
//	}
//	
//	public static ModelAndView withSessionCheck(HttpServletRequest request,String MaV) {
//		return withSessionCheck(request,MaV,null);
//	}
	
	public static boolean isEmpty(Object obj) {
		return null == obj || "".equals(obj.toString().trim());
	}
	
	public static String getParameter(HttpServletRequest request,String paramName) {
		String val = request.getParameter(paramName);
		if (val != null) {
			return val;
		}else {
			return "";
		}
	}
	
	public static int trytoInt(Object obj) {
		if (obj!=null) {
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}
	
	public static String transLineToHTMLBr(String javaString){
		if (isEmpty(javaString)) {
			return null;
		}else {
			String rtnStr = javaString.replaceAll("\\n", "<br />").replaceAll("\\r", "").replaceAll("\"", "\\\\\"");
			return rtnStr;
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	public static boolean clearSuccessMsg(Map map) {
		if (map.containsKey(BizContextNames.SUC_MESSAGE)) {
			map.remove(BizContextNames.SUC_MESSAGE);
			return true;
		}
		return false;
	}
	
	/**
	 * 将逗号分割符字符串转成int数组
	 * @param str
	 * @return
	 */
	public static int[] arrayFromCommaStr(String str){
		if (str==null) {
			return new int[0];
		}else {
			String[] arr = str.split(","); 
			int[] result = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				result[i] = Integer.parseInt(arr[i]);
			}
			return result;
		}
	}
	
	/**
	 * 将数组拼接成逗号分割字符串
	 * @param arr
	 * @return
	 */
	public static String arrayToCommaStr(int[] arr){
		String rtn = "";
		if (arr!=null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(",");
			}
			if (sb.length()>1 && sb.lastIndexOf(",")==sb.length()-1) {
				sb.deleteCharAt(sb.length()-1);
			}
			rtn = sb.toString();
		}
		return rtn;
	}
	
	public static String toJsonStr(List lst) {
		return JSONSerializer.toJSON(lst).toString();
	}
	
	public static int getPage(HttpServletRequest request) {
		return request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
	}
}
