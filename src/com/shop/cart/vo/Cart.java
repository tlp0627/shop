package com.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shop.product.vo.Product;

public class Cart implements Serializable {
	private double total;//总计
	public double getTotal() {
		return total;
	}
	//用于存储购物项，Map是为了方便取
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//添加购物项
	public void addCart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		//如果map中已经包含了该CartItem项的情况
		if(map.containsKey(pid)){
			CartItem _carCartItem = map.get(pid);
			cartItem.setCount(cartItem.getCount()+_carCartItem.getCount());
		}
		//如果map中未包含的情况
		else {
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}
	public void delCart(Integer pid){
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	public Collection<CartItem>  getCartItems (){
		return map.values();
	}

	public void setTotal(double total) {
		this.total = total;
	}
	//清空购物车
	public void clearCart(){
		map.clear();
		total = 0;
	}
}
