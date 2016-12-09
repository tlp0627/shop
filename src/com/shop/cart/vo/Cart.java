package com.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shop.product.vo.Product;

public class Cart {
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	public Collection<CartItem>  getCartItema (){
		return map.values();
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	private double total;
}
