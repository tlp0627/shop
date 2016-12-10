package com.shop.cart.vo;

import java.io.Serializable;

import com.shop.product.vo.Product;

public class CartItem implements Serializable {
	private Product product;
	private int count;
	private double subtotal;
	public double getSubtotal() {
		return product.getShop_price()*count;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
