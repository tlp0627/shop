package com.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.product.vo.Product;
import com.utlis.PageHibernateCallback;

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

	public int findCountCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid = ?";
		List <Long>list = this.getHibernateTemplate().find(hql,cid);
		 if(list !=null && list.size()>0){
			 return list.get(0).intValue();
		 }
		return 0;
	}

	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select * from Product p join p.categorySecond cs join cs.category c where c.cid =?";
		List <Product> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql,new Object [] {cid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}
