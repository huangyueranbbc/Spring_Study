package com.hyr.register.service.impl;

import com.hyr.register.dao.UserDao;
import com.hyr.register.dao.impl.UserDaoImplement;
import com.hyr.register.model.User;
import com.hyr.register.service.UserManager;

public class UserManagerImplement implements UserManager {
	
	private UserDao userDao=new UserDaoImplement();

	@Override
	public boolean exists(User user){
			return userDao.checkUserExistsWithName(user.getUsername());
	}	
	
	@Override
	public void add(User user) {
		userDao.save(user);
	}
}
