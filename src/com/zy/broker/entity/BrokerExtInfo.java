package com.zy.broker.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * 经纪商详细信息
 * @author Jeff Xu
 * @author pingan
 */
@Entity
@Table(name = "broker_ext_info")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class BrokerExtInfo extends BrokerInfo{

	private static final long serialVersionUID = -6484727702617090488L;

	/**
	 * 公司属地 (0-香港/1-中国/2-台湾/3-其他)
	 */
	private String companyArea;
	/**
	 * 公司类型 (0-黄金/1-外汇/2-中国A股)
	 * 多选项、逗号分隔
	 */
	private String companyType;
	/**
	 * 交易平台 (0-MT4/1-MT5/2-GTS1/3-GTS2/4-mFinance) 
	 * 多选项、逗号分隔
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
	 * 产品点差(最低)LLG、LLS、HKG、LKG
	 */
	private Double pointDiffMinLlg;
	private Double pointDiffMinLls;
	private Double pointDiffMinHkg;
	private Double pointDiffMinLkg;
	/**
	 * 产品点差(最高)LLG、LLS、HKG、LKG
	 */
	private Double pointDiffMaxLlg;
	private Double pointDiffMaxLls;
	private Double pointDiffMaxHkg;
	private Double pointDiffMaxLkg;
	/**
	 * 单次最高交易手数LLG、LLS、HKG、LKG
	 */
	private Double maxTradeNumLlg;
	private Double maxTradeNumLls;
	private Double maxTradeNumHkg;
	private Double maxTradeNumLkg;
	/**
	 * 持仓手数上限
	 */
	private Double maxHoldNum;
	/*private Double maxHoldNumLlg;
	private Double maxHoldNumLls;
	private Double maxHoldNumHkg;
	private Double maxHoldNumLkg;*/
	/**
	 * 客户回佣 (1-提供/0-不提供)
	 */
	private String isReturnCommission;
	/**
	 * 交易编码(1-提供/0-不提供)
	 */
	private String isTradeCode;
	/**
	 * 建仓手续费（1-收取/0-不收取）
	 */
	private String isOpenFee;
	/**
	 * 平仓手续费（1-收 取/0-不收取）
	 */
	private String isCloseFee;
	/**
	 * 长仓利息
	 */
	private Double longRate;
	/**
	 * 短仓利息
	 */
	private Double shortRate;
	/**
	 * 结算币值(0-美元/1-人民幣/2-港元/3-混合)
	 */
	private String moneyType;
	/**
	 * 开仓保证金(LLG、LLS、HKG、LKG)
	 */
	private BigDecimal openMoneyLlg;
	private BigDecimal openMoneyLls;
	private BigDecimal openMoneyHkg;
	private BigDecimal openMoneyLkg;
	/**
	 * 维持保证金(LLG、LLS、HKG、LKG)
	 */
	private BigDecimal holdMoneyLlg;
	private BigDecimal holdMoneyLls;
	private BigDecimal holdMoneyHkg;
	private BigDecimal holdMoneyLkg;
	/**
	 * 锁仓保证金(LLG、LLS、HKG、LKG)
	 */
	private BigDecimal closeMoneyLlg;
	private BigDecimal closeMoneyLls;
	private BigDecimal closeMoneyHkg;
	private BigDecimal closeMoneyLkg;
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
	/**
	 * 喊单服务
	 */
	private String isSingalService;
	/**
	 * 帐户分层(1-提供/0-不提供)
	 */
	private String isAccountSeperate;
	/**
	 * 产品(0-LLG/1-LLS/2-HKG/3-LKG)
	 * 多选项、逗号分隔
	 */
	private String productType;
	/**
	 * 強平百分比
	 */
	private Double closeRate;
	/**
	 * 强平百分比——周末/假日
	 */
	private Double closeRateExt;
	
	@Column(length=8)
	public String getCompanyArea() {
		return companyArea;
	}
	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}
	@Column(length=8)
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	@Column(length=8)
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Column(length=8)
	public String getServiceShape() {
		return serviceShape;
	}
	public void setServiceShape(String serviceShape) {
		this.serviceShape = serviceShape;
	}
	@Column(length=8)
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
	@Column(length=8)
	public String isShowPage() {
		return isShowPage;
	}
	public void setShowPage(String isShowPage) {
		this.isShowPage = isShowPage;
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
	public Double getPointDiffMinLlg() {
		return pointDiffMinLlg;
	}
	public void setPointDiffMinLlg(Double pointDiffMinLlg) {
		this.pointDiffMinLlg = pointDiffMinLlg;
	}
	public Double getPointDiffMinLls() {
		return pointDiffMinLls;
	}
	public void setPointDiffMinLls(Double pointDiffMinLls) {
		this.pointDiffMinLls = pointDiffMinLls;
	}
	public Double getPointDiffMinHkg() {
		return pointDiffMinHkg;
	}
	public void setPointDiffMinHkg(Double pointDiffMinHkg) {
		this.pointDiffMinHkg = pointDiffMinHkg;
	}
	public Double getPointDiffMinLkg() {
		return pointDiffMinLkg;
	}
	public void setPointDiffMinLkg(Double pointDiffMinLkg) {
		this.pointDiffMinLkg = pointDiffMinLkg;
	}
	public Double getPointDiffMaxLlg() {
		return pointDiffMaxLlg;
	}
	public void setPointDiffMaxLlg(Double pointDiffMaxLlg) {
		this.pointDiffMaxLlg = pointDiffMaxLlg;
	}
	public Double getPointDiffMaxLls() {
		return pointDiffMaxLls;
	}
	public void setPointDiffMaxLls(Double pointDiffMaxLls) {
		this.pointDiffMaxLls = pointDiffMaxLls;
	}
	public Double getPointDiffMaxHkg() {
		return pointDiffMaxHkg;
	}
	public void setPointDiffMaxHkg(Double pointDiffMaxHkg) {
		this.pointDiffMaxHkg = pointDiffMaxHkg;
	}
	public Double getPointDiffMaxLkg() {
		return pointDiffMaxLkg;
	}
	public void setPointDiffMaxLkg(Double pointDiffMaxLkg) {
		this.pointDiffMaxLkg = pointDiffMaxLkg;
	}
	public Double getMaxTradeNumLlg() {
		return maxTradeNumLlg;
	}
	public void setMaxTradeNumLlg(Double maxTradeNumLlg) {
		this.maxTradeNumLlg = maxTradeNumLlg;
	}
	public Double getMaxTradeNumLls() {
		return maxTradeNumLls;
	}
	public void setMaxTradeNumLls(Double maxTradeNumLls) {
		this.maxTradeNumLls = maxTradeNumLls;
	}
	public Double getMaxTradeNumHkg() {
		return maxTradeNumHkg;
	}
	public void setMaxTradeNumHkg(Double maxTradeNumHkg) {
		this.maxTradeNumHkg = maxTradeNumHkg;
	}
	public Double getMaxTradeNumLkg() {
		return maxTradeNumLkg;
	}
	public void setMaxTradeNumLkg(Double maxTradeNumLkg) {
		this.maxTradeNumLkg = maxTradeNumLkg;
	}
	public Double getMaxHoldNum() {
		return maxHoldNum;
	}
	public void setMaxHoldNum(Double maxHoldNum) {
		this.maxHoldNum = maxHoldNum;
	}
	@Column(length=8)
	public String getIsTradeCode() {
		return isTradeCode;
	}
	public void setIsTradeCode(String isTradeCode) {
		this.isTradeCode = isTradeCode;
	}
	@Column(length=8)
	public String getIsOpenFee() {
		return isOpenFee;
	}
	public void setIsOpenFee(String isOpenFee) {
		this.isOpenFee = isOpenFee;
	}
	@Column(length=8)
	public String getIsCloseFee() {
		return isCloseFee;
	}
	public void setIsCloseFee(String isCloseFee) {
		this.isCloseFee = isCloseFee;
	}
	public BigDecimal getOpenMoneyLlg() {
		return openMoneyLlg;
	}
	public void setOpenMoneyLlg(BigDecimal openMoneyLlg) {
		this.openMoneyLlg = openMoneyLlg;
	}
	public BigDecimal getOpenMoneyLls() {
		return openMoneyLls;
	}
	public void setOpenMoneyLls(BigDecimal openMoneyLls) {
		this.openMoneyLls = openMoneyLls;
	}
	public BigDecimal getOpenMoneyHkg() {
		return openMoneyHkg;
	}
	public void setOpenMoneyHkg(BigDecimal openMoneyHkg) {
		this.openMoneyHkg = openMoneyHkg;
	}
	public BigDecimal getOpenMoneyLkg() {
		return openMoneyLkg;
	}
	public void setOpenMoneyLkg(BigDecimal openMoneyLkg) {
		this.openMoneyLkg = openMoneyLkg;
	}
	public BigDecimal getHoldMoneyLlg() {
		return holdMoneyLlg;
	}
	public void setHoldMoneyLlg(BigDecimal holdMoneyLlg) {
		this.holdMoneyLlg = holdMoneyLlg;
	}
	public BigDecimal getHoldMoneyLls() {
		return holdMoneyLls;
	}
	public void setHoldMoneyLls(BigDecimal holdMoneyLls) {
		this.holdMoneyLls = holdMoneyLls;
	}
	public BigDecimal getHoldMoneyHkg() {
		return holdMoneyHkg;
	}
	public void setHoldMoneyHkg(BigDecimal holdMoneyHkg) {
		this.holdMoneyHkg = holdMoneyHkg;
	}
	public BigDecimal getHoldMoneyLkg() {
		return holdMoneyLkg;
	}
	public void setHoldMoneyLkg(BigDecimal holdMoneyLkg) {
		this.holdMoneyLkg = holdMoneyLkg;
	}
	public BigDecimal getCloseMoneyLlg() {
		return closeMoneyLlg;
	}
	public void setCloseMoneyLlg(BigDecimal closeMoneyLlg) {
		this.closeMoneyLlg = closeMoneyLlg;
	}
	public BigDecimal getCloseMoneyLls() {
		return closeMoneyLls;
	}
	public void setCloseMoneyLls(BigDecimal closeMoneyLls) {
		this.closeMoneyLls = closeMoneyLls;
	}
	public BigDecimal getCloseMoneyHkg() {
		return closeMoneyHkg;
	}
	public void setCloseMoneyHkg(BigDecimal closeMoneyHkg) {
		this.closeMoneyHkg = closeMoneyHkg;
	}
	public BigDecimal getCloseMoneyLkg() {
		return closeMoneyLkg;
	}
	public void setCloseMoneyLkg(BigDecimal closeMoneyLkg) {
		this.closeMoneyLkg = closeMoneyLkg;
	}
	@Column(length=8)
	public String getIsShowPage() {
		return isShowPage;
	}
	public void setIsShowPage(String isShowPage) {
		this.isShowPage = isShowPage;
	}
	@Column(length=8)
	public String getIsShowUrl() {
		return isShowUrl;
	}
	public void setIsShowUrl(String isShowUrl) {
		this.isShowUrl = isShowUrl;
	}
	@Column(length=8)
	public String getIsSingalService() {
		return isSingalService;
	}
	public void setIsSingalService(String isSingalService) {
		this.isSingalService = isSingalService;
	}
	@Column(length=8)
	public String getIsAccountSeperate() {
		return isAccountSeperate;
	}
	public void setIsAccountSeperate(String isAccountSeperate) {
		this.isAccountSeperate = isAccountSeperate;
	}
	@Column(length=8)
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Double getCloseRate() {
		return closeRate;
	}
	public void setCloseRate(Double closeRate) {
		this.closeRate = closeRate;
	}
	public Double getCloseRateExt() {
		return closeRateExt;
	}
	public void setCloseRateExt(Double closeRateExt) {
		this.closeRateExt = closeRateExt;
	}

	
	
}
