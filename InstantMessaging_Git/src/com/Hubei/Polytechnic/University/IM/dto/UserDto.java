package com.Hubei.Polytechnic.University.IM.dto;

import java.util.Date;

public class UserDto
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
	private boolean sex;
	private String email;
	private Date regtime;
	private String logintime;
	private String profession;
	private String description;
	private boolean isrecomment;
	private String forbid;
	private String hobby;
	private int sexid;
	private String birthday;
	private String lastchange;
	private int pageNum = 1;
	private Long[] privilegeids;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

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

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public boolean isSex()
	{
		return sex;
	}

	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getRegtime()
	{
		return regtime;
	}

	public void setRegtime(Date regtime)
	{
		this.regtime = regtime;
	}

	public String getLogintime()
	{
		return logintime;
	}

	public void setLogintime(String logintime)
	{
		this.logintime = logintime;
	}

	public String getProfession()
	{
		return profession;
	}

	public void setProfession(String profession)
	{
		this.profession = profession;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public boolean isIsrecomment()
	{
		return isrecomment;
	}

	public void setIsrecomment(boolean isrecomment)
	{
		this.isrecomment = isrecomment;
	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public Long[] getPrivilegeids()
	{
		return privilegeids;
	}

	public void setPrivilegeids(Long[] privilegeids)
	{
		this.privilegeids = privilegeids;
	}

	public int getSexid()
	{
		return sexid;
	}

	public void setSexid(int sexid)
	{
		this.sexid = sexid;
	}

	public String getForbid()
	{
		return forbid;
	}

	public void setForbid(String forbid)
	{
		this.forbid = forbid;
	}

	public String getHobby()
	{
		return hobby;
	}

	public void setHobby(String hobby)
	{
		this.hobby = hobby;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getLastchange()
	{
		return lastchange;
	}

	public void setLastchange(String lastchange)
	{
		this.lastchange = lastchange;
	}

}
