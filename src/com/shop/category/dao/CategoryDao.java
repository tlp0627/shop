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

	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	public Category findByCid(Integer cid) {
		String hql ="from Category where cid=?";
		List <Category> list = this.getHibernateTemplate().find(hql,cid);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}
	
}
