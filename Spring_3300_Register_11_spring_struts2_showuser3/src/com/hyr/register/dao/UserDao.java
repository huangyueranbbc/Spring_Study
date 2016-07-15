package com.hyr.register.dao;

import java.util.List;

import com.hyr.register.model.User;

public interface UserDao {
		public void save(User user);
		public boolean checkUserExistsWithName(String username);
		public List<User> getUsers();
		public User loadById(int id);
}
