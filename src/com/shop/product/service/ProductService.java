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
		//���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		int limit = 8;
		pageBean.setLimit(limit);
		//��������Ŀ��
		int totalCount =0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount%limit==0){
			totalCount = totalCount/limit;
		}
		else{
			totalCount = totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���:
		// ���Ŀ�ʼ:
		int begin =  (page-1)*limit;
		List <Product> list = productDao.findByPageCid(cid,begin,limit);
		return null;
	}
	
}
