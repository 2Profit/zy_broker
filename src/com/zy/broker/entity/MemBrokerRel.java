package com.zy.broker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.member.entity.Member;

/**
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "mem_broker_rel")
public class MemBrokerRel extends BaseEntity{

	private static final long serialVersionUID = 8878574411146721128L;

	private Member member;
	
	private BrokerInfo brokerInfo;

	private String mt4Card;					//MT4账号
	
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

	@Column(name="mt4_card", length=64)
	public String getMt4Card() {
		return mt4Card;
	}

	public void setMt4Card(String mt4Card) {
		this.mt4Card = mt4Card;
	}
	
}
