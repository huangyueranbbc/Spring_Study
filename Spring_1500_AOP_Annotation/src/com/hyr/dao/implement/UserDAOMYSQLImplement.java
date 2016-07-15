package com.hyr.dao.implement;

import org.springframework.stereotype.Component;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

@Component("u2")
public class UserDAOMYSQLImplement implements UserDAO {

	@Override
	public void save(User user) {
		System.out.println("a user saved! -----use MYSQL");
	}
		
}
