package com.Hubei.Polytechnic.University.IM.dto;

import java.util.Date;

public class ReplyDto
{
	private long id;
	private long themid;
	private long authorid;
	private String content;
	private Date createtime;

	// 当没有传值时，页码默认为第一页
	private int pageNum = 1;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public long getThemid()
	{
		return themid;
	}

	public void setThemid(long themid)
	{
		this.themid = themid;
	}

	public long getAuthorid()
	{
		return authorid;
	}

	public void setAuthorid(long authorid)
	{
		this.authorid = authorid;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

}
