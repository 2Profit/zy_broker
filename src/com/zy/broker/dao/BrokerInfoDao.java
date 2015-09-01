package com.zy.broker.dao;

import com.zy.broker.entity.BrokerInfo;
import com.zy.common.dao.CommonDao;

public interface BrokerInfoDao extends CommonDao<BrokerInfo,String> {

	public void updateDeleteFlag(String[] ids,Integer isDelete);
}
