package com.ibm.etp.hibernate.pojo;

// Generated 2011-11-2 22:34:12 by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * TStatus generated by hbm2java
 */
public class TStatus implements java.io.Serializable {

	private String statusId;
	private String statusName;
	private Set<TUser> TUsers = new HashSet<TUser>(0);

	public TStatus() {
	}

	public TStatus(String statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public TStatus(String statusId, String statusName, Set<TUser> TUsers) {
		this.statusId = statusId;
		this.statusName = statusName;
		this.TUsers = TUsers;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Set<TUser> getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set<TUser> TUsers) {
		this.TUsers = TUsers;
	}

}