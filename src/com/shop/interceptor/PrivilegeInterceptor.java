package com.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.shop.AdminUser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 鏉冮檺鎷︽埅鍣�
 * @author 浼犳櫤.閮槈
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 鍒ゆ柇鏄惁鐧诲綍,濡傛灉鐧诲綍,鏀捐,娌℃湁鐧诲綍,璺宠浆鍒扮櫥褰曢〉闈�
		AdminUser adminUser = (AdminUser) ServletActionContext.getRequest()
				.getSession().getAttribute("existAdminUser");
		if(adminUser != null){
			// 宸茬粡鐧诲綍杩�
			return actionInvocation.invoke();
		}else{
			// 璺宠浆鍒扮櫥褰曢〉闈�
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("鎮ㄨ繕娌℃湁鐧诲綍!娌℃湁鏉冮檺璁块棶!");
			return ActionSupport.LOGIN;
		}
	}

}
