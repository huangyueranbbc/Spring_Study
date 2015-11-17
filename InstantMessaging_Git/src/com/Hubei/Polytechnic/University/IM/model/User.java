package com.Hubei.Polytechnic.University.IM.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_user")
public class User
{
	private long id;
	private String phone;
	private String password;
	private String nickname;
	private String headpic;
	private double longitude;
	private double latitude;
	private String ip;
	private String token;
	private String sex;
	private String email;
	private Date regtime;
	private String logintime;
	private String profession;
	private String description;
	private int isrecomment;
	private String address;
	private String forbid;
	private String hobby;
	private String birthday;
	private String lastchange;

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

	@Column(length = 14)
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(length = 32)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(length = 200)
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	@Column(length = 200)
	public String getHeadpic()
	{
		return headpic;
	}

	public void setHeadpic(String headpic)
	{
		this.headpic = headpic;
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

	@Column(length = 200)
	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	@Column(length = 32)
	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	@Column(length = 2)
	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Column(length = 200)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(length = 200)
	public String getLogintime()
	{
		return logintime;
	}

	public void setLogintime(String logintime)
	{
		this.logintime = logintime;
	}

	@Column(length = 200)
	public String getProfession()
	{
		return profession;
	}

	public void setProfession(String profession)
	{
		this.profession = profession;
	}

	@Column(length = 200)
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getIsrecomment()
	{
		return isrecomment;
	}

	public void setIsrecomment(int isrecomment)
	{
		this.isrecomment = isrecomment;
	}

	@Column(length = 200)
	public Date getRegtime()
	{
		return regtime;
	}

	public void setRegtime(Date regtime)
	{
		this.regtime = regtime;
	}

	@Column(length = 32)
	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Column(length = 2)
	public String getForbid()
	{
		return forbid;
	}

	public void setForbid(String forbid)
	{
		this.forbid = forbid;
	}

	@Column(length = 200)
	public String getHobby()
	{
		return hobby;
	}

	public void setHobby(String hobby)
	{
		this.hobby = hobby;
	}

	@Column(length = 100)
	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	@Column(length = 100)
	public String getLastchange()
	{
		return lastchange;
	}

	public void setLastchange(String lastchange)
	{
		this.lastchange = lastchange;
	}

}
