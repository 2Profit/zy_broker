package com.zy.broker.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;

/**
 * 经纪商基础信息表
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "broker_base_info")
public class BrokerInfo extends BaseEntity{

	private static final long serialVersionUID = -2401313775739843476L;

}
