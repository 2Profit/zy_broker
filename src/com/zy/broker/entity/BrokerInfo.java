package com.zy.broker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;

/**
 * 经纪商信息
 * @author Jeff Xu
 * @author pingan
 */
@Entity
@Table(name = "broker_base_info")
@Inheritance(strategy=InheritanceType.JOINED)
public class BrokerInfo extends BaseEntity{

	private static final long serialVersionUID = -2401313775739843476L;

	/**
	 * 交易商名称
	 */
	private String name;
	/**
	 * 金银业贸易场编号
	 */
	private String exchangeNo;
	
	
	@Column(name="name",length=128)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="exchange_no",length=64)
	public String getExchangeNo() {
		return exchangeNo;
	}
	public void setExchangeNo(String exchangeNo) {
		this.exchangeNo = exchangeNo;
	}
	
}
