package org.leo.store.dao;

import java.util.List;

import org.leo.store.domain.Product;

public interface ProductDao {

	Product findProductByPid(String pid) throws Exception;

	List<Product> findHots() throws Exception;

	List<Product> findNews() throws Exception;

}
