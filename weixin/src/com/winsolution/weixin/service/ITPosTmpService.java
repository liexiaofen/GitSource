package com.winsolution.weixin.service;

import com.winsolution.weixin.entity.TPostmpEntity;

public interface ITPosTmpService {
	public int insertTPosTmp(TPostmpEntity tPostmpEntity);
	
	public int getTPosTmpCountInFiveMinutes(TPostmpEntity tPostmpEntity);
}
