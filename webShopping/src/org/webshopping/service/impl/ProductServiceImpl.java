package org.webshopping.service.impl;

import java.util.List;

import org.webshopping.bean.Product;
import org.webshopping.dao.IProductDao;
import org.webshopping.service.IProductService;

public class ProductServiceImpl implements IProductService {
	private IProductDao iproductDao;

	@Override
	public List<Product> getNewProducts(int maxRow) {
		return iproductDao.findByNew(maxRow);
	}

	@Override
	public List<Product> getProducts(int cid, int maxRow, int currentPage) {
		int firstResult = (currentPage - 1) * maxRow;
		int maxResults = maxRow;
		return iproductDao.findByParentId(cid, maxResults, firstResult);
	}

	@Override
	public Product getProduct(int pid) {
		Product product = iproductDao.findByPid(pid);
		if (product == null) {
			product = new Product();
		}
		return product;
	}

	public void setIproductDao(IProductDao iproductDao) {
		this.iproductDao = iproductDao;
	}
}
