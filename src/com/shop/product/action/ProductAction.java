package com.shop.product.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product produt;
	public Product getModel() {
		// TODO Auto-generated method stub
		return this.produt;
	}
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

}
