package org.webshopping.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Salesorder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Salesorder {

	// Fields

	private Integer soid;
	private Users users;
	private Date buydate;
	private String address;
	private String phone;
	private Integer status;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	// Constructors

	/** default constructor */
	public Salesorder() {
	}

	/** minimal constructor */
	public Salesorder(Users users, Date buydate, String address, String phone,
			Integer status) {
		this.users = users;
		this.buydate = buydate;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}

	/** full constructor */
	public Salesorder(Users users, Date buydate, String address, String phone,
			Integer status, Set<Orderitem> orderitems) {
		this.users = users;
		this.buydate = buydate;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getSoid() {
		return this.soid;
	}

	public void setSoid(Integer soid) {
		this.soid = soid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getBuydate() {
		return this.buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

}