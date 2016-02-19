package com.winsolution.weixin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winsolution.weixin.common.BizContextNames;
import com.winsolution.weixin.common.DatetimeUtils;
import com.winsolution.weixin.entity.TempSignEntity;
import com.winsolution.weixin.service.ITempSignService;

@Controller
public class MapController {
	@Autowired
	private ITempSignService tempSignService;
	
	@RequestMapping(value={"/map.html"})
	public ModelAndView empOnMap(HttpServletRequest request){
		try {
			Resource resource = new ClassPathResource("/test.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			System.out.println("======================="+props.getProperty("d"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.println("empOnMap!");
		// 查询参数
		TempSignEntity tempSignEntity = prepareCommand(request);
		// 页面
		ModelAndView mav = new ModelAndView(BizContextNames.MAP_PAGE, null);
		// 数据
		Map<String, Object> resultMap = tempSignService.getMap(tempSignEntity);
		resultMap.put("startDate", tempSignEntity.getStartdate());
		return mav.addAllObjects(resultMap);
	}
	
	
	// 查询参数
	private TempSignEntity prepareCommand(HttpServletRequest request) {
		TempSignEntity tempSignEntity = new TempSignEntity();
		String signtype = request.getParameter("gender");
		String startdate = request.getParameter("txtStartDate");

		try{
			if (signtype != null && signtype.length() > 0) {
				if ("radsignin".equals(signtype)) {
					tempSignEntity.setSigntype("1");
				} else if("radsignout".equals(signtype)){
					tempSignEntity.setSigntype("2");
				}
				else {
					tempSignEntity.setSigntype(null);
				}
			}
	
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			if (startdate != null && startdate.length() > 0) {
				tempSignEntity.setStartdate(DatetimeUtils.dateToSQLDate(sdf2.parse(startdate)));
			}else
			{
				tempSignEntity.setStartdate(DatetimeUtils.dateToSQLDate(Calendar.getInstance().getTime())); 
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tempSignEntity;
	}
}
