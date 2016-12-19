package com.shop.AdminUser.service;


import com.shop.AdminUser.dao.AdminUserDao;
import com.shop.AdminUser.vo.AdminUser;

public class AdminUserService  {
	private AdminUserDao adminUserDao;

	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		
		return adminUserDao.login(adminUser);
	}
}
