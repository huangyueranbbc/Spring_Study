package com.hyr.register.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.hyr.register.dto.UserRegisterDto;
import com.hyr.register.service.UserManager;
import com.hyr.register.service.impl.UserManagerImplement;

@Entity(name="userregister")
public class User {
	private int id;
	private String username;
	private String password;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public boolean exist() {
		return new UserManagerImplement().exists(this);
	}
	public User(UserRegisterDto userRegisterDto) {
		super();
		this.username = userRegisterDto.getUsername();
		this.password = userRegisterDto.getPassword();
	}
	
	public User() {
		
	}
	
	
}
