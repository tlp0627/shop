package com.shop.user.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.user.service.UserService;
import com.shop.user.vo.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User(); 
	private UserService userService;
	// 接收验证码:
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public User getModel() {
		return user;
	}
	/**
	 * 注册页面的Action
	 * @return
	 */
	public String registPage(){
		
		return "registPage";
	}
	/**
	 * AJAX的Action
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		User exitUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().println("<font color='red'>用户已经在</font>");
		}
		else{
			response.getWriter().println("<font color='green'>用户可以使用</font>");
		}
		
		return NONE;
		
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String regist(){
		
		return "msg";
	}
	public String regist1(){
		// 判断验证码程序:
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码输入错误!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	public String active(){
		// 根据激活码查询用户:
		User existUser = userService.findByCode(user.getCode());
		// 判断
		if (existUser == null) {
			// 激活码错误的
			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			// 修改用户的状态
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "msg";
	}
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * 登录的方法
	 */
	public String login() {
		User existUser = userService.login(user);
		// 判断
		if (existUser == null) {
			// 登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		} else {
			// 登录成功
			// 将用户的信息存入到session中
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}
	
	}
	/**
	 * 退出
	 */
	public String  quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
