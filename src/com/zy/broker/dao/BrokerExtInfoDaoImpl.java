package com.zy.broker.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zy.broker.dto.BrokerExtInfoDto;
import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;

public class BrokerExtInfoDaoImpl extends CustomBaseSqlDaoImpl implements BrokerExtInfoCustomDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	@SuppressWarnings("unchecked")
	public PageModel<BrokerExtInfo> queryForPage(BrokerExtInfoDto queryDto, PageModel<BrokerExtInfo> pageModal) {
		StringBuilder hql = new StringBuilder("select l from BrokerExtInfo l where 1=1 ");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(queryDto.getBrokerName())){
			hql.append(" and ( l.cnName like :brokerName or l.enName like :brokerName )");
			params.put("brokerName", "%"+queryDto.getBrokerName()+"%");
		}
		
		if(StringUtils.isNotBlank(queryDto.getCnName())){
			hql.append(" and l.cnName like :cnName ");
			params.put("cnName", "%"+queryDto.getCnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getEnName())){
			hql.append(" and l.enName like :enName ");
			params.put("enName", "%"+queryDto.getEnName()+"%");
		}
		
		
		/*if(StringUtils.isNotBlank(queryDto.getExchangeType())){
			hql.append(" and l.exchangeType like :exchangeType ");
			params.put("exchangeType", "%"+queryDto.getExchangeType()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getExchangeNo())){
			hql.append(" and l.exchangeNo = :exchangeNo ");
			params.put("exchangeNo", queryDto.getExchangeNo());
		}*/
		
		if(StringUtils.isNotBlank(queryDto.getExchangeTypeParam())){
			//根据类型查询
			if(StringUtils.isNotBlank(queryDto.getExchangeNo1())){
				hql.append(" and l.exchangeNo1 != '' ");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo2())){
				hql.append(" and l.exchangeNo2 != '' ");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo3())){
				hql.append(" and l.exchangeNo3 != '' ");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo4())){
				hql.append(" and l.exchangeNo4 != '' ");
			}
		}else{
			//根据编号查询
			if(StringUtils.isNotBlank(queryDto.getExchangeNo1())){
				hql.append(" and l.exchangeNo1 like :exchangeNo1 ");
				params.put("exchangeNo1", "%"+queryDto.getExchangeNo1()+"%");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo2())){
				hql.append(" and l.exchangeNo2 like :exchangeNo2 ");
				params.put("exchangeNo2", "%"+queryDto.getExchangeNo2()+"%");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo3())){
				hql.append(" and l.exchangeNo3 like :exchangeNo3 ");
				params.put("exchangeNo3", "%"+queryDto.getExchangeNo3()+"%");
			}
			if(StringUtils.isNotBlank(queryDto.getExchangeNo4())){
				hql.append(" and l.exchangeNo4 like :exchangeNo4 ");
				params.put("exchangeNo4", "%"+queryDto.getExchangeNo4()+"%");
			}
		}
		
		
		if(StringUtils.isNotBlank(queryDto.getPlatform())){
			hql.append(" and l.platform like :platform ");
			params.put("platform", "%"+queryDto.getPlatform()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getIsShowUrl())){
			hql.append(" and l.isShowUrl = :isShowUrl ");
			params.put("isShowUrl", queryDto.getIsShowUrl());
		}
		if(StringUtils.isNotBlank(queryDto.getLicenseType())){
			hql.append(" and l.licenseType = :licenseType ");
			params.put("licenseType", queryDto.getLicenseType());
		}
		if(StringUtils.isNotBlank(queryDto.getCompanyArea())){
			hql.append(" and l.companyArea = :companyArea ");
			params.put("companyArea", queryDto.getCompanyArea());
		}
		if(StringUtils.isNotBlank(queryDto.getCompanyType())){
			hql.append(" and l.companyType like :companyType ");
			params.put("companyType", "%"+queryDto.getCompanyType()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getProductType())){
			hql.append(" and l.productType like :productType ");
			params.put("productType", "%"+queryDto.getProductType()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getIsEaSupport())){
			hql.append(" and l.isEaSupport = :isEaSupport ");
			params.put("isEaSupport", queryDto.getIsEaSupport());
		}
		if(StringUtils.isNotBlank(queryDto.getIsOpenFee())){
			hql.append(" and l.isOpenFee = :isOpenFee ");
			params.put("isOpenFee", queryDto.getIsOpenFee());
		}
		if(StringUtils.isNotBlank(queryDto.getIsCloseFee())){
			hql.append(" and l.isCloseFee = :isCloseFee ");
			params.put("isCloseFee", queryDto.getIsCloseFee());
		}
		
		if(queryDto.getDeleteFlag()!=null){
			hql.append(" and l.deleteFlag = :deleteFlag ");
			params.put("deleteFlag", queryDto.getDeleteFlag());
		}
		
		if(StringUtils.isNoneBlank(queryDto.getOrderByParam())){
			hql.append(" order by :orderByParam ");
			params.put("orderByParam", queryDto.getOrderByParam());
			
			if(StringUtils.isNotBlank(queryDto.getOrderByDirection())){
				if(BrokerExtInfoDto.ORDERBY_DESC.equals(queryDto.getOrderByDirection())){
					hql.append(" desc ");
				}else{
					hql.append(" asc ");
				}
			}
		}else{
			hql.append(" order by l.updateDate desc ");
		}
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", isDelete);
		params.put("ids", Arrays.asList(ids));
		namedParameterJdbcTemplate.update("update broker_ext_info set delete_flag = :isDelete, update_date = now() where id in (:ids) ", params);
	}
}
