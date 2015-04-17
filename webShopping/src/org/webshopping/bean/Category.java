package org.webshopping.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category {

	// Fields

	private Integer cid;
	private String name;
	private String descr;
	private Integer parentid;
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String name, Integer parentid) {
		this.name = name;
		this.parentid = parentid;
	}

	/** full constructor */
	public Category(String name, String descr, Integer parentid, Set<Product> products) {
		this.name = name;
		this.descr = descr;
		this.parentid = parentid;
		this.products = products;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}