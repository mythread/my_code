package com.ibm.etp.hibernate.main;

import com.ibm.etp.hibernate.dao.Dao3;

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
public class Main3 {
	public static void main(String[] args) {
		
		//==================================
		// 以下是调用DAO3第一个方法
		//==================================
//		int orderno = 101;
//		int ordertypeno = 1;
//		int userno = 1;
//		int[] goodsnos = new int[] {1, 2};
//		int[] prices = new int[] {4332, 2983};
//		int[] amounts = new int[] {10, 5};
		
//		Dao3.newOrder(orderno, ordertypeno, userno, goodsnos, amounts, prices);
		
		
		//==================================
		// 以下是调用DAO3第二个方法
		//==================================
		Dao3.modifyOrder();
		
	}
}
