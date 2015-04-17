package org.webshopping.service;

import java.util.List;

import org.webshopping.bean.Category;

public interface ICategoryService {
	/**
	 * ¸ù·ÖÀà
	 */
	public static int CATEGORY_ROOT = 0;

	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Category> findByParentId(int cid);
}
