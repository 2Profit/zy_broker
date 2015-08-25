package com.zy.broker.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.member.entity.Member;

/**
 * ���������۱�
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "mem_broker_comment")
public class MemBrokerComment extends BaseEntity {

	private static final long serialVersionUID = -3099664556860510313L;

	private Member member;

	private BrokerInfo brokerInfo;

	@ManyToOne
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne
	@JoinColumn(name = "broker_info_id")
	public BrokerInfo getBrokerInfo() {
		return brokerInfo;
	}

	public void setBrokerInfo(BrokerInfo brokerInfo) {
		this.brokerInfo = brokerInfo;
	}

	

}
