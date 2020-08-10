package com.ismail.kocfinansproje.entity;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CREDIT_APPLICATION")
public class CreditApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name="IDENTITY_NO")
	private String identityNo;
	@Column(name = "APPLICATION_TIME")
	private Timestamp applicationTime;
	@Column(name="IS_SUCCESS")
	private String isSuccess;
	@Column(name ="ASSIGNED_LIMIT")
	private int assignedLimit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getAssignedLimit() {
		return assignedLimit;
	}
	public void setAssignedLimit(int assignedLimit) {
		this.assignedLimit = assignedLimit;
	}
	
}
