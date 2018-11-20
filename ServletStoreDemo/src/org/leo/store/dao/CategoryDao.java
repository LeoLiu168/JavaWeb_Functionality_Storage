package org.leo.store.dao;

import java.sql.SQLException;
import java.util.List;

import org.leo.store.domain.Category;

public interface CategoryDao {

	List<Category> getAllCats() throws SQLException;

}
