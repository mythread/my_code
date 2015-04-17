package org.webshopping.service;

import java.util.List;
import java.util.Set;

import org.webshopping.bean.Orderitem;
import org.webshopping.bean.Salesorder;

public interface ISalesrderService {

	public static int PROCESS = 0;
	public static int NOPROCESS = 1;

	public void createSalesorder(String username, Salesorder so,
			Set<Orderitem> orderItems);

	public List<Salesorder> getAll(String username);
}
