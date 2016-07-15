package com.hyr.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import com.hyr.dao.UserDAO;
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

//		public UserService(UserDAO userDAO, UserDAO userDAO2) {
//			super();
//			this.userDAO = userDAO;
//			this.userDAO2 = userDAO2;
//		}


		public UserDAO getUserDAO() {
			return userDAO;
		}
		
		@Resource(name="u2")
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		public UserDAO getUserDAO2() {
			return userDAO2;
		}

		public void setUserDAO2(UserDAO userDAO2) {
			this.userDAO2 = userDAO2;
		}
		
		
}
	
