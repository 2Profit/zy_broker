package com.zy.broker.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 经纪商扩展信息表
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "broker_ext_info")
public class BrokerExtInfo extends BrokerInfo{

	private static final long serialVersionUID = -6484727702617090488L;

}
