package org.webshopping.bean;

/**
 * Orderitem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Orderitem {

	// Fields

	private Integer oid;
	private Salesorder salesorder;
	private Integer pid;
	private String name;
	private Integer count;
	private Float unitprice;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */
	public Orderitem(Salesorder salesorder, Integer pid, Integer count,
			Float unitprice) {
		this.salesorder = salesorder;
		this.pid = pid;
		this.count = count;
		this.unitprice = unitprice;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Salesorder getSalesorder() {
		return this.salesorder;
	}

	public void setSalesorder(Salesorder salesorder) {
		this.salesorder = salesorder;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}