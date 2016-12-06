package com.shop.index.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.service.CategoryService;
import com.shop.category.vo.Category;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;
public class IndexAction extends ActionSupport {


	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	/**
	 * ִ�еķ��ʷ���
	 */
	public String execute(){
		//��ѯ������Ʒ
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getSession().put("cList", cList);
		//��ѯ������Ʒ
		List <Product> hList = productService.getHotProducts();
		ActionContext.getContext().getValueStack().set("hList", hList);
		//��ѯ������Ʒ
		List <Product> nList = productService.FindNewProducts();
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	

}
