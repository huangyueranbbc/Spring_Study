package com.Hubei.Polytechnic.University.IM.dto;

import java.util.Date;

public class ThemeDto
{
	private long id;
	private String content;
	private String phone;
	private long commentcount;
	private String ip;
	private double longitude;
	private double latitude;
	private long typeid;
	private long collectioncount;
	private String province;
	private String city;
	private Date createtime;
	private String themepic;
	private long themebytypeid;
	private String typename;
	private String keyword;

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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public long getCommentcount()
	{
		return commentcount;
	}

	public void setCommentcount(long commentcount)
	{
		this.commentcount = commentcount;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public long getTypeid()
	{
		return typeid;
	}

	public void setTypeid(long typeid)
	{
		this.typeid = typeid;
	}

	public long getCollectioncount()
	{
		return collectioncount;
	}

	public void setCollectioncount(long collectioncount)
	{
		this.collectioncount = collectioncount;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public String getThemepic()
	{
		return themepic;
	}

	public void setThemepic(String themepic)
	{
		this.themepic = themepic;
	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public long getThemebytypeid()
	{
		return themebytypeid;
	}

	public void setThemebytypeid(long themebytypeid)
	{
		this.themebytypeid = themebytypeid;
	}

	public String getTypename()
	{
		return typename;
	}

	public void setTypename(String typename)
	{
		this.typename = typename;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

}
