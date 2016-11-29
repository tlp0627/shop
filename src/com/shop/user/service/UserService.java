package com.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.shop.user.dao.UserDao;
import com.shop.user.vo.User;
import com.utlis.MailUtils;
import com.utlis.UUIDUtils;

@Transactional
public class UserService {
	// 注入UserDao
	/*private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}*/

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	public void save(User user) {
		user.setCode(UUIDUtils.getUUID()+UUIDUtils.getUUID());
		user.setState(0);
		userDao.save(user);
		
		MailUtils.sendMail(user.getEmail(), user.getCode());
		
		
	}
	public void update(User existUser) {
		userDao.update(existUser);
	}
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}
	public User login(User user) {
		
		return userDao.login(user);
	}

}
