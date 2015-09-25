package com.zy.broker.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zy.broker.entity.BrokerInfo;
import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;

public class BrokerInfoDaoImpl extends CustomBaseSqlDaoImpl implements BrokerInfoCustomDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	@SuppressWarnings("unchecked")
	public PageModel<BrokerInfo> queryForPage(BrokerInfo queryDto, PageModel<BrokerInfo> pageModal) {
		StringBuilder hql = new StringBuilder("select l from BrokerInfo l where 1=1 ");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(queryDto.getName())){
			hql.append(" and l.name like :brokerInfoName ");
			params.put("brokerInfoName", "%"+queryDto.getName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getExchangeNo())){
			hql.append(" and l.exchangeNo = :exchangeNo ");
			params.put("exchangeNo", queryDto.getExchangeNo());
		}
		
		hql.append(" order by l.updateDate desc ");
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", isDelete);
		params.put("ids", Arrays.asList(ids));
		namedParameterJdbcTemplate.update("update broker_base_info set delete_flag = :isDelete, update_date = now() where id in (:ids) ", params);
	}
}
