package com.ibm.etp.hibernate.pojo;

// Generated 2011-8-29 10:59:14 by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Userrole generated by hbm2java
 */
public class Userrole implements java.io.Serializable {

	private Integer roleno;
	private String rolename;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	public Userrole() {
	}

	public Userrole(Integer roleno) {
		this.roleno = roleno;
	}

	public Userrole(Integer roleno, String rolename, Set<Userinfo> userinfos) {
		this.roleno = roleno;
		this.rolename = rolename;
		this.userinfos = userinfos;
	}

	public Integer getRoleno() {
		return this.roleno;
	}

	public void setRoleno(Integer roleno) {
		this.roleno = roleno;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}