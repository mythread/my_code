package org.webshopping.dao;

import java.util.List;

import org.webshopping.bean.Orderitem;

public interface IOrderItemDao {

	public List<Orderitem> findAllBySoid(int soid);
}
