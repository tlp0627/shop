package com.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shop.order.dao.OrderDao;
import com.shop.order.vo.Order;
import com.utlis.PageBean;

@Transactional
public class OrderService {
	private OrderDao orderDao;


	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public void save(Order order) {
		orderDao.save(order);
		
	}


	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		int limit = 4;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		int totalCount = 0;
		totalCount = orderDao.findCountUid(uid);
		pageBean.setTotalCount(totalCount);
		// ÉèÖÃ×ÜÒ³Êý:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List <Order> list= orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}


	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}
	
}
