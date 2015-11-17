package com.Hubei.Polytechnic.University.IM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pinfo_contact")
public class Contact
{
	private long id;
	private String phone_me;
	private String phone_contact;
	private int is_active;
	private String nickname;

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
	public String getPhone_me()
	{
		return phone_me;
	}

	public void setPhone_me(String phone_me)
	{
		this.phone_me = phone_me;
	}

	@Column(length = 14)
	public String getPhone_contact()
	{
		return phone_contact;
	}

	public void setPhone_contact(String phone_contact)
	{
		this.phone_contact = phone_contact;
	}

	@Column(columnDefinition = "tinyint(1)")
	public int getIs_active()
	{
		return is_active;
	}

	public void setIs_active(int is_active)
	{
		this.is_active = is_active;
	}

	@Column(length = 30)
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

}
