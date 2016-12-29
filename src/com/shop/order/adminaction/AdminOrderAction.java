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
	// �޸Ķ���״̬
	public String updateState(){
		// ����id��ѯ����
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		// ҳ����ת
		return "updateStateSuccess";
	}
	// ���ݶ�����id��ѯ������:
	public String findOrderItem(){
		// ���ݶ���id��ѯ������:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// ��ʾ��ҳ��:
		ActionContext.getContext().getValueStack().set("list", list);
		// ҳ����ת
		return "findOrderItem";
	}
	public String findAll(){
		PageBean<Order> pageBean = orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	
}
