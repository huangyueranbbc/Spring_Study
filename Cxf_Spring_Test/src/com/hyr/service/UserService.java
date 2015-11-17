package com.hyr.service;

import java.util.List;

import com.hyr.entity.Cat;
import com.hyr.entity.User;

public interface UserService
{

	List<Cat> getCatByUser(User user);

}
