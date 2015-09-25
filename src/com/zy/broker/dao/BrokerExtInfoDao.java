package com.zy.broker.dao;

import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.dao.CommonDao;

public interface BrokerExtInfoDao extends BrokerExtInfoCustomDao,CommonDao<BrokerExtInfo,String>{

	public void updateDeleteFlag(String[] ids,Integer isDelete);
}
