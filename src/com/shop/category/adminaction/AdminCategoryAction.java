package com.shop.category.adminaction;



import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	private CategoryService categoryService;
	private Category category = new Category();
	public Category getModel() {
		return category;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String  findAll(){
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		return "editSuccess";
	}
	public String save(){
		categoryService.save(category);
		return "saveSuccess";
	}
	public String update(){
		categoryService.update(category);
		return "updateSuccess";
	}
	public String delete(){
		category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		return "deleteSuccess";
	}
}
