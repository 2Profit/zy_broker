package com.zy.broker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.dao.MemBrokerRelDao;
import com.zy.broker.entity.MemBrokerRel;
import com.zy.common.service.CommonService;

@Service
public class MemBrokerRelService extends CommonService<MemBrokerRel, String> {

	@Autowired
	private MemBrokerRelDao memBrokerRelDao;
	
	@Autowired
	public void setMemBrokerRelDao(MemBrokerRelDao memBrokerRelDao){
		super.setCommonDao(memBrokerRelDao);
	}
	
	public List<MemBrokerRel> findMemBrokerRels(String memberId){
		return memBrokerRelDao.findMemBrokerRels(memberId);
	}
	
}
