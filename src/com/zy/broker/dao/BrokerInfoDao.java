package com.zy.broker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.zy.broker.entity.BrokerInfo;
import com.zy.common.dao.CommonDao;

public interface BrokerInfoDao extends CommonDao<BrokerInfo,String> {

	public void updateDeleteFlag(String[] ids,Integer isDelete);
	
	@Query("select u from BrokerInfo u where u.deleteFlag=?1 ")
	public List<BrokerInfo> findAllBrokerInfo(Integer deleteFlag);
}
