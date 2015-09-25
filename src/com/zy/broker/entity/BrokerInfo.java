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

	private String cnName;//中文名称
	private String enName;//英文名称
	private String exchangeType;//监管机构类型(0-金银业贸易场、1-证监会、2-不设)
	private String exchangeNo;//监管机构授予编号
	
	@Column(length=128)
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	@Column(length=128)
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	@Column(length=2)
	public String getExchangeType() {
		return exchangeType;
	}
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	@Column(name="exchange_no",length=128)
	public String getExchangeNo() {
		return exchangeNo;
	}
	public void setExchangeNo(String exchangeNo) {
		this.exchangeNo = exchangeNo;
	}
	
}
