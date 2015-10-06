package com.zy.broker.dto;

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
	public static final String ORDERBY_ASC = "asc";
	public static final String ORDERBY_DESC = "desc";
	
	private String[] ids;
	private Integer deleteFlag;
	
	private String brokerName;
	private String orderByParam;
	private String orderByDirection;

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
	public String getOrderByParam() {
		return orderByParam;
	}
	public void setOrderByParam(String orderByParam) {
		this.orderByParam = orderByParam;
	}
	public String getOrderByDirection() {
		return orderByDirection;
	}
	public void setOrderByDirection(String orderByDirection) {
		this.orderByDirection = orderByDirection;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	
	
}
