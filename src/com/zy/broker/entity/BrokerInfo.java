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
	
	private String exchangeType1;//监管机构类型(0-金银业贸易场、1-证监会、2-英国FCA、3-日本FSA)
	private String exchangeNo1;//授予编号
	
	private String exchangeType2;//监管机构类型(0-金银业贸易场、1-证监会、2-英国FCA、3-日本FSA)
	private String exchangeNo2;//授予编号
	
	private String exchangeType3;//监管机构类型(0-金银业贸易场、1-证监会、2-英国FCA、3-日本FSA)
	private String exchangeNo3;//授予编号
	
	private String exchangeType4;//监管机构类型(0-金银业贸易场、1-证监会、2-英国FCA、3-日本FSA)
	private String exchangeNo4;//授予编号
	
	
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
	public String getExchangeType1() {
		return exchangeType1;
	}
	public void setExchangeType1(String exchangeType1) {
		this.exchangeType1 = exchangeType1;
	}
	@Column(length=64)
	public String getExchangeNo1() {
		return exchangeNo1;
	}
	public void setExchangeNo1(String exchangeNo1) {
		this.exchangeNo1 = exchangeNo1;
	}
	@Column(length=2)
	public String getExchangeType2() {
		return exchangeType2;
	}
	public void setExchangeType2(String exchangeType2) {
		this.exchangeType2 = exchangeType2;
	}
	@Column(length=64)
	public String getExchangeNo2() {
		return exchangeNo2;
	}
	public void setExchangeNo2(String exchangeNo2) {
		this.exchangeNo2 = exchangeNo2;
	}
	@Column(length=2)
	public String getExchangeType3() {
		return exchangeType3;
	}
	public void setExchangeType3(String exchangeType3) {
		this.exchangeType3 = exchangeType3;
	}
	@Column(length=64)
	public String getExchangeNo3() {
		return exchangeNo3;
	}
	public void setExchangeNo3(String exchangeNo3) {
		this.exchangeNo3 = exchangeNo3;
	}
	@Column(length=2)
	public String getExchangeType4() {
		return exchangeType4;
	}
	public void setExchangeType4(String exchangeType4) {
		this.exchangeType4 = exchangeType4;
	}
	@Column(length=64)
	public String getExchangeNo4() {
		return exchangeNo4;
	}
	public void setExchangeNo4(String exchangeNo4) {
		this.exchangeNo4 = exchangeNo4;
	}

	
	
	
	
}
