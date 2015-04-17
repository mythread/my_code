package com.ibm.etp.main;

import java.util.List;

import com.ibm.etp.dao.UserinfoDAO;
import com.ibm.etp.hibernate.pojos.Userinfo;


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
 * 1.00		2011-5-9	IBM			Peng Peng					create
 */
public class TestMainSearch {
	public static void main(String[] args) {
		List<Userinfo> list = UserinfoDAO.search("zs");
		System.out.println(list.size());
	}
}
