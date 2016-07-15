package com.hyr.register.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hyr.register.model.User;

public interface UserManager {

	public abstract boolean exists(User user);

	public abstract void add(User user);
	
	public List<User> getUsers();
}