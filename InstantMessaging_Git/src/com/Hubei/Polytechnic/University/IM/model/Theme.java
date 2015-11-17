package com.Hubei.Polytechnic.University.IM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_theme")
public class Theme
{
	private long id;
	private String content;
	private long commentcount;
	private String ip;
	private double longitude;
	private double latitude;
	private long typeid;
	private long collectioncount;
	private String province;
	private String city;
	private String themepic;
	private String phone;
	private Date createtime;

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

	@Column(length = 400)
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public long getCommentcount()
	{
		return commentcount;
	}

	public void setCommentcount(long commentcount)
	{
		this.commentcount = commentcount;
	}

	@Column(length = 200)
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

	@Column(length = 32)
	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	@Column(length = 32)
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Column(columnDefinition = "varchar(400)")
	public String getThemepic()
	{
		return themepic;
	}

	@Column(length = 200)
	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public void setThemepic(String themepic)
	{
		this.themepic = themepic;
	}

	@Column(length = 14)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

}
