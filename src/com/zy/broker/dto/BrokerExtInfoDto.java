package com.zy.broker.dto;

import java.math.BigDecimal;

import com.zy.broker.entity.BrokerExtInfo;

/**
 * 经纪商数据辅助类
 * 
 * @author Pingan
 * @since  2015年9月1日
 */

public class BrokerExtInfoDto extends BrokerExtInfo{

	private static final long serialVersionUID = 8012307642261852973L;
	public static final String ORDERBY_COMPANYINDEX = "companyIndex";
	
	public static final String ORDERBY_ASC = "asc";						//正序
	public static final String ORDERBY_DESC = "desc";					//倒序
	
	public static final String SLIDE_P_POINTDIFFMIN = "pointDiffMin";	//产品点差查询参数
	public static final String SLIDE_P_OPENMONEY = "openMoney";			//开仓保证金查询参数
	
	public static final String PRODUCT_TYPE_ZERO = "0";
	public static final String PRODUCT_TYPE_ONE = "1";
	public static final String PRODUCT_TYPE_TWO = "2";
	public static final String PRODUCT_TYPE_THREE = "3";
	public static final String PRODUCT_TYPE_FOUR = "4";
	public static final String PRODUCT_TYPE_FIVE = "5";
	
	public static final String PRODUCT_TYPE_LLG = "Llg";				//黄金返佣、白银返佣、港金、  人民币公斤、外汇、原油
	public static final String PRODUCT_TYPE_LLS = "Lls";
	public static final String PRODUCT_TYPE_HKG = "Hkg";
	public static final String PRODUCT_TYPE_LKG = "Lkg";
	public static final String PRODUCT_TYPE_WH = "Wh";
	public static final String PRODUCT_TYPE_YY = "Yy";
	
	private String[] ids;
	private Integer deleteFlag;
	
	private String bkName;
	private String orderP;			//orderByParam		排序字段
	private String orderD;			//orderByDirection	排序方向
	private String exTypeP;			//网站根据经纪商类型查询
	
	private BigDecimal slider1F;		//slide1查询条件起始
	private BigDecimal slider1T;		//slide1查询条件起始
	private BigDecimal slider2F;		//slide1查询条件起始
	private BigDecimal slider2T;		//slide1查询条件起始
	private BigDecimal slider3F;		//slide1查询条件起始
	private BigDecimal slider3T;		//slide1查询条件起始

	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getOrderP() {
		return orderP;
	}
	public void setOrderP(String orderP) {
		this.orderP = orderP;
	}
	public BigDecimal getSlider1F() {
		return slider1F;
	}
	public void setSlider1F(BigDecimal slider1f) {
		slider1F = slider1f;
	}
	public BigDecimal getSlider1T() {
		return slider1T;
	}
	public void setSlider1T(BigDecimal slider1t) {
		slider1T = slider1t;
	}
	public BigDecimal getSlider2F() {
		return slider2F;
	}
	public void setSlider2F(BigDecimal slider2f) {
		slider2F = slider2f;
	}
	public BigDecimal getSlider2T() {
		return slider2T;
	}
	public void setSlider2T(BigDecimal slider2t) {
		slider2T = slider2t;
	}
	public BigDecimal getSlider3F() {
		return slider3F;
	}
	public void setSlider3F(BigDecimal slider3f) {
		slider3F = slider3f;
	}
	public BigDecimal getSlider3T() {
		return slider3T;
	}
	public void setSlider3T(BigDecimal slider3t) {
		slider3T = slider3t;
	}
	public String getOrderD() {
		return orderD;
	}
	public void setOrderD(String orderD) {
		this.orderD = orderD;
	}
	public String getExTypeP() {
		return exTypeP;
	}
	public void setExTypeP(String exTypeP) {
		this.exTypeP = exTypeP;
	}



	
	
}
