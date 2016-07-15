package com.hyr.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyr.dao.LogDAO;
import com.hyr.dao.UserDAO;
import com.hyr.model.Log;
import com.hyr.model.User;

@Component("hyrService")
public class UserService {
		
		private UserDAO userDAO;
		private LogDAO logDAO;
		
		public void gamestrat() {
			System.out.println("GAME START");
		}
		public void gameover() {
			System.out.println("GAME OVER");
		}
		//@Transactional
		public void add(User user){
			Log log=new Log();
			this.userDAO.save(user);
			log.setMsg("一个用户已存储!"+"——————"+new Date().toLocaleString());
			this.logDAO.save(log);
		}				

//		public UserService(UserDAO userDAO, UserDAO userDAO2) {
//			super();
//			this.userDAO = userDAO;
//			this.userDAO2 = userDAO2;
//		}


		public UserDAO getUserDAO() {
			return userDAO;
		}
		//userdao的注入
		@Resource(name="u2")
		public void setUserDAO(UserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		public LogDAO getLogDAO() {
			return logDAO;
		}
		//logdao的注入
		@Resource(name="logDAO")
		public void setLogDAO(LogDAO logDAO) {
			this.logDAO = logDAO;
		}
		
		
}
	
