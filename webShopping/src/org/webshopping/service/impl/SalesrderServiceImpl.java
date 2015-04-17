package org.webshopping.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.webshopping.bean.Orderitem;
import org.webshopping.bean.Salesorder;
import org.webshopping.dao.ISalesorderDao;
import org.webshopping.dao.IUserDao;
import org.webshopping.service.ISalesrderService;

public class SalesrderServiceImpl implements ISalesrderService {

	private ISalesorderDao isalesorderDao;
	private IUserDao iuserDao;

	@Override
	public void createSalesorder(String username, Salesorder salesOrder,
			Set<Orderitem> orderItems) {

		salesOrder.setUsers(iuserDao.findUserByID(username));
		salesOrder.setOrderitems(orderItems);
		salesOrder.setBuydate(new Date());
		salesOrder.setStatus(ISalesrderService.NOPROCESS);
		this.isalesorderDao.addOrUpdate(salesOrder);
	}

	@Override
	public List<Salesorder> getAll(String username) {
		
		byte[] name = username.getBytes();
		UUID uuid = UUID.nameUUIDFromBytes(name);
		String userid = uuid.toString();
		userid = userid.replaceAll("-", "");
		
		return isalesorderDao.findAll(userid);
	}

	public void setIsalesorderDao(ISalesorderDao isalesorderDao) {
		this.isalesorderDao = isalesorderDao;
	}

	public void setIuserDao(IUserDao iuserDao) {
		this.iuserDao = iuserDao;
	}

}
