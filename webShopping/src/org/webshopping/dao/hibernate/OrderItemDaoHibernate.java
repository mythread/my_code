package org.webshopping.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.webshopping.bean.Orderitem;
import org.webshopping.dao.IOrderItemDao;

public class OrderItemDaoHibernate extends HibernateDaoSupport implements
		IOrderItemDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderitem> findAllBySoid(int soid) {

		return super.getHibernateTemplate().find(
				"from Orderitem as o where o.salesorder.soid=?", soid);
	}

}
