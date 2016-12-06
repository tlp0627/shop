package com.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.product.vo.Product;

public class ProductDao extends HibernateDaoSupport {

	public List<Product> getHotProducts() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdesc"));
		List  list = this.getHibernateTemplate().findByCriteria(criteria, 1, 10);
		return list;
	}

	public List<Product> FinNewProducts() {
			DetachedCriteria criteria =DetachedCriteria.forClass(Product.class);
			criteria.addOrder(Order.desc("pdesc"));
			List  list = this.getHibernateTemplate().findByCriteria(criteria, 1, 10);
		return list;
	}

	public Product findByPid(Integer pid) {
		String hql="from Product where pid=?";
		List <Product> list = this.getHibernateTemplate().find(hql,pid);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
