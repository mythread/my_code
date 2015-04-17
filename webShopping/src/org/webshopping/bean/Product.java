package org.webshopping.bean;

/**
 * Product entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Product {

	// Fields

	private Integer pid;
	private Category category;
	private String name;
	private Float unitprice;
	private Float discount;
	private Integer isvisible;
	private Integer status;
	private String picture;
	private String descr;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Category category, String name, Float unitprice,
			Float discount, Integer isvisible, Integer status, String picture) {
		this.category = category;
		this.name = name;
		this.unitprice = unitprice;
		this.discount = discount;
		this.isvisible = isvisible;
		this.status = status;
		this.picture = picture;
	}

	/** full constructor */
	public Product(Category category, String name, Float unitprice,
			Float discount, Integer isvisible, Integer status, String picture,
			String descr) {
		this.category = category;
		this.name = name;
		this.unitprice = unitprice;
		this.discount = discount;
		this.isvisible = isvisible;
		this.status = status;
		this.picture = picture;
		this.descr = descr;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getIsvisible() {
		return this.isvisible;
	}

	public void setIsvisible(Integer isvisible) {
		this.isvisible = isvisible;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}