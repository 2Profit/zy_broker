package com.zy.broker.dao;

import org.springframework.data.jpa.repository.Query;

import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.dao.CommonDao;

public interface BrokerExtInfoDao extends BrokerExtInfoCustomDao,CommonDao<BrokerExtInfo,String>{

	public void updateDeleteFlag(String[] ids,Integer isDelete);
	
	@Query(" select count(1) from BrokerExtInfo i where i.companyIndex = ?1")
	public int findByCompanyIndex(Integer index);
	
	@Query(" select count(1) from BrokerExtInfo i where i.exchangeNo = ?1")
	public int findByExchangeNo(String exchangeNo);
	
	@Query(" select count(1) from BrokerExtInfo i where i.cnName = ?1")
	public int findByCnName(String cnName);
	
	@Query(" select count(1) from BrokerExtInfo i where i.enName = ?1")
	public int findByEnName(String cnName);
}
