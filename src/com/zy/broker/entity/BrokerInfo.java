package com.zy.broker.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;

/**
 * 经纪商信息
 * @author Jeff Xu
 * @author pingan
 */
@Entity
@Table(name = "broker_base_info")
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
	/**
	 * 公司属地 (0-香港/1-中国/2-台湾/3-其他)
	 */
	private String companyArea;
	/**
	 * 业务类型 (0-黄金/1-外汇/2-中国A股)
	 */
	private String serviceType;
	/**
	 * 交易平台 (0-mt4/1-mt5/2-gts1/3-mfinance/4-其他) 
	 */
	private String platform;
	/**
	 * 业务形式 (0-代理/1-直销/2-混合)
	 */
	private String serviceShape;
	/**
	 * 产品点差 (0-固定/1-浮动)
	 */
	private String pointDiff;
	/**
	 * 客户回佣 (1-提供/0-不提供)
	 */
	private String isReturnCommission;
	/**
	 * 长仓利息
	 */
	private Double longRate;
	/**
	 * 短仓利息
	 */
	private Double shortRate;
	/**
	 * 结算币值 (0-USD/1-HKD/2-CNY)
	 */
	private String moneyType;
	/**
	 * 开仓保证金
	 */
	private BigDecimal openMoney;
	/**
	 * 维持保证金
	 */
	private BigDecimal holdMoeny;
	/**
	 * 锁仓保证金
	 */
	private BigDecimal closeMoney;
	/**
	 * 网页显示 (1-开/0-关)
	 */
	private String isShowPage;
	/**
	 * 链接显示 (1-开/0-关)
	 */
	private String isShowUrl;
	/**
	 * 交易商链接 
	 */
	private String url;
	/**
	 * 杠杆比例
	 */
	private Double leverRate;
	
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
	@Column(name="company_area",length=8)
	public String getCompanyArea() {
		return companyArea;
	}
	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}
	@Column(name="service_type",length=8)
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Column(name="platform",length=8)
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Column(name="service_shape",length=8)
	public String getServiceShape() {
		return serviceShape;
	}
	public void setServiceShape(String serviceShape) {
		this.serviceShape = serviceShape;
	}
	@Column(name="point_diff",length=8)
	public String getPointDiff() {
		return pointDiff;
	}
	public void setPointDiff(String pointDiff) {
		this.pointDiff = pointDiff;
	}
	@Column(name="is_return_commission",length=8)
	public String getIsReturnCommission() {
		return isReturnCommission;
	}
	public void setIsReturnCommission(String isReturnCommission) {
		this.isReturnCommission = isReturnCommission;
	}
	public Double getLongRate() {
		return longRate;
	}
	public void setLongRate(Double longRate) {
		this.longRate = longRate;
	}
	public Double getShortRate() {
		return shortRate;
	}
	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	}
	@Column(length=8)
	public String getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public BigDecimal getOpenMoney() {
		return openMoney;
	}
	public void setOpenMoney(BigDecimal openMoney) {
		this.openMoney = openMoney;
	}
	public BigDecimal getHoldMoeny() {
		return holdMoeny;
	}
	public void setHoldMoeny(BigDecimal holdMoeny) {
		this.holdMoeny = holdMoeny;
	}
	public BigDecimal getCloseMoney() {
		return closeMoney;
	}
	public void setCloseMoney(BigDecimal closeMoney) {
		this.closeMoney = closeMoney;
	}
	@Column(length=8)
	public String isShowPage() {
		return isShowPage;
	}
	public void setShowPage(String isShowPage) {
		this.isShowPage = isShowPage;
	}
	@Column(length=8)
	public String isShowUrl() {
		return isShowUrl;
	}
	public void setShowUrl(String isShowUrl) {
		this.isShowUrl = isShowUrl;
	}
	@Column(length=128)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Double getLeverRate() {
		return leverRate;
	}
	public void setLeverRate(Double leverRate) {
		this.leverRate = leverRate;
	}
	
	
}
