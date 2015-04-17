package com.ibm.etp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.etp.vo.Personinfo;
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
public class ShowAllAction extends ActionSupport {
	private String username;
	private String province_select;
	private String province_radio;
	private String[] province;
	
	private List<Personinfo> personinfoList = new ArrayList<Personinfo>();
	
	private Map<String, String> checkboxMap = new HashMap<String, String>();

	public String execute() throws Exception {
		Personinfo personinfo1 = new Personinfo("zhangsan", "张三", "zhangsan@163.com", 18);
		Personinfo personinfo2 = new Personinfo("lisi", "李四", "lisi@163.com", 16);
		Personinfo personinfo3 = new Personinfo("wanger", "王二", "wanger@163.com", 30);
		
		personinfoList.add(personinfo1);
		personinfoList.add(personinfo2);
		personinfoList.add(personinfo3);
		
		checkboxMap.put("jiangsu", "江苏");
		checkboxMap.put("anhui", "安徽");
		checkboxMap.put("shanghai", "上海");
		
		province_select = "shanghai";
		province_radio = "anhui";
		province = new String[]{"jiangsu", "shanghai"};
		
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Personinfo> getPersoninfoList() {
		return personinfoList;
	}

	public void setPersoninfoList(List<Personinfo> personinfoList) {
		this.personinfoList = personinfoList;
	}

	public Map<String, String> getCheckboxMap() {
		return checkboxMap;
	}

	public void setCheckboxMap(Map<String, String> checkboxMap) {
		this.checkboxMap = checkboxMap;
	}

	public String getProvince_select() {
		return province_select;
	}

	public void setProvince_select(String province_select) {
		this.province_select = province_select;
	}

	public String getProvince_radio() {
		return province_radio;
	}

	public void setProvince_radio(String province_radio) {
		this.province_radio = province_radio;
	}

	public String[] getProvince() {
		return province;
	}

	public void setProvince(String[] province) {
		this.province = province;
	}


}
