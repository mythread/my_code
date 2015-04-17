package org.webshopping.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.webshopping.bean.Salesorder;
import org.webshopping.dao.ISalesorderDao;

public class SalesorderHibernate extends HibernateDaoSupport implements
		ISalesorderDao {

	@Override
	public void addOrUpdate(Salesorder salesOrder) {
		super.getHibernateTemplate().saveOrUpdate(salesOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salesorder> findAll(String userid) {

		return super.getHibernateTemplate().find(
				"from Salesorder as s where s.users.userid=?", userid);
	}

}
