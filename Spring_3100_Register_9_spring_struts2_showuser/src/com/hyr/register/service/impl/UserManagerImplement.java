package com.hyr.register.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hyr.register.dao.UserDao;
import com.hyr.register.model.User;
import com.hyr.register.service.UserManager;

@Component("userManagerImplement")
public class UserManagerImplement implements UserManager {
	
	private UserDao userDao;

	@Override
	public boolean exists(User user){
			return userDao.checkUserExistsWithName(user.getUsername());
	}	
	
	@Override
	public void add(User user) {
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDaoImplement")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}
	
}
