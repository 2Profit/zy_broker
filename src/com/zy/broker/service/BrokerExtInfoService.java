package com.zy.broker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.dao.BrokerExtInfoDao;
import com.zy.broker.dto.BrokerExtInfoDto;
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
	
	public PageModel<BrokerExtInfo> queryForPage(BrokerExtInfoDto queryDto,PageModel<BrokerExtInfo> pageModel){
		return brokerExtInfoDao.queryForPage(queryDto,pageModel);
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		brokerExtInfoDao.updateDeleteFlag(ids, isDelete);
	}
	
	public int findByCompanyIndex(Integer index){
		return brokerExtInfoDao.findByCompanyIndex(index);
	}
	
	public int findByExchangeNo(String exchangeNo){
		return brokerExtInfoDao.findByExchangeNo(exchangeNo);
	}
	
	public int findByCnName(String cnName){
		return brokerExtInfoDao.findByCnName(cnName);
	}
	
	public int findByEnName(String cnName){
		return brokerExtInfoDao.findByEnName(cnName);
	}
	
	public List<BrokerExtInfo> findIndexPageBrokers(){
		BrokerExtInfoDto queryDto = new BrokerExtInfoDto();
		queryDto.setOrderByParam(BrokerExtInfoDto.ORDERBY_COMPANYINDEX);
		queryDto.setOrderByDirection(BrokerExtInfoDto.ORDERBY_DESC);
		PageModel<BrokerExtInfo> pageModel = new PageModel<BrokerExtInfo>();
		pageModel.setPageSize(6);
		return brokerExtInfoDao.queryForPage(queryDto,pageModel).getList();
	}
}
