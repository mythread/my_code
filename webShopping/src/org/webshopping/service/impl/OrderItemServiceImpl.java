package org.webshopping.service.impl;

import java.util.List;

import org.webshopping.bean.Orderitem;
import org.webshopping.dao.IOrderItemDao;
import org.webshopping.service.IOrderItemService;

public class OrderItemServiceImpl implements IOrderItemService {

	private IOrderItemDao iorderItemDao;

	@Override
	public List<Orderitem> getAllItems(int soid) {

		return this.iorderItemDao.findAllBySoid(soid);
	}

	public void setIorderItemDao(IOrderItemDao iorderItemDao) {
		this.iorderItemDao = iorderItemDao;
	}
}
