package com.shop.product.service;

import java.util.List;

import com.shop.product.dao.ProductDao;
import com.shop.product.vo.Product;

public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> getHotProducts() {
		return productDao.getHotProducts();
	}
	
}
