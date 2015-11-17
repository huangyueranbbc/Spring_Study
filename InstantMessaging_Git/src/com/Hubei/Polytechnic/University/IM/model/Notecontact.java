package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_notecontact")
public class Notecontact
{
	private long id;
	private long userid;
	private long noteid;

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

	public long getNoteid()
	{
		return noteid;
	}

	public void setNoteid(long noteid)
	{
		this.noteid = noteid;
	}
}
