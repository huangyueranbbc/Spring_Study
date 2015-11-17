package com.Hubei.Polytechnic.University.IM.dto;

public class AdminDto
{
	private long id;
	private String phone;
	private String password;
	private String ip;
	private String logintime;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getLogintime()
	{
		return logintime;
	}

	public void setLogintime(String logintime)
	{
		this.logintime = logintime;
	}

}
