package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_pricontact")
public class Pricontact
{
	private long id;
	private long userid;
	private long preid;

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

	public long getUserid()
	{
		return userid;
	}

	public void setUserid(long userid)
	{
		this.userid = userid;
	}

	public long getPreid()
	{
		return preid;
	}

	public void setPreid(long preid)
	{
		this.preid = preid;
	}
}
