package com.hyr.service;

import com.hyr.dao.UserDAO;
import com.hyr.dao.implement.UserDAOODBCImplement;
import com.hyr.model.User;

public class UserService {
		
		private UserDAO userDAO;
		public void add(User user) {
				this.userDAO.save(user);
		}		
		
		public UserDAO getUserDAO() {
			return userDAO;
		}
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		
}
	
