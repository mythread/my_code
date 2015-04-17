package com.ibm.etp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
public class SQLQuery2 {
	public static List query() {
		List result = null;
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			String sql = "select * from userinfo,   userrole where userrole.roleno = userinfo.roleno";
			
			SQLQuery query = session.createSQLQuery(sql);
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
