package com.zy.broker.dao;

import com.zy.broker.dto.BrokerExtInfoDto;
import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.entity.PageModel;

public interface BrokerExtInfoCustomDao {

	PageModel<BrokerExtInfo> queryForPage(BrokerExtInfoDto queryDto,PageModel<BrokerExtInfo> pageModal);
	
	PageModel<BrokerExtInfo> queryPage(BrokerExtInfoDto queryDto,PageModel<BrokerExtInfo> pageModal);
	
	public void updateDeleteFlag(String[] ids,Integer isDelete);
}
