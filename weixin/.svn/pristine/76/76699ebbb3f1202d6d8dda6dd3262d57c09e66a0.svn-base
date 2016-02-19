package com.winsolution.weixin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.winsolution.weixin.common.BizContextNames;
import com.winsolution.weixin.common.DatetimeUtils;
import com.winsolution.weixin.common.X;
import com.winsolution.weixin.entity.TempSignEntity;
import com.winsolution.weixin.service.ITempSignService;

@Controller
public class TempSignController {
	@Autowired
	private ITempSignService tempSignService;

	@RequestMapping(value = { "/sign.do" })
	public ModelAndView getTempSign(HttpServletRequest request) {
		// 查询参数
		TempSignEntity tempSignEntity = prepareCommand(request);
		// 页面
		ModelAndView mav = new ModelAndView(BizContextNames.TEMPSIGN_PAGE, null);
		// 设置当前页
		int curPage = X.getPage(request);
		tempSignEntity.setPageSize(10);
		tempSignEntity.setCurPage(curPage);

		// 数据
		Map<String, Object> resultMap = tempSignService.getTempSign(tempSignEntity);
		resultMap.put(BizContextNames.PAGER, tempSignEntity.getPagerStr());
		return mav.addAllObjects(resultMap);
	}

	// 查询参数
	private TempSignEntity prepareCommand(HttpServletRequest request) {
		TempSignEntity tempSignEntity = new TempSignEntity();
		String signtype = request.getParameter("gender");
		String startdate = request.getParameter("txtStartDate");
		String enddate = request.getParameter("txtEndDate");

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

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		if (startdate != null && startdate.length() > 0) {

			try {
				Date startdt = sdf1.parse(startdate);
				startdt = sdf2.parse(sdf2.format(startdt));
				tempSignEntity.setStartdate(DatetimeUtils.dateToSQLDate(startdt));
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		if (enddate != null && enddate.length() > 0) {
			try {
				Date enddt = sdf1.parse(enddate);
				enddt = sdf2.parse(sdf2.format(enddt));
				tempSignEntity.setEnddate(DatetimeUtils.dateToSQLDate(enddt));
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return tempSignEntity;
	}
}
