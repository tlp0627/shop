package com.shop.categorysecond.vo;

import com.shop.category.vo.Category;

public class CategorySecond {
	private Integer csid;
	private String csname;
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
	public Category getCatgegory() {
		return catgegory;
	}
	public void setCatgegory(Category catgegory) {
		this.catgegory = catgegory;
	}
	private Category catgegory;
}
