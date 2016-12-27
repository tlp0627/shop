package com.shop.categorysecond.service;

import java.util.List;

import com.shop.categorysecond.dao.CategorySecondDao;
import com.shop.categorysecond.vo.CategorySecond;
import com.utlis.PageBean;

public class CategorySecondService {
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount%limit ==0){
			totalPage = totalCount/limit;
		}
		else {
			totalPage = totalCount/limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List <CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	public CategorySecond finByCsid(Integer csid) {
		
		return categorySecondDao.findByCsid(csid);
	}

	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
}
