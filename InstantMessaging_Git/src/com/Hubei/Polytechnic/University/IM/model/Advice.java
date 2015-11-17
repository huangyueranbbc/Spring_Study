package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_advice")
public class Advice
{
	private long id;
	private String email;
	private String phonenumber;
	private String title;
	private String content;

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

	@Column(length = 200)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(length = 14)
	public String getPhonenumber()
	{
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber)
	{
		this.phonenumber = phonenumber;
	}

	@Column(length = 50)
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Column(length = 400)
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
