package com.ibm.etp.main;

import java.util.List;

import com.ibm.etp.dao.SQLQuery2;

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
public class Main2 {
	public static void main(String[] args) {
		List list = SQLQuery2.query();
		System.out.println(list.size());
	}
}
