package com.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;

public class IndexAction extends ActionSupport {

	/**
	 * 执行的访问方法
	 */
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String execute(){
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getSession().put("cList", cList);
		return "index";
	}
	

}
