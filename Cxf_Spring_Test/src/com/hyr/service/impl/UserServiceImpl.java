package com.hyr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyr.entity.Cat;
import com.hyr.entity.User;
import com.hyr.service.UserService;

public class UserServiceImpl implements UserService
{

	static Map<User, List<Cat>> catDb = new HashMap<User, List<Cat>>();
	static
	{
		List<Cat> cats1 = new ArrayList<Cat>();
		cats1.add(new Cat(1, "小红", "黄色"));
		cats1.add(new Cat(2, "小蓝", "绿色"));
		cats1.add(new Cat(3, "小橙", "紫色"));
		cats1.add(new Cat(4, "小白", "白色"));
		cats1.add(new Cat(5, "小灰", "橘黄色"));
		catDb.put(new User(1, "李白", "3222", "北京"), cats1);

		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat(1, "小月月", "黄色"));
		cats.add(new Cat(2, "小蓝", "绿色"));
		cats.add(new Cat(3, "小橙", "紫色"));
		cats.add(new Cat(4, "小白", "白色"));
		cats.add(new Cat(5, "小灰", "橘黄色"));
		catDb.put(new User(2, "大白", "32522", "黄石"), cats);
	}

	@Override
	public List<Cat> getCatByUser(User user)
	{

		return catDb.get(user);
	}

}
