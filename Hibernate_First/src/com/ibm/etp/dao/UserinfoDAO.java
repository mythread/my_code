package com.ibm.etp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.hibernate.pojos.Userinfo;
import com.ibm.etp.hibernate.util.HibernateSessionFactory;

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
public class UserinfoDAO {
	public static void executeUpdate(Userinfo userinfo) {
		// 1. 获得连接
		Session session = HibernateSessionFactory.getSession();
		
		// 2. 创建回滚点
		Transaction tx = session.beginTransaction();
		
		// 3. 执行增删改
		session.saveOrUpdate(userinfo);
		
		// 4. 提交
		tx.commit();
		
		// 5. 关闭连接
		session.close();
		
	}
	
	public static List<Userinfo> search(String userid) {
		// 1. 创建连接
		Session session = HibernateSessionFactory.getSession();
		
		// 2. 执行查询HQL
		Query query = session.createQuery("from Userinfo u where u.userid = :userid");
		
		// 3. 放入参数
		query.setString("userid", userid);
		
		// 4. 执行查询
		List list = query.list();
		
		// 5. 提交查询
		session.beginTransaction().commit();
		
		// 6. 关闭连接
		session.close();
		
		return list;
		
	}
	
	public static void delete(Userinfo userinfo) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(userinfo);
		transaction.commit();
		session.close();
	}
}
