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
	
	public PageModel<BrokerExtInfo> queryPage(BrokerExtInfoDto queryDto,PageModel<BrokerExtInfo> pageModel){
		return brokerExtInfoDao.queryPage(queryDto,pageModel);
	}
	
	public void updateDeleteFlag(String[] ids,Integer isDelete){
		brokerExtInfoDao.updateDeleteFlag(ids, isDelete);
	}
	
	public int findByCompanyIndex(Integer index){
		return brokerExtInfoDao.findByCompanyIndex(index);
	}
	
	public int findByExchangeNo1(String exchangeNo1){
		return brokerExtInfoDao.findByExchangeNo1(exchangeNo1);
	}
	public int findByExchangeNo2(String exchangeNo2){
		return brokerExtInfoDao.findByExchangeNo2(exchangeNo2);
	}
	public int findByExchangeNo3(String exchangeNo3){
		return brokerExtInfoDao.findByExchangeNo3(exchangeNo3);
	}
	public int findByExchangeNo4(String exchangeNo4){
		return brokerExtInfoDao.findByExchangeNo4(exchangeNo4);
	}
	
	public int findByCnName(String cnName){
		return brokerExtInfoDao.findByCnName(cnName);
	}
	
	public int findByEnName(String cnName){
		return brokerExtInfoDao.findByEnName(cnName);
	}
	
	public List<BrokerExtInfo> findIndexPageBrokers(){
		BrokerExtInfoDto queryDto = new BrokerExtInfoDto();
		queryDto.setOrderP(BrokerExtInfoDto.ORDERBY_COMPANYINDEX);
		queryDto.setOrderD(BrokerExtInfoDto.ORDERBY_DESC);
		PageModel<BrokerExtInfo> pageModel = new PageModel<BrokerExtInfo>();
		pageModel.setPageSize(6);
		return brokerExtInfoDao.queryForPage(queryDto,pageModel).getList();
	}
}
