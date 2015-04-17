package com.ibm.etp.main;

import java.util.List;

import com.ibm.etp.dao.Query1;
import com.ibm.etp.hibernate.pojo.Goodsinfo;
import com.ibm.etp.hibernate.pojo.Userinfo;

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
		List list = Query1.query("张三");
		Object[] objects = (Object[]) list.get(0);
		Goodsinfo goodsinfo = (Goodsinfo) objects[0];
		System.out.println(list.size());
		System.out.println(goodsinfo.getGoodsname());
		System.out.println("username:" + ((Userinfo) objects[5]).getUname()
				+ "\tuserrole:"
				+ ((Userinfo) objects[5]).getUserrole().getRolename());
	}
}
