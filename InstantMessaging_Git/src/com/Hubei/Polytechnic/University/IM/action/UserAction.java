package com.Hubei.Polytechnic.University.IM.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.UserDto;
import com.Hubei.Polytechnic.University.IM.model.User;
import com.Hubei.Polytechnic.University.IM.util.HqlHelper;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<UserDto>
{

	/** 列表 */
	public String list() throws Exception
	{
		// List<User> users=userService.findAll();
		// ActionContext.getContext().put("userList", users);
		if (modeldto.getHobby() == null || modeldto.getHobby().equals(""))
		{
			if (modeldto.getPhone() == null)
			{
				new HqlHelper(User.class).buildPageBeanForStruts2(
						modeldto.getPageNum(), userService);
				System.out.println("显示所有用户列表！");
			} else if (modeldto.getPhone().equals(""))
			{
				new HqlHelper(User.class).buildPageBeanForStruts2(
						modeldto.getPageNum(), userService);
				System.out.println("显示所有用户列表！");
			} else
			{
				System.out.println("phone=" + modeldto.getPhone());
				new HqlHelper(User.class, "u").addCondition("u.phone=?",
						modeldto.getPhone()).buildPageBeanForStruts2(
						modeldto.getPageNum(), userService);
				System.out.println("显示根据手机号进行搜索的用户列表！");
			}
		} else
		{
			if (modeldto.getPhone() == null)
			{
				new HqlHelper(User.class, "u").addCondition(
						"u.hobby LIKE '%" + modeldto.getHobby() + "%'")
						.buildPageBeanForStruts2(modeldto.getPageNum(),
								userService);
				System.out.println("显示所有用户列表！");
			} else if (modeldto.getPhone().equals(""))
			{
				new HqlHelper(User.class, "u").addCondition(
						"u.hobby LIKE '%" + modeldto.getHobby() + "%'")
						.buildPageBeanForStruts2(modeldto.getPageNum(),
								userService);
				System.out.println("显示所有用户列表！");
			} else
			{
				System.out.println("phone=" + modeldto.getPhone());
				new HqlHelper(User.class, "u")
						.addCondition("u.phone=?", modeldto.getPhone())
						.addCondition(
								"u.hobby LIKE '%" + modeldto.getHobby() + "%'")
						.buildPageBeanForStruts2(modeldto.getPageNum(),
								userService);
				System.out.println("显示根据手机号进行搜索的用户列表！");
			}
		}

		return "list";
	}

	/** 显示用户信息 */
	public String show() throws Exception
	{
		// 准备数据
		System.out.println("USER的ID：" + modeldto.getId());
		User user = userService.getById(modeldto.getId());

		ActionContext.getContext().getValueStack().push(user);

		System.out.println(user.getRegtime());
		System.out.println(user.getLogintime());
		return "show";
	}

	/** 禁止用户发表主题和评论 */
	public String notspeaking() throws Exception
	{
		User user = userService.getById(modeldto.getId());
		user.setForbid("0");
		userService.update(user);

		System.out.println("用户已禁言成功！");
		return "tolist";
	}

	/** 允许用户发表主题和评论 */
	public String allowedspeaking() throws Exception
	{
		User user = userService.getById(modeldto.getId());
		user.setForbid("1");
		userService.update(user);

		System.out.println("用户已解除禁言成功！");
		return "tolist";
	}

	/** 删除 */
	public String delete() throws Exception
	{
		userService.delete(modeldto.getId());
		themeService.deleteByPhone(modeldto.getPhone());
		replyService.deleteByPhone(modeldto.getPhone());

		// TODO 还有逻辑没有删除！！
		System.out.println("删除成功！");
		return "tolist";
	}

	/**
	 * 获取随机日期
	 * 
	 * @param beginDate
	 *            起始日期，格式为：yyyy-MM-dd
	 * @param endDate
	 *            结束日期，格式为：yyyy-MM-dd
	 * @return
	 */
	private static Date randomDate(String beginDate, String endDate)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = format.parse(beginDate);// 构造开始日期
			Date end = format.parse(endDate);// 构造结束日期
			// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
			if (start.getTime() >= end.getTime())
			{
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end)
	{
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end)
		{
			return random(begin, end);
		}
		return rtn;
	}

	/**
	 * 随机生成国内IP地址
	 */
	public static String getRandomIp()
	{

		// ip范围
		int[][] range =
		{
		{ 607649792, 608174079 },// 36.56.0.0-36.63.255.255
				{ 1038614528, 1039007743 },// 61.232.0.0-61.237.255.255
				{ 1783627776, 1784676351 },// 106.80.0.0-106.95.255.255
				{ 2035023872, 2035154943 },// 121.76.0.0-121.77.255.255
				{ 2078801920, 2079064063 },// 123.232.0.0-123.235.255.255
				{ -1950089216, -1948778497 },// 139.196.0.0-139.215.255.255
				{ -1425539072, -1425014785 },// 171.8.0.0-171.15.255.255
				{ -1236271104, -1235419137 },// 182.80.0.0-182.92.255.255
				{ -770113536, -768606209 },// 210.25.0.0-210.47.255.255
				{ -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
		};

		Random rdint = new Random();
		int index = rdint.nextInt(10);
		String ip = num2ip(range[index][0]
				+ new Random().nextInt(range[index][1] - range[index][0]));
		return ip;
	}

	/*
	 * 将十进制转换成ip地址
	 */
	public static String num2ip(int ip)
	{
		int[] b = new int[4];
		String x = "";

		b[0] = (int) ((ip >> 24) & 0xff);
		b[1] = (int) ((ip >> 16) & 0xff);
		b[2] = (int) ((ip >> 8) & 0xff);
		b[3] = (int) (ip & 0xff);
		x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "."
				+ Integer.toString(b[2]) + "." + Integer.toString(b[3]);

		return x;
	}
}
