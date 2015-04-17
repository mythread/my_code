package org.webshopping.dao;

import java.util.List;

import org.webshopping.bean.Category;

public interface ICategoryDao {

	public List<Category> findByParentId(int cid);
}
