package org.leo.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.leo.store.dao.CategoryDao;
import org.leo.store.dao.impl.CategoryDaoImp;
import org.leo.store.domain.Category;
import org.leo.store.service.CategoryService;

public class CategoryServiceImp implements CategoryService {

	@Override
	public List<Category> getAllCats() throws SQLException {
		CategoryDao CategoryDao=new CategoryDaoImp();
		return CategoryDao.getAllCats();
	}

}
