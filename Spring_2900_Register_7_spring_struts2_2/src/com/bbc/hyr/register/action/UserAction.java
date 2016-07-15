package com.bbc.hyr.register.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyr.register.model.User;
import com.hyr.register.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	
	private String username;
	private String password;
	private String password2;
	
	private UserManager um;
	
	
	
	public UserManager getUm() {
		return um;
	}
	
	@Resource(name="userManagerImplement")
	public void setUm(UserManager um) {
		System.out.println("userManager����ע��");
		this.um = um;
		System.out.println("userManager�Ѿ�ע��!!!"+um);
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		if(um.exists(u)) {
			return "failed";
		}
		um.add(u);
		return "success";
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
