package com.shop.category.adminaction;



import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;

public class AdminCategoryAction extends ActionSupport {
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String  findAll(){
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
}
