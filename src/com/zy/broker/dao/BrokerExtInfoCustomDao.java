package com.zy.broker.dao;

import com.zy.broker.entity.BrokerExtInfo;
import com.zy.common.entity.PageModel;

public interface BrokerExtInfoCustomDao {

	PageModel<BrokerExtInfo> queryForPage(BrokerExtInfo queryDto,PageModel<BrokerExtInfo> pageModal);
}
