package com.zy.broker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.zy.broker.entity.MemBrokerRel;
import com.zy.common.dao.CommonDao;

public interface MemBrokerRelDao extends CommonDao<MemBrokerRel, String> {

	@Query("from MemBrokerRel m where m.member.id = ?1 and m.deleteFlag = 0 order by m.createDate")
	public List<MemBrokerRel> findMemBrokerRels(String memberId);
	
}
