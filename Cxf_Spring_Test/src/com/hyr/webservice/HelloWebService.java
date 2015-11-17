package com.hyr.webservice;

import java.util.List;

import javax.jws.WebService;

import com.hyr.entity.Cat;
import com.hyr.entity.User;

@WebService
public interface HelloWebService
{
	String sayHi(String name);

	List<Cat> getCatByUser(User user);
}
