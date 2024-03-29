package com.hyr.register.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyr.register.model.User;
import com.hyr.register.service.UserManager;
import com.hyr.register.service.impl.UserManagerImplement;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String username;
	private String password;
	private String password2;
	
	private UserManager userManager;
	
	public UserAction() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		userManager=(UserManager) applicationContext.getBean("UserManagerImplement");
	}
	
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		if(userManager.exists(user)){
			return "failed";
		}
		userManager.add(user);
		return super.execute();
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
