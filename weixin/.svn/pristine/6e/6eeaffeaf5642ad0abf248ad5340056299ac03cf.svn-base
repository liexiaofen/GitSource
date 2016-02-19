package com.winsolution.weixin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winsolution.weixin.dao.ITPosTmpDao;
import com.winsolution.weixin.entity.TPostmpEntity;
import com.winsolution.weixin.service.ITPosTmpService;
@Service("tPostmpService")
public class TPostmpServiceImpl implements ITPosTmpService {

	@Autowired
	private ITPosTmpDao tPosTmpDao;
	@Override
	public int insertTPosTmp(TPostmpEntity tPostmpEntity) {
		// TODO Auto-generated method stub
		return tPosTmpDao.insertTPosTmp(tPostmpEntity);
	}
	@Override
	public int getTPosTmpCountInFiveMinutes(TPostmpEntity tPostmpEntity) {
		// TODO Auto-generated method stub
		return tPosTmpDao.getTPosTmpCountInFiveMinutes(tPostmpEntity);
	}
	

}
