package com.zy.broker.dto;

/**
 * 经纪商数据辅助类
 * 
 * @author Pingan
 * @since  2015年9月1日
 */

public class BrokerExtInfoDto {

	private String[] ids;
	private Integer deleteFlag;

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
	
	
}
