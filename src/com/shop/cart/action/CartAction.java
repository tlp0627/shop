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
		// �ҵĹ��ﳵ:ִ�еķ���
		public String myCart(){
			return "myCart";
		}
		//�����Ʒ
		public String addCart(){
			Cart cart = getCart();
			CartItem cartItem =new CartItem();
			Product product = productService.findByPid(pid);
			cartItem.setProduct(product);
			cartItem.setCount(count);
			cart.addCart(cartItem);
			return "addCart";
		}
		// ɾ���������ִ�еķ���:
		public String removeCart(){
			Cart cart = getCart();
			cart.delCart(pid);
			return "removeCart";
		}
		// ��չ��ﳵ��ִ�еķ���:
		public String clearCart(){
			// ��ù��ﳵ����.
			Cart cart = getCart();
			// ���ù��ﳵ����շ���.
			cart.clearCart();
			return "clearCart";
		}
		//�������sesson�еĹ��ﳵ����
		private Cart getCart(){
			Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
			if(cart == null){
				cart = new Cart();
				ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
			}
			return cart;
		}
		
}
