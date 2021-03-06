package com.ibm.etp.hibernate.pojo;

// Generated 2011-8-30 15:23:25 by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo implements java.io.Serializable {

	private Integer uno;
	private Userrole userrole;
	private String uname;
	private Integer age;
	private Set<Orderinfo> orderinfos = new HashSet<Orderinfo>(0);

	public Userinfo() {
	}

	public Userinfo(Integer uno) {
		this.uno = uno;
	}

	public Userinfo(Integer uno, Userrole userrole, String uname, Integer age,
			Set<Orderinfo> orderinfos) {
		this.uno = uno;
		this.userrole = userrole;
		this.uname = uname;
		this.age = age;
		this.orderinfos = orderinfos;
	}

	public Integer getUno() {
		return this.uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Orderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<Orderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

}
