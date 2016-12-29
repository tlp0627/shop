package com.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.category.vo.Category;
import com.shop.categorysecond.service.CategorySecondService;
import com.shop.categorysecond.vo.CategorySecond;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;
import com.utlis.PageBean;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product = new Product();
	private ProductService productService;
	private CategorySecondService categorySecondService;
	private Integer page;
	private File upload;
	private String uploadFileName;
	private String uploadContextType;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public Product getModel() {
		return product;
	}

	public String findAll(){
		PageBean <Product> pageBean = productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	public String addPage(){
		List <CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	public String save() throws IOException{
		product.setPdate(new Date());
		if (upload!=null) {
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			File diskFile = new File(path +"//" + uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	public String edit(){
		List <CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		product = productService.findByPid(product.getPid());
		return "editSuccess";
	}
	public String update() throws IOException {
		product.setPdate(new Date());
		if (upload!=null) {
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			File diskFile = new File(path +"//" + uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
	public String delete(){
		productService.delete(product);
		return "deleteSuccess";
	}
}
