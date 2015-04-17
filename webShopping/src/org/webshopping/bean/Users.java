package org.webshopping.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Users {

	// Fields

	private String userid;
	private String username;
	private String password;
	private String email;
	private String question;
	private String answer;
	private String phone;
	private String address;
	private Set<Salesorder> salesorders = new HashSet<Salesorder>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userid, String username, String password, String email,
			String question, String answer) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}

	/** full constructor */
	public Users(String userid, String username, String password, String email,
			String question, String answer, String phone, String address,
			Set<Salesorder> salesorders) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.phone = phone;
		this.address = address;
		this.salesorders = salesorders;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Salesorder> getSalesorders() {
		return this.salesorders;
	}

	public void setSalesorders(Set<Salesorder> salesorders) {
		this.salesorders = salesorders;
	}

}