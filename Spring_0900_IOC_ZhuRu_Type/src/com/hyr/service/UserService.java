package com.hyr.service;

import com.hyr.dao.UserDAO;
import com.hyr.dao.implement.UserDAOODBCImplement;
import com.hyr.model.User;

public class UserService {
		
		private UserDAO userDAO;
		private UserDAO userDAO2;
		public void gamestrat() {
			System.out.println("GAME START");
		}
		public void gameover() {
			System.out.println("GAME OVER");
		}
		public void add(User user){
				this.userDAO.save(user);
		}				

		public UserService(UserDAO userDAO, UserDAO userDAO2) {
			super();
			this.userDAO = userDAO;
			this.userDAO2 = userDAO2;
		}


		public UserDAO getUserDAO() {
			return userDAO;
		}
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		
}
	
