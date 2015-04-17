package com.ibm.etp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.hibernate.util.HibernateSessionFactory;

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
public class Query1 {
	public static List query(String uname) {
		List result = null;
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			String hql = "  from Goodsinfo gi, Goodstype gt, Ordergoods og, Orderinfo oi, Ordertype ot, Userinfo ui, Userrole ur where gt.goodstypeno = gi.goodstype.goodstypeno and gi.goodsno = og.goodsinfo.goodsno and oi.orderno = og.orderinfo.orderno and ot.typeno = oi.ordertype.typeno and ui.uno = oi.userinfo.uno and ur.roleno = ui.userrole.roleno and ui.uname = :uname";
			
			Query query = session.createQuery(hql);
			query.setString("uname", uname);
			
			result = query.list();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

}
