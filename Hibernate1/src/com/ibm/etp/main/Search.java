package com.ibm.etp.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.hibernate.pojo.TSeq;
import com.ibm.etp.hibernate.util.HibernateSessionFactory;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2011, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2011-8-26	IBM			Peng Peng					create
 */
public class Search {
	public static void main(String[] args) {
		
		List tseqs = null;

		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			String hql = "from TSeq where id = :id";
			
			Query query = session.createQuery(hql);
			query.setLong("id", 1000000000162L);
			tseqs = query.list();
			
			
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		
		TSeq seq = (TSeq) tseqs.get(0);
		System.out.println(seq.getName());
		System.out.println(seq.getAaa());

	}
}
