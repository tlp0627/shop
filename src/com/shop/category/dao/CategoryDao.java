package com.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.category.vo.Category;


public class CategoryDao extends HibernateDaoSupport{

	public List<Category> getCategoryAll() {
		String hql = "from Category";
		List <Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
}
