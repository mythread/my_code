package org.webshopping.dao;

import java.util.List;

import org.webshopping.bean.Product;

public interface IProductDao {

	public List<Product> findByNew(int maxRow);

	public List<Product> findByParentId(final int cid, final int maxRow,
			final int currentPage);

	public Product findByPid(int pid);
}
