package com.ibm.etp.hibernate.main;

import com.ibm.etp.hibernate.dao.Dao1;
import com.ibm.etp.hibernate.pojo.Userrole;

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
 * 1.00		2012-4-9	IBM			zxc					create
 */
public class Main1 {
	public static void main(String[] args) {
		// 1. 插入
		Dao1.insert(3, "供应商");
		
		// 2. 修改，需要自定义一个pojo对象
//		Userrole userrole = new Userrole();
//		userrole.setRoleno(2);
//		userrole.setRolename("普通客户");
//		Dao1.update(userrole);
		
		// 3. 删除
//		Dao1.delete(3);
		
	}
}
