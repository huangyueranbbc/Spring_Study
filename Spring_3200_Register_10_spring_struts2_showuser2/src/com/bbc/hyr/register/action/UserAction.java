package com.bbc.hyr.register.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyr.register.dto.UserRegisterDto;
import com.hyr.register.model.User;
import com.hyr.register.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserRegisterDto>{
	
	private UserRegisterDto userRegisterDto=new UserRegisterDto();
	
	private UserManager um;
	
	private List<User> users;
	private int id;
	
	public UserManager getUm() {
		return um;
	}
	
	@Resource(name="userManagerImplement")
	public void setUm(UserManager um) {
		System.out.println("userManager正在注入");
		this.um = um;
		System.out.println("userManager已经注入!!!"+um);
	}

	@Override
	public String execute() throws Exception {
		User u = new User(userRegisterDto);
		if(um.exists(u)) {
			return "failed";
		}
		um.add(u);
		return "success";
	}

	public UserRegisterDto getUserRegisterDto() {
		return userRegisterDto;
	}

	public void setUserRegisterDto(UserRegisterDto userRegisterDto) {
		this.userRegisterDto = userRegisterDto;
	}

	@Override
	public UserRegisterDto getModel() {
		return userRegisterDto;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String list() {
		this.users=this.um.getUsers();
		return "usershow";
	}
	
	public String load() {
		this.users=(List<User>) this.um.getUser(this.id);
		return "usershow";
	}
	
	
}
