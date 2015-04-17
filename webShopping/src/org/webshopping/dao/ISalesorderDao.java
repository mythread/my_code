package org.webshopping.dao;

import java.util.List;

import org.webshopping.bean.Salesorder;

public interface ISalesorderDao {
	public void addOrUpdate(Salesorder salesOrder);

	public List<Salesorder> findAll(String userid);
}
