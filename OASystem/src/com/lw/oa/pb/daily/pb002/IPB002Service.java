package com.lw.oa.pb.daily.pb002;

import java.util.List;
/**
 **@author yuliang
 */
public interface IPB002Service {
	public List<?> pb002001search(PB002001SearchCommand searchCommand, PB002001ResultTitleCommand title);
	public PB002001ResultTitleCommand getLegalDateListByWeek( PB002001SearchCommand searchCommand);	
	public PB002Command pb002001month(PB002001SearchCommand searchCommand);
}
