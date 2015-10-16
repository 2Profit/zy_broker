package com.zy.broker.dao;

import java.math.BigDecimal;
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
		
		if(StringUtils.isNotBlank(queryDto.getBkName())){
			hql.append(" and ( l.cnName like :brokerName or l.enName like :brokerName )");
			params.put("brokerName", "%"+queryDto.getBkName()+"%");
		}
		
		if(StringUtils.isNotBlank(queryDto.getCnName())){
			hql.append(" and l.cnName like :cnName ");
			params.put("cnName", "%"+queryDto.getCnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getEnName())){
			hql.append(" and l.enName like :enName ");
			params.put("enName", "%"+queryDto.getEnName()+"%");
		}
		
		
		Slider2Hql(queryDto, hql, params);
		
		if(StringUtils.isNotBlank(queryDto.getProductType())){
			Slider1Hql(queryDto, hql, params);
			Slider3Hql(queryDto, hql, params);
		}
		
		if(StringUtils.isNotBlank(queryDto.getIsUnionpay())){
			hql.append(" and l.isUnionpay = :isUnionpay ");
			params.put("isUnionpay", queryDto.getIsUnionpay());
		}
		if(StringUtils.isNotBlank(queryDto.getIsInOutFree())){
			hql.append(" and l.isInOutFree = :isInOutFree ");
			params.put("isInOutFree", queryDto.getIsInOutFree());
		}
		
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
		
		//根据类型查询
		if(StringUtils.isNotBlank(queryDto.getExTypeP())){
			
			if("0".equals(queryDto.getExTypeP())){
				hql.append(" and l.exchangeNo1 is not null and l.exchangeNo1 is not empty ");
			}
			if("1".equals(queryDto.getExTypeP())){
				hql.append(" and l.exchangeNo2 is not null and l.exchangeNo2 is not empty ");
			}
			if("2".equals(queryDto.getExTypeP())){
				hql.append(" and l.exchangeNo3 is not null and l.exchangeNo3 is not empty ");
			}
			if("3".equals(queryDto.getExTypeP())){
				hql.append(" and l.exchangeNo4 is not null and l.exchangeNo4 is not empty ");
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
		
		if(StringUtils.isNoneBlank(queryDto.getOrderP())){
			hql.append(" order by :orderByParam ");
			params.put("orderByParam", queryDto.getOrderP());
			if(StringUtils.isNotBlank(queryDto.getOrderD())){
				hql.append(queryDto.getOrderD());
			}
		}else{
			hql.append(" order by l.updateDate desc ");
		}
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}

	/**
	 * 拼装Slider1参数
	 * @param queryDto
	 * @param hql
	 * @param params
	 */
	private void Slider1Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		if((queryDto.getSlider1F()!=null && queryDto.getSlider1T()!=null) &&
				(queryDto.getSlider1F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider1T().compareTo(new BigDecimal(0))!=0)){
			
			if(BrokerExtInfoDto.PRODUCT_TYPE_ZERO.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LLG);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_ONE.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LLS);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_TWO.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_HKG);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_THREE.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LKG);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
				hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
				params.put("pointDiffMinFrom", queryDto.getSlider1F());
				params.put("pointDiffMinTo", queryDto.getSlider1T());
			}
		}
	}
	
	/**
	 * 拼装Slider2参数
	 * @param queryDto
	 * @param hql
	 * @param params
	 */
	private void Slider2Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		
		if((queryDto.getSlider2F()!=null && queryDto.getSlider2T()!=null) &&
				(queryDto.getSlider2F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider2T().compareTo(new BigDecimal(0))!=0)){
			
			if(BrokerExtInfoDto.PRODUCT_TYPE_ZERO.equals(queryDto.getProductType())){
				hql.append(" and l.leverRate between :leverRateFrom and :leverRateTo ");
				params.put("leverRateFrom", queryDto.getSlider2F());
				params.put("leverRateTo", queryDto.getSlider2T());
			}
		}
	}
	/**
	 * 拼装Slider3参数
	 * @param queryDto
	 * @param hql
	 * @param params
	 */
	private void Slider3Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		if((queryDto.getSlider3F()!=null && queryDto.getSlider3T()!=null) &&
				(queryDto.getSlider3F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider3T().compareTo(new BigDecimal(0))!=0)){
			
			if(BrokerExtInfoDto.PRODUCT_TYPE_ZERO.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LLG);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_ONE.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LLS);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_TWO.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_HKG);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_THREE.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LKG);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
				hql.append(" between :openMoneyFrom and :openMoneyTo ");
				params.put("openMoneyFrom", queryDto.getSlider3F());
				params.put("openMoneyTo", queryDto.getSlider3T());
			}
		}
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", isDelete);
		params.put("ids", Arrays.asList(ids));
		namedParameterJdbcTemplate.update("update broker_ext_info set delete_flag = :isDelete, update_date = now() where id in (:ids) ", params);
	}
}
