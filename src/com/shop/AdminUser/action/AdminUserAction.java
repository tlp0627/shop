package com.shop.AdminUser.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.AdminUser.service.AdminUserService;
import com.shop.AdminUser.vo.AdminUser;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	private AdminUser adminUser = new AdminUser();
	private AdminUserService adminUserService;
	public AdminUserService getAdminUserService() {
		return adminUserService;
	}
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	public AdminUser getModel() {
		return adminUser;
	}
	//��ҳ��ת
	public String login(){
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser == null) {
			// �û������������
			this.addActionError("�û������������!");
			return "loginFail";
		} 
		else{
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
	

}
