package com.Hubei.Polytechnic.University.IM.dto;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class VersionDto
{
	private long id;
	private String version;
	private String soft_name;
	private Date time;
	private String path; // 文件在服务器端存取的路径
	private String url;// 下载路径
	private InputStream inputStream;
	private File upload;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getSoft_name()
	{
		return soft_name;
	}

	public void setSoft_name(String soft_name)
	{
		this.soft_name = soft_name;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}

}
