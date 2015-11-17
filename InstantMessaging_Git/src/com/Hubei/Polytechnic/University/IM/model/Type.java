package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_type")
public class Type
{
	private long id;
	private String name;

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
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
