package com.hyr.register.dao;

import com.hyr.register.model.User;

public interface UserDao {
		public void save(User user);
		public boolean checkUserExistsWithName(String username);
}
