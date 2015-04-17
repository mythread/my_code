package org.webshopping.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.webshopping.bean.Users;
import org.webshopping.dao.IUserDao;

public class UserDaoHibernate extends HibernateDaoSupport implements IUserDao {

	@Override
	public void addOrUpdateUser(Users user) {
		super.getHibernateTemplate().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findUser(String username, String password) {
		Object[] object = { username, password };
		List list = super.getHibernateTemplate().find(
				"from Users as u where u.username=? and u.password=?", object);
		if (list.size() > 0) {
			return (Users) list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findUserByID(String username) {
		List list = super.getHibernateTemplate().find(
				"from Users as u where u.username=?", username);
		if (list.size() > 0) {
			return (Users) list.get(0);
		}
		return null;
	}

	@Override
	public boolean findUserBySave(String username, String question,
			String answer) {
		Object[] object = { username, question, answer };
		boolean empty = super
				.getHibernateTemplate()
				.find(
						"from Users as u where u.username=? and question=? and u.answer=?",
						object).isEmpty();

		/* 查询结果不为空，返回true */
		return !empty;
	}

	@Override
	public void updatePassword(String username, String password) {
		Object[] object = { password, username };
		super.getHibernateTemplate().bulkUpdate(
				"update Users set password=? where username=?", object);
	}

}
