package com.hyr.dao.implement;

import org.springframework.stereotype.Component;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

@Component("u1")
public class UserDAOJDBCImplement implements UserDAO {

	@Override
	public void save(User user) {
		System.out.println("a user saved! -----by JDBC");
	}
		
}
