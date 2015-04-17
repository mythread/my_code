package com.ibm.etp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.common.hibernate.util.HibernateSessionFactory;

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
public class Query1Dao {
	public static List queryByJob(String job) {
		List result = null;
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			String hql = "from Dept d, Emp e where d.deptno = e.dept.deptno and e.job = :job";
			
			Query query = session.createQuery(hql);
			query.setString("job", job);
			
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
