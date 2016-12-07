package com.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.product.service.ProductService;
import com.shop.product.vo.Product;
import com.utlis.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	// ���շ���cid
	private Integer cid;

	// ���յ�ǰҳ��:
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	private Product product = new Product();
	public Product getModel() {
		return product;

	}
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//��ҳ�㿪��Ʒ��������
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		ActionContext.getContext().getSession().put("product", product);
		return "productPage";
	}
	//��ҳ��һ��Ŀ¼
	public String findByCid(){
		PageBean <Product> pagebean = productService.findByPageCid(cid,page);
		return null;
	}

}
