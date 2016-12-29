package com.shop.order.adminaction;

import java.util.List;

import org.aspectj.weaver.ast.Or;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.order.service.OrderService;
import com.shop.order.vo.Order;
import com.shop.order.vo.OrderItem;
import com.utlis.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	private OrderService orderService ;
	private Integer page;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	private Order order = new Order();
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public Order getModel() {
		return order;
	}
	// 修改订单状态
	public String updateState(){
		// 根据id查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		// 页面跳转
		return "updateStateSuccess";
	}
	// 根据订单的id查询订单项:
	public String findOrderItem(){
		// 根据订单id查询订单项:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// 显示到页面:
		ActionContext.getContext().getValueStack().set("list", list);
		// 页面跳转
		return "findOrderItem";
	}
	public String findAll(){
		PageBean<Order> pageBean = orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	
}
