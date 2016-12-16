package com.shop.order.service;

import org.springframework.transaction.annotation.Transactional;

import com.shop.order.dao.OrderDao;
import com.shop.order.vo.Order;

@Transactional
public class OrderService {
	private OrderDao orderDao;


	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public void save(Order order) {
		orderDao.save(order);
		
	}
	
}
