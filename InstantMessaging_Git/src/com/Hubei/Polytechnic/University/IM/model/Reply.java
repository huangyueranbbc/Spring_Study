package com.Hubei.Polytechnic.University.IM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_reply")
public class Reply
{
	private long id;
	private long themeid;
	private String phone;
	private String content;
	private Date createtime;

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

	public long getThemeid()
	{
		return themeid;
	}

	public void setThemeid(long themeid)
	{
		this.themeid = themeid;
	}

	@Column(length = 14)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(length = 50)
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Column(length = 200)
	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

}
