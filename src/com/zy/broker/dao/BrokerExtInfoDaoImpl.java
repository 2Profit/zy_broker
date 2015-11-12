package com.zy.broker.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zy.broker.dto.BrokerExtInfoDto;
import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.common.util.HumpPropertyBeanProcessor;

public class BrokerExtInfoDaoImpl extends CustomBaseSqlDaoImpl implements BrokerExtInfoCustomDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private QueryRunner qr = new QueryRunner();
	
	private static ResultSetHandler<List<BrokerExtInfo>> rsh = 
    		new BeanListHandler<BrokerExtInfo>(BrokerExtInfo.class, new BasicRowProcessor(new HumpPropertyBeanProcessor()));

	@Override
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDelete", isDelete);
		params.put("ids", Arrays.asList(ids));
		namedParameterJdbcTemplate.update("update broker_base_info set delete_flag = :isDelete, update_date = now() where id in (:ids) ", params);
	}
	
	
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
		
		
		slider2Hql(queryDto, hql, params);
		
		if(StringUtils.isNotBlank(queryDto.getProductType())){
			slider1Hql(queryDto, hql, params);
			slider3Hql(queryDto, hql, params);
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
	private void slider1Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		if((queryDto.getSlider1F()!=null && queryDto.getSlider1T()!=null) &&
				(queryDto.getSlider1F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider1T().compareTo(new BigDecimal(0))!=0)){
			
			if(BrokerExtInfoDto.PRODUCT_TYPE_ZERO.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LLG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_ONE.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LLS);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_TWO.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_HKG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_THREE.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_LKG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FIVE.equals(queryDto.getProductType())){
				hql.append(" and l.pointDiffMin").append(BrokerExtInfoDto.PRODUCT_TYPE_YY);
			}
			hql.append(" between :pointDiffMinFrom and :pointDiffMinTo ");
			params.put("pointDiffMinFrom", queryDto.getSlider1F());
			params.put("pointDiffMinTo", queryDto.getSlider1T());
		}
	}
	
	/**
	 * 拼装Slider2参数
	 * @param queryDto
	 * @param hql
	 * @param params
	 */
	private void slider2Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		
		if((queryDto.getSlider2F()!=null && queryDto.getSlider2T()!=null) &&
				(queryDto.getSlider2F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider2T().compareTo(new BigDecimal(0))!=0)){
			
			hql.append(" and l.leverRate between :leverRateFrom and :leverRateTo ");
			params.put("leverRateFrom", queryDto.getSlider2F());
			params.put("leverRateTo", queryDto.getSlider2T());
		}
	}
	/**
	 * 拼装Slider3参数
	 * @param queryDto
	 * @param hql
	 * @param params
	 */
	private void slider3Hql(BrokerExtInfoDto queryDto, StringBuilder hql,
			Map<String, Object> params) {
		if((queryDto.getSlider3F()!=null && queryDto.getSlider3T()!=null) &&
				(queryDto.getSlider3F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider3T().compareTo(new BigDecimal(0))!=0)){
			
			if(BrokerExtInfoDto.PRODUCT_TYPE_ZERO.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LLG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_ONE.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LLS);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_TWO.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_HKG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_THREE.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_LKG);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FOUR.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_WH);
			}else if(BrokerExtInfoDto.PRODUCT_TYPE_FIVE.equals(queryDto.getProductType())){
				hql.append(" and l.openMoney").append(BrokerExtInfoDto.PRODUCT_TYPE_YY);
			}
			hql.append(" between :openMoneyFrom and :openMoneyTo ");
			params.put("openMoneyFrom", queryDto.getSlider3F());
			params.put("openMoneyTo", queryDto.getSlider3T());
		}
	}
	

	
	
	/**
	 * 为了提高查询速度，直接使用sql，并且用dbutils转换成BrokerExtInfo对象，方便页面使用
	 */
	@Override
	public PageModel<BrokerExtInfo> queryPage(BrokerExtInfoDto queryDto, PageModel<BrokerExtInfo> pageModal) {
		PageModel<BrokerExtInfo> result = new PageModel<BrokerExtInfo>();
		
		int currentPage = pageModal.getCurrentPage();
		int pageSize = pageModal.getPageSize();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select b.cn_name,b.en_name,b.exchange_no1,b.exchange_no2,b.exchange_no3,b.exchange_no4,i.* ");
		sb.append(" from broker_ext_info i ");
		sb.append(" inner join broker_base_info b on b.id= i.id ");
		sb.append(" where 1=1 and b.delete_flag = 0 ");
		if(StringUtils.isNotBlank(queryDto.getBkName())){
			sb.append(" and ( b.cn_name like '%").append(queryDto.getBkName()).append("%' ");
			sb.append("       or b.en_name like '%").append(queryDto.getBkName()).append("%' ) ");
		}
		if(StringUtils.isNotBlank(queryDto.getCompanyType())){
			sb.append(" and i.company_type like '%").append(queryDto.getCompanyType()).append("%' ");
		}
		if(StringUtils.isNotBlank(queryDto.getIsEaSupport())){
			sb.append(" and i.is_ea_support = '").append(queryDto.getIsEaSupport()).append("' ");
		}
		if(StringUtils.isNotBlank(queryDto.getIsUnionpay())){
			sb.append(" and i.is_unionpay = '").append(queryDto.getIsUnionpay()).append("' ");
		}
		if(StringUtils.isNotBlank(queryDto.getIsInOutFree())){
			sb.append(" and i.is_in_out_free = '").append(queryDto.getIsInOutFree()).append("' ");
		}
		if(StringUtils.isNotBlank(queryDto.getProductType())){
			sb.append(" and i.product_type like '%").append(queryDto.getProductType()).append("%' ");
			
			slider1Sql(queryDto, sb);
			slider2Sql(queryDto, sb);
			slider3Sql(queryDto, sb);
		}
		if(StringUtils.isNotBlank(queryDto.getExTypeP())){
			if("0".equals(queryDto.getExTypeP())){
				sb.append(" and ( b.exchange_no1 is not null or b.exchange_no1 != '' )");
			}else if("1".equals(queryDto.getExTypeP())){
				sb.append(" and ( b.exchange_no2 is not null or b.exchange_no2 != '' ) ");
			}else if("2".equals(queryDto.getExTypeP())){
				sb.append(" and ( b.exchange_no3 is not null or b.exchange_no3 != '' ) ");
			}else if("3".equals(queryDto.getExTypeP())){
				sb.append(" and ( b.exchange_no4 is not null or b.exchange_no4 != '' ) ");
			}
		}
		if(StringUtils.isNoneBlank(queryDto.getOrderP())){
			sb.append(" order by i.").append(queryDto.getOrderP());
			/*if(StringUtils.isNotBlank(queryDto.getOrderD())){
				sb.append(queryDto.getOrderD());
			}else{
				sb.append(" desc ");
			}*/
		}else{
			sb.append(" order by i.company_index desc ");
		}
		
		int totalCount = this.getCount(sb.toString());
		if(totalCount > 0 ){
			
			List<BrokerExtInfo> dataList;
			try {
				sb.append(" limit ").append(pageSize).append(" offset ").append((currentPage-1)*pageSize);
				
				Connection connection = jdbcTemplate.getDataSource().getConnection();
				dataList = qr.query(connection,sb.toString(),rsh);
				connection.close();
				
				result.setCurrentPage(currentPage);
				result.setPageSize(pageSize);
				result.setTotalCount(totalCount);
				result.setList(dataList);
				
				int totalPage = 0;
				if(totalCount % pageSize == 0){
					totalPage = totalCount/pageSize;
				}else{
					totalPage = totalCount/pageSize + 1;
				}
				result.setTotalPage(totalPage);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * 拼装slider2参数
	 * @param queryDto
	 * @param sql
	 */
	private void slider2Sql(BrokerExtInfoDto queryDto, StringBuilder sql) {
		
		if((queryDto.getSlider2F()!=null && queryDto.getSlider2T()!=null) &&
				(queryDto.getSlider2F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider2T().compareTo(new BigDecimal(0))!=0)){
			
			sql.append(" and i.lever_rate between ").append(queryDto.getSlider2F()).append(" and ").append(queryDto.getSlider2T());
		}
	}
	
	
	/**
	 * 拼装Slider3参数
	 * @param queryDto
	 * @param sql
	 */
	private void slider1Sql(BrokerExtInfoDto queryDto, StringBuilder sql) {
		
		if((queryDto.getSlider1F()!=null && queryDto.getSlider1T()!=null) &&
				(queryDto.getSlider1F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider1T().compareTo(new BigDecimal(0))!=0)){
			
			if("0".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_llg ");
			}else if("1".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_lls ");
			}else if("2".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_hkg ");
			}else if("3".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_lkg ");
			}else if("4".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_wh ");
			}else if("5".equals(queryDto.getProductType())){
				sql.append(" and i.point_diff_min_yy");
			}
			sql.append(" between ").append(queryDto.getSlider1F()).append(" and ").append(queryDto.getSlider1T());
		}
	}
	
	/**
	 * 拼装Slider3参数
	 * @param queryDto
	 * @param sql
	 */
	private void slider3Sql(BrokerExtInfoDto queryDto, StringBuilder sql) {
		
		if((queryDto.getSlider3F()!=null && queryDto.getSlider3T()!=null) &&
				(queryDto.getSlider3F().compareTo(new BigDecimal(0))!=0 || queryDto.getSlider3T().compareTo(new BigDecimal(0))!=0)){
			
			if("0".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_llg ");
			}else if("1".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_lls ");
			}else if("2".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_hkg ");
			}else if("3".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_lkg ");
			}else if("4".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_wh ");
			}else if("5".equals(queryDto.getProductType())){
				sql.append(" and i.open_money_yy ");
			}
			sql.append(" between ").append(queryDto.getSlider3F()).append(" and ").append(queryDto.getSlider3T());
		}
	}
}
