package com.etp.stu.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.etp.stu.hibernate.pojo.TUserinfo;
import com.etp.stu.hibernate.util.HibernateSessionFactory;

public class UsermngrDAO {

	public static void save(TUserinfo tUserinfo) {

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		try {

			session.save(tUserinfo);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		} finally {

			HibernateSessionFactory.closeSession();
		}
	}

	public static void update(TUserinfo tUserinfo) {

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.update(tUserinfo);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		} finally {

			HibernateSessionFactory.closeSession();
		}

	}

	public static void delete(TUserinfo tUserinfo) {

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.delete(tUserinfo);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		} finally {

			HibernateSessionFactory.closeSession();
		}

		System.out.println();
	}

	public static List<TUserinfo> select(String userid, String username) {

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		List<TUserinfo> result = null;

		try {
			List list = session.createCriteria(TUserinfo.class).add(
					Restrictions.eq("userid", userid)).add(
					Restrictions.eq("username", username)).list();
			result = list;
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		} finally {

			HibernateSessionFactory.closeSession();
		}
		return result;
	}

	public static TUserinfo select2(String userid) {

		TUserinfo tUserinfo = null;

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			// hql中写得是POJO对象,不是Table名,TUserinfo类和数据库中的T_USERINFO表相对应
			String hql = "from TUserinfo t where t.userid = :userid";

			Query query = session.createQuery(hql);
			query.setString("userid", "zhangsan4");
			tUserinfo = (TUserinfo) query.list().get(0);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return tUserinfo;
	}

	public static List<TUserinfo> select3(TUserinfo tUserinfo) {

		List<TUserinfo> list = null;

		Session session = HibernateSessionFactory.getSession();

		Transaction transaction = session.beginTransaction();

		try {
			String hql = "from TUserinfo t where t.userid like :userid and t.username like :username ";

			Query query = session.createQuery(hql);
			query.setString("userid", "%" + tUserinfo.getUserid() + "%");
			query.setString("username", "%" + tUserinfo.getUsername() + "%");
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}
}
