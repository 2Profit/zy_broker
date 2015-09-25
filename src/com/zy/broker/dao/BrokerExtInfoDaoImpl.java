package com.zy.broker.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;

public class BrokerExtInfoDaoImpl extends CustomBaseSqlDaoImpl implements BrokerExtInfoCustomDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	@SuppressWarnings("unchecked")
	public PageModel<BrokerExtInfo> queryForPage(BrokerExtInfo queryDto, PageModel<BrokerExtInfo> pageModal) {
		StringBuilder hql = new StringBuilder("select l from BrokerExtInfo l where 1=1 ");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(queryDto.getCnName())){
			hql.append(" and l.cnName like :cnName ");
			params.put("cnName", "%"+queryDto.getCnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getEnName())){
			hql.append(" and l.enName like :enName ");
			params.put("enName", "%"+queryDto.getEnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getExchangeType())){
			hql.append(" and l.exchangeType = :exchangeType ");
			params.put("exchangeType", queryDto.getExchangeType());
		}
		if(StringUtils.isNotBlank(queryDto.getExchangeNo())){
			hql.append(" and l.exchangeNo = :exchangeNo ");
			params.put("exchangeNo", queryDto.getExchangeNo());
		}
		if(StringUtils.isNotBlank(queryDto.getCompanyArea())){
			hql.append(" and l.companyArea = :companyArea ");
			params.put("companyArea", queryDto.getCompanyArea());
		}
		if(StringUtils.isNotBlank(queryDto.getCompanyType())){
			hql.append(" and l.companyType = :companyType ");
			params.put("companyType", queryDto.getCompanyType());
		}
		if(StringUtils.isNotBlank(queryDto.getIsEaSupport())){
			hql.append(" and l.isEaSupport = :isEaSupport ");
			params.put("isEaSupport", queryDto.getIsEaSupport());
		}
		
		
		if(queryDto.getDeleteFlag()!=null){
			hql.append(" and l.deleteFlag = :deleteFlag ");
			params.put("deleteFlag", queryDto.getDeleteFlag());
		}
		hql.append(" order by l.updateDate desc ");
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", isDelete);
		params.put("ids", Arrays.asList(ids));
		namedParameterJdbcTemplate.update("update broker_ext_info set delete_flag = :isDelete, update_date = now() where id in (:ids) ", params);
	}
}
