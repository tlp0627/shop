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
		List <Category> cList = categoryService.getCategoryAll();
		ActionContext.getContext().getSession().put("cList", cList);
		
		List <Product> hList = productService.getHotProducts();
		Iterator<Product> iterator = hList.iterator();
		while (iterator.hasNext()) {
			Product product=iterator.next();
			System.out.println(product.getImage());
			
		}
		//System.out.println(hotProducts==null);
		ActionContext.getContext().getValueStack().set("hList", hList);
		return "index";
	}
	

}
