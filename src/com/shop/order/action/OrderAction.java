package com.shop.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.cart.vo.Cart;
import com.shop.cart.vo.CartItem;
import com.shop.order.service.OrderService;
import com.shop.order.vo.Order;
import com.shop.order.vo.OrderItem;
import com.shop.user.vo.User;
import com.utlis.PageBean;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private OrderService orderService;
	private Order order = new Order();
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public Order getModel() {
		return order;
	}
	public String saveOrder(){
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			this.addActionMessage("您还没有购物！");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		order.setOrdertime(new Date());
		order.setState(1);
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser == null){
			this.addActionMessage("您还未登录请先登录！");
			return "msg";
		}
		order.setName(existUser.getName());
		order.setAddr(existUser.getAddr());
		order.setPhone(existUser.getPhone());
		order.setUser(existUser);
		for(CartItem cartItem : cart.getCartItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		orderService.save(order);
		cart.clearCart();
		return "saveOrder";
	}
	public String findByUid(){
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		PageBean <Order> pageBean = orderService.findByPageUid(existUser.getUid(),page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUid";
	}
	public String  findByOid(){
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}
}
