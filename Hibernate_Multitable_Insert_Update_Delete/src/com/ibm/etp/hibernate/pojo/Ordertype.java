package com.ibm.etp.hibernate.pojo;

// Generated 2011-8-30 15:23:25 by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Ordertype generated by hbm2java
 */
public class Ordertype implements java.io.Serializable {

	private Integer typeno;
	private String typename;
	private Set<Orderinfo> orderinfos = new HashSet<Orderinfo>(0);

	public Ordertype() {
	}

	public Ordertype(Integer typeno) {
		this.typeno = typeno;
	}

	public Ordertype(Integer typeno, String typename, Set<Orderinfo> orderinfos) {
		this.typeno = typeno;
		this.typename = typename;
		this.orderinfos = orderinfos;
	}

	public Integer getTypeno() {
		return this.typeno;
	}

	public void setTypeno(Integer typeno) {
		this.typeno = typeno;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set<Orderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<Orderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

}
