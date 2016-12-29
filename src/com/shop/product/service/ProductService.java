package com.shop.product.service;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.shop.categorysecond.vo.CategorySecond;
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

	public PageBean<Product> findByPageCsid(Integer cisd, int page) {
		PageBean <Product> pageBean = new PageBean();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		int limit = 8;
		pageBean.setLimit(limit);
		//��������Ŀ��
		int totalCount =0;
		totalCount = productDao.findCountCid(cisd);
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
		List <Product> list = productDao.findByPageCid(cisd,begin,limit);
		
		return pageBean;
	}
	// ����һ�������cid���з�ҳ��ѯ��Ʒ
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���õ�ǰҳ��:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		int limit = 8;
		pageBean.setLimit(limit);
		//  �����ܼ�¼��:
		int totalCount = 0 ;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���:
		// ���Ŀ�ʼ:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���õ�ǰҳ��:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		int limit = 15;
		pageBean.setLimit(limit);
		//  �����ܼ�¼��:
		int totalCount = 0 ;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���:
		// ���Ŀ�ʼ:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Product product) {
		productDao.save(product);
	}

	public void update(Product product) {
		productDao.update(product);
	}

	public void delete(Product product) {
		productDao.delete(product);
	}
	
}
