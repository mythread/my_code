package org.webshopping.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.webshopping.bean.Category;
import org.webshopping.dao.ICategoryDao;

public class CategoryDaoHibernate extends HibernateDaoSupport implements
		ICategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByParentId(int cid) {
		List<Category> list = super.getHibernateTemplate().find(
				"from Category as c where c.parentid=?", cid);
		return list;
	}

}
