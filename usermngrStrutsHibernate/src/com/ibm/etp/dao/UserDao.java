package com.ibm.etp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.etp.common.dao.DBConnection;
import com.ibm.etp.hibernate.pojo.TStatus;
import com.ibm.etp.hibernate.pojo.TUser;
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
 * 1.00		2012-4-10	IBM			zxc					create
 */
public class UserDao {
	public static boolean isUseridAvailable(String userid) {
		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser t where t.userId = :userId";
			Query query = session.createQuery(hql);
			query.setString("userId", userid);

			result = query.list();

			transaction.commit();

			if (result.size() > 0) {
				TUser tUser = (TUser) result.get(0);
				if ("2".equals(tUser.getTStatus().getStatusId())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	public static boolean hasUserid(String userid) {
		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser t where t.userId = :userid";
			Query query = session.createQuery(hql);
			query.setString("userid", userid);

			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

		if (result != null && result.size() > 0) {
			return true;
		}
		return false;
	}

	public static boolean isLogin(String userid, String password) {

		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser t where t.userId = :userid and trim(t.userPwd) = :password";
			Query query = session.createQuery(hql);
			query.setString("userid", userid);
			query.setString("password", password);

			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

		if (result.size() > 0) {
			return true;
		}
		return false;
	}

	public static String getUsername(String userid) {
		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser t where t.userId = :userid";
			Query query = session.createQuery(hql);
			query.setString("userid", userid);

			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		TUser tUser = (TUser) result.get(0);
		return tUser.getUserName();
	}

	public static void setOnline(String userid) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String sql = "update t_user t set t.status_id = '1' where t.user_id = :userid";

			Query query = session.createSQLQuery(sql);
			query.setString("userid", userid);
			query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static TUser getUserinfo(String userid) {
		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser t where t.userId = :userid";
			Query query = session.createQuery(hql);
			query.setString("userid", userid);

			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return (TUser) result.get(0);
	}

	public static List search(String userid, String username) {
		List result = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "from TUser tu, TStatus ts where ts.statusId = tu.TStatus.statusId and tu.userId like :userid and tu.userName like :username";
			Query query = session.createQuery(hql);
			query.setString("userid", "%" + userid + "%");
			query.setString("username", "%" + username + "%");

			result = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public static void logout(String userid) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String sql = "update t_user t set t.status_id = '2' where t.user_id = :userid";
			Query query = session.createSQLQuery(sql);
			query.setString("userid", userid);
			query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static void logoutall() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String sql = "update t_user set status_id = '2' where status_id = '1'";

			Query query = session.createSQLQuery(sql);
			query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static void useredit(String userid, String username,
			String password, String email) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "update TUser t set t.userName = :username, t.userPwd = :password, t.userMailaddress = :email where t.userId = :userid";

			Query query = session.createQuery(hql);
			query.setString("userid", userid);
			query.setString("username", username);
			query.setString("password", password);
			query.setString("email", email);
			query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static void userreg(String userid, String username, String password,
			String email) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			TStatus status = (TStatus) session.load(TStatus.class, "1");

			TUser tUser = new TUser(userid, status, username, password, email);

			session.save(tUser);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
	
	public static void userDelete(String userid) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			String hql = "delete TUser t where t.userId = :userid";

			Query query = session.createQuery(hql);
			query.setString("userid", userid);

			query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
