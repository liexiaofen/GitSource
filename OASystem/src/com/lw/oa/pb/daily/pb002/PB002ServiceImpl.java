package com.lw.oa.pb.daily.pb002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.NationLegalday;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.pa.master.pa003.PA003001ResultCommand;
/**
 ** @author yuliang
 */
@Service("pb002Service")
public class PB002ServiceImpl implements IPB002Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;		
	
	public PB002ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public PB002001ResultTitleCommand getLegalDateListByWeek( PB002001SearchCommand searchCommand){
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA003001ResultCommand> list = (List<PA003001ResultCommand>)mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchWeekListByDisplayDT", searchCommand);
		PB002001ResultTitleCommand title = new PB002001ResultTitleCommand();
		List<NationLegalday> listweek = new ArrayList<NationLegalday>();
		for(int i=0; i<list.size();i++){
			NationLegalday entity = new NationLegalday();
			entity.setLegaldate(DateUtil.parseDate(list.get(i).getLegaldate(), DATE_FORMAT_YMD));
			entity.setDayofweek(list.get(i).getDayofweek());
			entity.setStatus(list.get(i).getStatus());
			listweek.add(entity);
		}
		title.setList(listweek);
		return title;	
	}
	
	@Override
	public List<?> pb002001search(PB002001SearchCommand searchCommand, PB002001ResultTitleCommand title) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<PB002001ResultCommand> list = (List<PB002001ResultCommand>) mybatisDAOImpl
				.queryByObj("pb.pb002.pb002001searchListByPage", searchCommand);		
		for(int i=0; i<list.size(); i++){
			PB002001ResultCommand entity = list.get(i);
			String dailydeviceid = entity.getDailydeviceid();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("dailydeviceid", dailydeviceid);
			int j = 0;
			//第一天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> one = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setOne(one);
			}
			j++;
			//第二天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> two = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setTwo(two);
			}
			j++;
			//第三天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> three = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setThree(three);
			}
			j++;
			//第四天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> four = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setFour(four);
			}
			j++;
			//第五天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> five = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setFive(five);
			}
			j++;
			//第六天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> six = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setSix(six);
			}
			j++;
			//第七天
			if(!StringUtils.isEmpty(DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD))){				
				map.put("date", DateUtil.formatDate( title.list.get(j).getLegaldate(), DATE_FORMAT_YMD));
				@SuppressWarnings("unchecked")
				List<PB002Command> seven = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setSeven(seven);
			}
		}
		return list;
	}		
	
}
