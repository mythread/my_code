package org.webshopping.service;

import java.util.List;

import org.webshopping.bean.Orderitem;

public interface IOrderItemService {
	public List<Orderitem> getAllItems(int soid);
}
