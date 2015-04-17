package com.ibm.etp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.hibernate.pojo.Goodsinfo;
import com.ibm.etp.hibernate.pojo.Goodstype;
import com.ibm.etp.hibernate.pojo.Userrole;
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
 * 1.00		2012-4-9	IBM			zxc					create
 */
public class Dao2 {
	/*
	 * 对Goodsinfo & Goodstype
	 */
	
	public static void insert(int goodsno, String goodsname, String goodsdesc, int goodsTypeNo) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			// 为了创建goodsinfo，需要goodstype
			Goodstype goodstype = (Goodstype) session.get(Goodstype.class, goodsTypeNo);
			
			Goodsinfo goodsinfo = new Goodsinfo(goodsno, goodstype, goodsname, goodsdesc, null);
			
			session.save(goodsinfo);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	public static void update(int goodsno, String goodsname, String goodsdesc) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();

			// 修改之前先查询
			Goodsinfo goodsinfo = (Goodsinfo) session.get(Goodsinfo.class, goodsno);
			
			goodsinfo.setGoodsdesc(goodsdesc);
			goodsinfo.setGoodsname(goodsname);
			
			session.update(goodsinfo);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
	}
	
	public static void delete(int goodsno) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null; 
		try {
			tx = session.beginTransaction();
			
			Goodsinfo goodsinfo = new Goodsinfo();
			goodsinfo.setGoodsno(goodsno);
			
			session.delete(goodsinfo);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
	}
}
