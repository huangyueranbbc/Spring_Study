package com.hyr.cxf.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hyr.webservice.Cat;
import com.hyr.webservice.HelloWebService;
import com.hyr.webservice.User;
import com.opensymphony.xwork2.ActionSupport;

public class CatAction extends ActionSupport
{
	// 此时依赖的是远程Web Service的代理对象。
	private HelloWebService helloWebService;

	private List<Cat> cats;

	@Override
	public String execute() throws Exception
	{

		User user = new User();
		user.setId(1);
		user.setName("大白");
		user.setPassword("32522");
		setCats(helloWebService.getCatByUser(user));

		return SUCCESS;
	}

	public HelloWebService getHelloWebService()
	{
		return helloWebService;
	}

	public void setHelloWebService(HelloWebService helloWebService)
	{
		this.helloWebService = helloWebService;
	}

	public List<Cat> getCats()
	{
		return cats;
	}

	public void setCats(List<Cat> cats)
	{
		this.cats = cats;
	}

}
