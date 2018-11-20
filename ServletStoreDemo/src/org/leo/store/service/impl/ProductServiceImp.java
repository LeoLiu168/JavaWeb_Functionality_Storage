package org.leo.store.service.impl;

import java.util.List;

import org.leo.store.dao.ProductDao;
import org.leo.store.dao.impl.ProductDaoImp;
import org.leo.store.domain.Product;
import org.leo.store.service.ProductService;

public class ProductServiceImp implements ProductService {
	
	ProductDao ProductDao=new ProductDaoImp();
	
	@Override
	public Product findProductByPid(String pid) throws Exception {
		return ProductDao.findProductByPid(pid);
		
	}

	@Override
	public List<Product> findHots() throws Exception {
		return ProductDao.findHots();
	}

	@Override
	public List<Product> findNews() throws Exception {
		return ProductDao.findNews();
	}

}
