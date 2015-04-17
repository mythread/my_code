package com.ibm.etp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.etp.vo.Person;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2010-8-24	IBM			Peng						create
 */
public class OGNLAction extends ActionSupport {
	private String username;
	private String password;
	private Person person = new Person();
	private List<Person> personList = new ArrayList<Person>();
	private Map<String, Person> personMap = new HashMap<String, Person>();

	public String execute() throws Exception {
		Person person = new Person();
		person.setAge("30");
		Person person2 = new Person();
		person2.setAge("31");
		Person person3 = new Person();
		person3.setAge("32");
		Person person4 = new Person();
		person4.setAge("33");
		
		personList.add(person);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		
		personMap.put("p30", person);
		personMap.put("p31", person2);
		personMap.put("p32", person3);
		personMap.put("p33", person4);
		
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public Person getPerson() {
		return person;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public String getUsername() {
		return username;
	}

	public void setAge(String age) {
		person.setAge(age);
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, Person> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, Person> personMap) {
		this.personMap = personMap;
	}

}
