package com.hyr.webserviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.hyr.entity.Cat;
import com.hyr.entity.User;
import com.hyr.service.UserService;
import com.hyr.service.impl.UserServiceImpl;
import com.hyr.webservice.HelloWebService;

@WebService(endpointInterface = "com.hyr.webservice.HelloWebService", serviceName = "helloWebServiceImpl")
public class HelloWebServiceImpl implements HelloWebService
{
	@Resource(name = "userService")
	private UserService us;

	@Override
	public String sayHi(String name)
	{
		return name + ",您好      " + "现在时间是:" + new Date();
	}

	@Override
	public List<Cat> getCatByUser(User user)
	{
		return us.getCatByUser(user);
	}

	public UserService getUs()
	{
		return us;
	}

	public void setUs(UserService us)
	{
		this.us = us;
	}

}
