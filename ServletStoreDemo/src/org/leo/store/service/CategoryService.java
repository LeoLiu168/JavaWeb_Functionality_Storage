package org.leo.store.service;

import java.sql.SQLException;
import java.util.List;

import org.leo.store.domain.Category;

public interface CategoryService {

	List<Category> getAllCats() throws SQLException;

}
