package com.Hubei.Polytechnic.University.IM.dto;

public class TypeDto
{
	private long id;
	private String name;

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
