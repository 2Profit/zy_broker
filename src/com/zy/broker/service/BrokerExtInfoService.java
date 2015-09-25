package com.zy.broker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.dao.BrokerExtInfoDao;
import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;

@Service
public class BrokerExtInfoService extends CommonService<BrokerExtInfo,String>{

	@Autowired
	private BrokerExtInfoDao brokerExtInfoDao;
	
	@Autowired
	public void setBrokerExtInfoDao(BrokerExtInfoDao brokerExtInfoDao) {
		super.setCommonDao(brokerExtInfoDao);
	}
	
	public PageModel<BrokerExtInfo> queryForPage(BrokerExtInfo queryDto,PageModel<BrokerExtInfo> pageModel){
		return brokerExtInfoDao.queryForPage(queryDto,pageModel);
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		brokerExtInfoDao.updateDeleteFlag(ids, isDelete);
	}
}
