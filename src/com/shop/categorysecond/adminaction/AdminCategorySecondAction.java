package com.shop.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;
import com.shop.categorysecond.service.CategorySecondService;
import com.shop.categorysecond.vo.CategorySecond;
import com.utlis.PageBean;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
	private CategorySecondService categorySecondService;
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	private CategorySecond categorySecond = new CategorySecond();
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}


	public CategorySecond getModel() {
		return categorySecond;
	}


	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}


	public String findAll(){
		PageBean <CategorySecond> pageBean = categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	public String addPage(){
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	public String edit(){
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		categorySecond = categorySecondService.finByCsid(categorySecond.getCsid());
		return "editSuccess";
	}
	public String update() {
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	public String delete(){
		categorySecond = categorySecondService.finByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
}
