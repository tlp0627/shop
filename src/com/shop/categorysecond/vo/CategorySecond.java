package com.shop.categorysecond.vo;

import java.util.Set;

import com.shop.category.vo.Category;
import com.shop.product.vo.Product;

public class CategorySecond {
	private Integer csid;
	private String csname;
	private Set <Product> product; 

	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}

	private Category category;

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
