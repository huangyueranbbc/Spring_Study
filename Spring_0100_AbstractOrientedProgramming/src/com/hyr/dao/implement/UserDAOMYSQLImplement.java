package com.hyr.dao.implement;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

public class UserDAOMYSQLImplement implements UserDAO {

	@Override
	public void save(User user) {
		System.out.println("a user saved! -----use MYSQL");
	}
		
}
