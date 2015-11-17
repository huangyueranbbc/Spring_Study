package com.Hubei.Polytechnic.University.IM.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MessageDto
{
	private String title;
	private String alert;
	private String msg_content;
	public List<Long> tagList = new ArrayList<Long>();

	public List<Long> getTagList()
	{
		return tagList;
	}

	public void setTagList(List<Long> tagList)
	{
		this.tagList = tagList;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAlert()
	{
		return alert;
	}

	public void setAlert(String alert)
	{
		this.alert = alert;
	}

	public String getMsg_content()
	{
		return msg_content;
	}

	public void setMsg_content(String msg_content)
	{
		this.msg_content = msg_content;
	}

}
