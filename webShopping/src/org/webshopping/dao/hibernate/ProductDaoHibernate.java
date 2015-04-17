package org.webshopping.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.webshopping.bean.Product;
import org.webshopping.dao.IProductDao;

public class ProductDaoHibernate extends HibernateDaoSupport implements
		IProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByNew(final int maxRow) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s
						.createQuery("from Product as p order by p.pid desc");
				query.setFirstResult(0);
				query.setMaxResults(maxRow);
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByParentId(final int cid, final int maxResults,
			final int firstResult) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s
						.createQuery("from Product as p where p.category.parentid=?");
				query.setInteger(0, cid);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Product findByPid(int pid) {
		Product product = null;
		List list = getHibernateTemplate().find(
				"from Product as p where p.pid=?", pid);
		if (list.size() > 0) {
			product = (Product) list.get(0);
		}
		return product;
	}

}
