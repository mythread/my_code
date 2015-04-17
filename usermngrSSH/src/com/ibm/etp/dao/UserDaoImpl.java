package com.ibm.etp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ibm.etp.hibernate.pojo.TStatus;
import com.ibm.etp.hibernate.pojo.TUser;

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
 * 1.00		2012-4-12	IBM			zxc					create
 */

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	public boolean findIsUseridAvailable(String userid) {
		List result = null;
		Session session = this.getSession();

		String hql = "from TUser t where t.userId = :userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userid);

		result = query.list();

		if (result.size() > 0) {
			TUser tUser = (TUser) result.get(0);
			if ("2".equals(tUser.getTStatus().getStatusId())) {
				return true;
			}
		}
		return false;
	}

	public boolean findUserid(String userid) {
		List result = null;
		Session session = this.getSession();

		String hql = "from TUser t where t.userId = :userid";
		Query query = session.createQuery(hql);
		query.setString("userid", userid);

		result = query.list();

		if (result != null && result.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean findIsLogin(String userid, String password) {
		List result = null;
		Session session = this.getSession();

		String hql = "from TUser t where t.userId = :userid and trim(t.userPwd) = :password";
		Query query = session.createQuery(hql);
		query.setString("userid", userid);
		query.setString("password", password);

		result = query.list();

		if (result.size() > 0) {
			return true;
		}
		return false;
	}

	public String getUsername(String userid) {
		List result = null;
		Session session = this.getSession();

		String hql = "from TUser t where t.userId = :userid";
		Query query = session.createQuery(hql);
		query.setString("userid", userid);

		result = query.list();
		TUser tUser = (TUser) result.get(0);
		return tUser.getUserName();
	}

	public void updateOnline(String userid) {
		Session session = this.getSession();

		String sql = "update t_user t set t.status_id = '1' where t.user_id = :userid";

		Query query = session.createSQLQuery(sql);;
		query.setString("userid", userid);
		query.executeUpdate();
	}

	public TUser getUserinfo(String userid) {
		List result = null;
		Session session = this.getSession();
		String hql = "from TUser t where t.userId = :userid";
		Query query = session.createQuery(hql);
		query.setString("userid", userid);

		result = query.list();
		return (TUser) result.get(0);
	}

	public List getAll(String userid, String username) {
		List result = null;
		Session session = this.getSession();

		String hql = "from TUser tu, TStatus ts where ts.statusId = tu.TStatus.statusId and tu.userId like :userid and tu.userName like :username";
		Query query = session.createQuery(hql);
		query.setString("userid", "%" + userid + "%");
		query.setString("username", "%" + username + "%");

		result = query.list();
		return result;
	}

	public void updateLogoutStatus(String userid) {		
		
		Session session = this.getSession();

		String sql = "update t_user t set t.status_id = '2' where t.user_id = :userid";
		Query query = session.createSQLQuery(sql);
		query.setString("userid", userid);
		query.executeUpdate();
	}

	public void updateLogoutall() {
		Session session = this.getSession();

		String sql = "update t_user set status_id = '2' where status_id = '1'";

		Query query = session.createSQLQuery(sql);
		query.executeUpdate();

	}

	public void updateUser(String userid, String username, String password,
			String email) {
		Session session = this.getSession();

		String hql = "update TUser t set t.userName = :username, t.userPwd = :password, t.userMailaddress = :email where t.userId = :userid";

		Query query = session.createQuery(hql);
		query.setString("userid", userid);
		query.setString("username", username);
		query.setString("password", password);
		query.setString("email", email);
		query.executeUpdate();

	}

	public void insertUserreg(String userid, String username, String password,
			String email) {
		Session session = this.getSession();
		TStatus status = (TStatus) session.load(TStatus.class, "1");

		TUser tUser = new TUser(userid, status, username, password, email);

		session.save(tUser);
	}

}
