package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_note")
public class Note
{
	private long id;
	private String notetitle;
	private String notecontent;
	private String time;

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

	@Column(length = 30)
	public String getNotetitle()
	{
		return notetitle;
	}

	public void setNotetitle(String notetitle)
	{
		this.notetitle = notetitle;
	}

	@Column(length = 200)
	public String getNotecontent()
	{
		return notecontent;
	}

	public void setNotecontent(String notecontent)
	{
		this.notecontent = notecontent;
	}

	@Column(length = 200)
	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}
}
