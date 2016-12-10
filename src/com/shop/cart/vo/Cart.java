package com.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shop.product.vo.Product;

public class Cart implements Serializable {
	private double total;//�ܼ�
	public double getTotal() {
		return total;
	}
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
	//��չ��ﳵ
	public void clearCart(){
		map.clear();
		total = 0;
	}
}
