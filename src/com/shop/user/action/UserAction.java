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
	// ������֤��:
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public User getModel() {
		return user;
	}
	/**
	 * ע��ҳ���Action
	 * @return
	 */
	public String registPage(){
		
		return "registPage";
	}
	/**
	 * AJAX��Action
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		User exitUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().println("<font color='red'>�û��Ѿ���</font>");
		}
		else{
			response.getWriter().println("<font color='green'>�û�����ʹ��</font>");
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
		// �ж���֤�����:
		// ��session�л����֤������ֵ:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("��֤���������!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
		return "msg";
	}
	public String active(){
		// ���ݼ������ѯ�û�:
		User existUser = userService.findByCode(user.getCode());
		// �ж�
		if (existUser == null) {
			// ����������
			this.addActionMessage("����ʧ��:���������!");
		} else {
			// ����ɹ�
			// �޸��û���״̬
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ�:��ȥ��¼!");
		}
		return "msg";
	}
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * ��¼�ķ���
	 */
	public String login() {
		User existUser = userService.login(user);
		// �ж�
		if (existUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ��:�û��������������û�δ����!");
			return LOGIN;
		} else {
			// ��¼�ɹ�
			// ���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}
	
	}
	/**
	 * �˳�
	 */
	public String  quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
