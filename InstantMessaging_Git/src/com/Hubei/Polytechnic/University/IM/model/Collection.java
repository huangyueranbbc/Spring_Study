package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_collection")
public class Collection
{
	private long id;
	private long themeid;
	private String phone;

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

	@Column(length = 20)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

}
