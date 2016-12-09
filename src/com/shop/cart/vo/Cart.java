package com.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shop.product.vo.Product;

public class Cart {
	private double total;//总计
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
			map.put(cartItem.getProduct().getPid(), cartItem);
		}
	}
	public Collection<CartItem>  getCartItema (){
		return map.values();
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
