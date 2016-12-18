package com.shop.AdminUser.service;


import com.shop.AdminUser.dao.AdminUserDao;

public class AdminUserService  {
	private AdminUserDao adminUserDao;

	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
}
