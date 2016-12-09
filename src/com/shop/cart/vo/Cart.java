package com.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shop.product.vo.Product;

public class Cart {
	private double total;//�ܼ�
	//���ڴ洢�����Map��Ϊ�˷���ȡ
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//��ӹ�����
	public void addCart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		//���map���Ѿ������˸�CartItem������
		if(map.containsKey(pid)){
			CartItem _carCartItem = map.get(pid);
			cartItem.setCount(cartItem.getCount()+_carCartItem.getCount());
		}
		//���map��δ���������
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
