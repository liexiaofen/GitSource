package com.winsolution.weixin.dao;

import java.util.List;

import com.winsolution.weixin.entity.TempSignEntity;

public interface ITempSignDao {
	public int insertTempSign(TempSignEntity tempSignEntity);
	public List<TempSignEntity> getTempSignLst(TempSignEntity tempSignEntity);
	//地图
	public List<TempSignEntity> getMap(TempSignEntity tempSignEntity);
}
