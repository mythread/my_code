package com.ibm.etp.main;

import javax.security.auth.login.FailedLoginException;

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
public class Insert {
	public static void main(String[] args) {
		TSeq seq = new TSeq();
		seq.setName("fjodsjf");
		seq.setAaa("fdsoif");
		seq.setId(479823749827L);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(seq);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
//			HibernateSessionFactory.closeSession();
			session.close();
		}
	}
}
