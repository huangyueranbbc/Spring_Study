package com.Hubei.Polytechnic.University.IM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_admin")
public class Admin
{
	private long id;
	private String phone;
	private String password;
	private String ip;
	private Date logintime;

	@Id
	@GeneratedValue
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(length = 15)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(length = 32)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(length = 200)
	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	@Column(length = 200)
	public Date getLogintime()
	{
		return logintime;
	}

	public void setLogintime(Date logintime)
	{
		this.logintime = logintime;
	}

}
