package com.shop.category.service;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

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

	public void save(Category category) {
		categoryDao.save(category);
	}

	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	public void update(Category category) {
		categoryDao.update(category);
	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}
}
