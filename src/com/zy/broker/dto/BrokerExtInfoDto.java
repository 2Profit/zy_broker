package com.zy.broker.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
	
	private Map<String,String> orderByParamMap = new HashMap<String,String>();
	
	//排序箭头保存
	private String arrow_min_income_money;			//最低入金
	private String arrow_profit_star;				//安全评级
	private String arrow_commission_llg;			//返佣比例(黄金返佣)
	private String arrow_is_recommet;				//至盈推荐
	
	private String arrow_is_in_out_free;			//出入金免手续费
	private String arrow_lever_rate;				//最大杠杆 

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
	public Map<String, String> getOrderByParamMap() {
		return orderByParamMap;
	}
	public void setOrderByParamMap(Map<String, String> orderByParamMap) {
		this.orderByParamMap = orderByParamMap;
	}
	public String getArrow_min_income_money() {
		return arrow_min_income_money;
	}
	public void setArrow_min_income_money(String arrow_min_income_money) {
		this.arrow_min_income_money = arrow_min_income_money;
	}
	public String getArrow_profit_star() {
		return arrow_profit_star;
	}
	public void setArrow_profit_star(String arrow_profit_star) {
		this.arrow_profit_star = arrow_profit_star;
	}
	public String getArrow_commission_llg() {
		return arrow_commission_llg;
	}
	public void setArrow_commission_llg(String arrow_commission_llg) {
		this.arrow_commission_llg = arrow_commission_llg;
	}
	public String getArrow_is_recommet() {
		return arrow_is_recommet;
	}
	public void setArrow_is_recommet(String arrow_is_recommet) {
		this.arrow_is_recommet = arrow_is_recommet;
	}
	public String getArrow_is_in_out_free() {
		return arrow_is_in_out_free;
	}
	public void setArrow_is_in_out_free(String arrow_is_in_out_free) {
		this.arrow_is_in_out_free = arrow_is_in_out_free;
	}
	public String getArrow_lever_rate() {
		return arrow_lever_rate;
	}
	public void setArrow_lever_rate(String arrow_lever_rate) {
		this.arrow_lever_rate = arrow_lever_rate;
	}



	
	
}
