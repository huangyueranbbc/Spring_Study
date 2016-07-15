package com.hyr.register.service;

import org.springframework.stereotype.Component;

import com.hyr.register.model.User;

public interface UserManager {

	public abstract boolean exists(User user);

	public abstract void add(User user);

}