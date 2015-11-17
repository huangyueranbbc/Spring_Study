package com.Hubei.Polytechnic.University.IM.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.UserDto;
import com.Hubei.Polytechnic.University.IM.model.User;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class HomeAction extends ModelDrivenBaseAction<UserDto>
{
	public String index() throws Exception
	{
		// 准备数据
		Calendar calendar = Calendar.getInstance();
		// int month=calendar.get(Calendar.MONTH)+1;//获取月份
		// int year = calendar.get(Calendar.YEAR);//获取年份
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		String datestr = formatter.format(date);
		System.out.println(date);
		List<User> regList = userService.getByYearAndMonth(datestr);

		int maxday = calendar.getMaximum(Calendar.DATE);

		int[] regCounts = new int[maxday];
		List<Integer> regnums = new ArrayList<Integer>();

		formatter = new SimpleDateFormat("d");
		String dateString = null;

		// 判断是否是某天 如果是 则该天注册数加一
		for (int i = 0; i < maxday; i++)
		{

			for (User u : regList)
			{
				dateString = formatter.format(u.getRegtime());
				if (dateString.equals(i + ""))
				{
					regCounts[i] += 1;
				}
			}

		}

		for (int i = 0; i < maxday; i++)
		{
			regnums.add(regCounts[i]);
		}

		Long usercount = userService.getAllUserCount();
		System.out.println("用户总注册数:" + usercount);

		formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long todaycount = userService.getByDate(formatter.format(date));
		System.out.println("本日用户总注册数:" + todaycount);

		ActionContext.getContext().getSession()
				.put("todayusercount", todaycount);
		ActionContext.getContext().getSession().put("usercount", usercount);
		ActionContext.getContext().getSession().put("regnums", regnums);
		return "index";
	}
}
