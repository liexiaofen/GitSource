package com.lw.oa.pb.daily.pb002;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.util.ConstantUtil;
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
		for(int i=0; i<list.size();i++){
			if(i == 0){//第一天
				title.setOne(list.get(i).getLegaldate());
				title.setStatusofone(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekofone(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekofone(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekofone(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekofone(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekofone(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekofone(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekofone(SATURDAY);
				}
			}else if(i == 1){//第二天
				title.setTwo(list.get(i).getLegaldate());
				title.setStatusoftwo(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekoftwo(SATURDAY);
				}
			}else if(i == 2){//第三天
				title.setThree(list.get(i).getLegaldate());
				title.setStatusofthree(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekofthree(SATURDAY);
				}
			}else if(i == 3){//第四天
				title.setFour(list.get(i).getLegaldate());
				title.setStatusoffour(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekoffour(SATURDAY);
				}
			}else if(i == 4){//第五天
				title.setFive(list.get(i).getLegaldate());
				title.setStatusoffive(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekoffive(SATURDAY);
				}
			}else if(i == 5){//第六天
				title.setSix(list.get(i).getLegaldate());
				title.setStatusofsix(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekofsix(SATURDAY);
				}
			}else if(i == 6){//第七天
				title.setSeven(list.get(i).getLegaldate());
				title.setStatusofseven(list.get(i).getStatus());
				if(WEEK_ZERO.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(SUNDAY);
				}else if(WEEK_ONE.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(MONDAY);
				}else if(WEEK_TWO.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(TUESDAY);
				}else if(WEEK_THREE.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(WEDNESDAY);
				}else if(WEEK_FOUR.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(THURSDAY);
				}else if(WEEK_FIVE.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(FRIDAY);
				}else if(WEEK_SIX.equals(list.get(i).getDayofweek())){
					title.setWeekofseven(SATURDAY);
				}
			}			
		}
		return title;	
	}
	
	@Override
	public List<?> pb002001search(PB002001SearchCommand searchCommand, PB002001ResultTitleCommand title) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<PB002001ResultCommand> list = (List<PB002001ResultCommand>) mybatisDAOImpl
				.queryByObj("pb.pb002.pb002001searchListByPage", searchCommand);		
		for(PB002001ResultCommand entity:list){
			String dailydeviceid = entity.getDailydeviceid();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("dailydeviceid", dailydeviceid);
			//第一天
			if(!StringUtils.isEmpty(title.getOne())){				
				map.put("date", title.getOne());
				@SuppressWarnings("unchecked")
				List<PB002Command> one = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setOne(one);
			}
			//第二天
			if(!StringUtils.isEmpty(title.getTwo())){
				map.put("date", title.getTwo());
				@SuppressWarnings("unchecked")
				List<PB002Command> two = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setTwo(two);
			}
			//第三天
			if(!StringUtils.isEmpty(title.getThree())){
				map.put("date", title.getThree());
				@SuppressWarnings("unchecked")
				List<PB002Command> three = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setThree(three);
			}
			//第四天
			if(!StringUtils.isEmpty(title.getFour())){
				map.put("date", title.getFour());
				@SuppressWarnings("unchecked")
				List<PB002Command> four = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setFour(four);
			}
			//第五天
			if(!StringUtils.isEmpty(title.getFive())){
				map.put("date", title.getFive());
				@SuppressWarnings("unchecked")
				List<PB002Command> five = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setFive(five);
			}
			//第六天
			if(!StringUtils.isEmpty(title.getSix())){
				map.put("date", title.getSix());
				@SuppressWarnings("unchecked")
				List<PB002Command> six = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setSix(six);
			}
			//第七天
			if(!StringUtils.isEmpty(title.getSeven())){
				map.put("date", title.getSeven());
				@SuppressWarnings("unchecked")
				List<PB002Command> seven = (List<PB002Command>) mybatisDAOImpl.queryByObj("pb.pb002.pb002001searchDailyPlanListByIdDate", map);
				entity.setSeven(seven);
			}
		}
		return list;
	}		
	
}
