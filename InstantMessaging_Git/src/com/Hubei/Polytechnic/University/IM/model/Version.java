package com.Hubei.Polytechnic.University.IM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_version")
public class Version
{
	private long id;
	private String version;
	private String soft_name;
	private Date time;
	private String path; // 文件在服务器端存取的路径
	private String url;// 下载路径

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

	@Column(length = 50)
	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	@Column(length = 200)
	public String getSoft_name()
	{
		return soft_name;
	}

	public void setSoft_name(String soft_name)
	{
		this.soft_name = soft_name;
	}

	@Column(length = 200)
	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	@Column(length = 200)
	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	@Column(length = 200)
	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
