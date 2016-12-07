package com.shop.product.service;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.shop.product.dao.ProductDao;
import com.shop.product.vo.Product;
import com.utlis.PageBean;

public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> getHotProducts() {
		return productDao.getHotProducts();
	}


	public List<Product> FindNewProducts() {
		return productDao.FinNewProducts();
	}

	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean <Product> pageBean = new PageBean();
		//设置当前页数
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总条目数
		int totalCount =0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount%limit==0){
			totalCount = totalCount/limit;
		}
		else{
			totalCount = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin =  (page-1)*limit;
		List <Product> list = productDao.findByPageCid(cid,begin,limit);
		return null;
	}
	
}
