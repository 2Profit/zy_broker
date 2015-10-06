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

	private String websiteUrl;				//官网地址
	private String isShowUrl;				//是否显示链接（0-不显示，1-显示）
	private String companyArea;				//公司属地 (0-香港/1-中国/2-台湾/3-其他)
	private String platform;				//交易平台 ,多选项、逗号分隔(0-MT4/1-MT5/2-GTS1/3-GTS2/4-mFinance) 
	private String serviceShape;			//业务形式 (0-代理/1-直销/2-混合)
	private String isSingalService;			//喊单服务(1-提供/0-不提供)
	private String isAccountSeperate;		//帐户分层(1-提供/0-不提供)
	private String companyType;				//公司类型,多选项、逗号分隔 (0-黄金/1-外汇/2-中国A股)
	private String productType;				//产品,多选项、逗号分隔(0-伦敦金/1-伦敦银/2-港金/3-人民币公斤条)
	private String moneyType;				//结算币值(0-美元/1-人民幣/2-港元/3-混合)
	private String pointDiff;				//产品点差 (0-固定/1-浮动)
	
	private Double pointDiffMinLlg;			//产品点差(最低)LLG、LLS、HKG、LKG
	private Double pointDiffMinLls;
	private Double pointDiffMinHkg;
	private Double pointDiffMinLkg;
	
	private Double minTradeNumLlg;			//单次交易手数(最低)LLG、LLS、HKG、LKG
	private Double minTradeNumLls;
	private Double minTradeNumHkg;
	private Double minTradeNumLkg;
	
	private Double maxTradeNumLlg;			//单次交易手数(最高)LLG、LLS、HKG、LKG
	private Double maxTradeNumLls;
	private Double maxTradeNumHkg;
	private Double maxTradeNumLkg;
	private Double maxHoldNum;				//持仓手数上限
	private String isReturnCommission;		//客户回佣 (1-提供/0-不提供)
	
	private BigDecimal commissionEurope;	//欧美返佣、黄金返佣、白银返佣、原油返佣
	private BigDecimal commissionGold;
	private BigDecimal commissionSilver;
	private BigDecimal commissionOil;
	
	private String isTradeCode;				//交易编码(1-提供/0-不提供)
	private String isOpenFee;				//建仓手续费（1-收取/0-不收取）
	private String isCloseFee;				//平仓手续费（1-收 取/0-不收取）
	private Double longRate;				//多仓利息(接受录入负数值, 例如, -1.25%、-0.75%)
	private Double shortRate;				//空仓利息(接受录入负数值, 例如, -1.25%、-0.75%)
	
	private BigDecimal openMoneyLlg;		//开仓保证金(LLG、LLS、HKG、LKG/伦敦金、伦敦银、港金、人民币公斤条)
	private BigDecimal openMoneyLls;
	private BigDecimal openMoneyHkg;
	private BigDecimal openMoneyLkg;
	
	private Double leverRate;			//杠杆比例
	private Double closeRate;			// 強平百分比
	private Double closeRateExt;		//强平百分比——周末/假日
	private String isEaSupport;			//EA支援（0-不支援、1-支援）
	private Integer companyIndex;		//公司推荐值（数字大优先级高）
	private String imageUrl;			//经纪商图标
	
	private Integer imageHeight;//主题图片高
	private Integer imageWidth;//主题图片宽
	
	@Column(length=64)
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	@Column(length=2)
	public String getIsShowUrl() {
		return isShowUrl;
	}
	public void setIsShowUrl(String isShowUrl) {
		this.isShowUrl = isShowUrl;
	}
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
	public Double getMinTradeNumLlg() {
		return minTradeNumLlg;
	}
	public void setMinTradeNumLlg(Double minTradeNumLlg) {
		this.minTradeNumLlg = minTradeNumLlg;
	}
	public Double getMinTradeNumLls() {
		return minTradeNumLls;
	}
	public void setMinTradeNumLls(Double minTradeNumLls) {
		this.minTradeNumLls = minTradeNumLls;
	}
	public Double getMinTradeNumHkg() {
		return minTradeNumHkg;
	}
	public void setMinTradeNumHkg(Double minTradeNumHkg) {
		this.minTradeNumHkg = minTradeNumHkg;
	}
	public Double getMinTradeNumLkg() {
		return minTradeNumLkg;
	}
	public void setMinTradeNumLkg(Double minTradeNumLkg) {
		this.minTradeNumLkg = minTradeNumLkg;
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
	@Column(length=2)
	public String getIsEaSupport() {
		return isEaSupport;
	}
	public void setIsEaSupport(String isEaSupport) {
		this.isEaSupport = isEaSupport;
	}
	public Integer getCompanyIndex() {
		return companyIndex;
	}
	public void setCompanyIndex(Integer companyIndex) {
		this.companyIndex = companyIndex;
	}
	public BigDecimal getCommissionEurope() {
		return commissionEurope;
	}
	public void setCommissionEurope(BigDecimal commissionEurope) {
		this.commissionEurope = commissionEurope;
	}
	public BigDecimal getCommissionGold() {
		return commissionGold;
	}
	public void setCommissionGold(BigDecimal commissionGold) {
		this.commissionGold = commissionGold;
	}
	public BigDecimal getCommissionSilver() {
		return commissionSilver;
	}
	public void setCommissionSilver(BigDecimal commissionSilver) {
		this.commissionSilver = commissionSilver;
	}
	public BigDecimal getCommissionOil() {
		return commissionOil;
	}
	public void setCommissionOil(BigDecimal commissionOil) {
		this.commissionOil = commissionOil;
	}
	@Column(length=64)
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@javax.persistence.Transient
	public Integer getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	@javax.persistence.Transient
	public Integer getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}
	

	
	
	
	
}
