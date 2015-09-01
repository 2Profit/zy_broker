package com.zy.broker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.dao.BrokerInfoDao;
import com.zy.broker.entity.BrokerInfo;
import com.zy.common.service.CommonService;

@Service
public class BrokerInfoService extends CommonService<BrokerInfo,String>{

	@Autowired
	private BrokerInfoDao brokerInfoDao;
	
	@Autowired
	public void setBrokerInfoDao(BrokerInfoDao brokerInfoDao) {
		super.setCommonDao(brokerInfoDao);
	}
	
}
