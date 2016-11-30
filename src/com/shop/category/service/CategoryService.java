package com.shop.category.service;

import java.util.List;

import com.shop.category.dao.CategoryDao;
import com.shop.category.vo.Category;


public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> getCategoryAll() {
		
		return categoryDao.getCategoryAll();
	}
}
