package com.mslsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_portal")
public class SmsPortal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tran_id")
	private long tranId;
	private String clientTranId;
	private String msisdn;
	private String msgbody;
	
	
	
//	public SmsPortal() {
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long nextId) {
		this.tranId = nextId;
	}

	public String getClientTranId() {
		return clientTranId;
	}

	public void setClientTranId(String clientTranId) {
		this.clientTranId = clientTranId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsgbody() {
		return msgbody;
	}

	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}

	@Override
	public String toString() {
		return "SmsPortal{id=" + id + ", tranId=" + tranId + ", clientTranId=" + clientTranId + ", msisdn=" + msisdn
				+ ", msgbody=" + msgbody + "}";
	}
	
	
	
}
