package com.ibm.etp.main;

import java.util.List;

import com.ibm.etp.common.hibernate.pojo.Dept;
import com.ibm.etp.common.hibernate.pojo.Emp;
import com.ibm.etp.dao.Query1Dao;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-4-7	IBM			zxc					create
 */
public class Main1 {
	public static void main(String[] args) {
		List list = Query1Dao.queryByJob("CLERK");

		for (int i = 0; i < list.size(); i++) {
			Object[] objects = (Object[]) list.get(i);
			Dept dept = (Dept) objects[0];
			Emp emp = (Emp) objects[1];
			System.out.println("ename:" + emp.getEname() + "\tdname:" + dept.getDname());
		}
	
	}
}
