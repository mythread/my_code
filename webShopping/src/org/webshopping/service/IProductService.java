package org.webshopping.service;

import java.util.List;

import org.webshopping.bean.Product;

public interface IProductService {
	public static int MAX_ROW = 5;
	
	public static int CURRENT_PAGE = 1;

	public List<Product> getNewProducts(int maxRow);

	public List<Product> getProducts(int cid, int maxResults, int firstResult);

	public Product getProduct(int pid);
}
