package org.webshopping.service.impl;

import java.util.List;

import org.webshopping.bean.Category;
import org.webshopping.dao.ICategoryDao;
import org.webshopping.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	private ICategoryDao icategoryDao;

	@Override
	public List<Category> findByParentId(int cid) {
		return icategoryDao.findByParentId(cid);
	}

	public void setIcategoryDao(ICategoryDao icategoryDao) {
		this.icategoryDao = icategoryDao;
	}

}
