package com.zy.broker.dao;

import com.zy.broker.entity.BrokerInfo;
import com.zy.common.entity.PageModel;

public interface BrokerInfoCustomDao {

	PageModel<BrokerInfo> queryForPage(BrokerInfo queryDto,PageModel<BrokerInfo> pageModal);
}
