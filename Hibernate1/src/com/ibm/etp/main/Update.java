package com.ibm.etp.main;

import java.sql.SQLException;

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
public class Update {
	public static void main(String[] args) {
		TSeq seq = new TSeq();
		seq.setName("张三");
		seq.setAaa("fdsoif");
		seq.setId(479823749827L);

		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(seq);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}
}
