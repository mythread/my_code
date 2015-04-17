package com.ibm.etp.hibernate.pojo;

// Generated 2011-11-2 22:34:12 by Hibernate Tools 3.3.0.GA

/**
 * TUser generated by hbm2java
 */
public class TUser implements java.io.Serializable {

	private String userId;
	private TStatus TStatus;
	private String userName;
	private String userPwd;
	private String userMailaddress;

	public TUser() {
	}

	public TUser(String userId, String userName, String userPwd) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public TUser(String userId, TStatus TStatus, String userName,
			String userPwd, String userMailaddress) {
		this.userId = userId;
		this.TStatus = TStatus;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userMailaddress = userMailaddress;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TStatus getTStatus() {
		return this.TStatus;
	}

	public void setTStatus(TStatus TStatus) {
		this.TStatus = TStatus;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserMailaddress() {
		return this.userMailaddress;
	}

	public void setUserMailaddress(String userMailaddress) {
		this.userMailaddress = userMailaddress;
	}

}
