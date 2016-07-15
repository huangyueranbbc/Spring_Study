package com.bbc.hyr.register.action;

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
	
}
