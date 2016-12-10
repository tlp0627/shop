package com.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.cart.vo.Cart;
import com.shop.cart.vo.CartItem;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;

public class CartAction extends ActionSupport {
		private ProductService productService;
		private Integer pid;
		private Integer count;
		

		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}
		// 我的购物车:执行的方法
		public String myCart(){
			return "myCart";
		}
		//添加商品
		public String addCart(){
			Cart cart = getCart();
			CartItem cartItem =new CartItem();
			Product product = productService.findByPid(pid);
			cartItem.setProduct(product);
			cartItem.setCount(count);
			cart.addCart(cartItem);
			return "addCart";
		}
		// 删除购物项的执行的方法:
		public String removeCart(){
			Cart cart = getCart();
			cart.delCart(pid);
			return "removeCart";
		}
		// 清空购物车的执行的方法:
		public String clearCart(){
			// 获得购物车对象.
			Cart cart = getCart();
			// 调用购物车中清空方法.
			cart.clearCart();
			return "clearCart";
		}
		//单例获得sesson中的购物车对象
		private Cart getCart(){
			Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
			if(cart == null){
				cart = new Cart();
				ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
			}
			return cart;
		}
		
}
