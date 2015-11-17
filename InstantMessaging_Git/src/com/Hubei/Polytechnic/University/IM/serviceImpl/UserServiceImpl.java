package com.Hubei.Polytechnic.University.IM.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.User;
import com.Hubei.Polytechnic.University.IM.service.UserService;

@Service(value = "userserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService
{

	/**
	 * 查询用户
	 * 
	 * @param phone
	 * @param password
	 *            明文密码
	 * @return
	 */
	public User getByPhoneAndPassword(String phone, String password)
	{
		return (User) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM " + clazz.getSimpleName()
								+ " u WHERE u.phone = ? AND u.password = ?")
				.setParameter(0, phone)
				.setParameter(1, DigestUtils.md5Hex(password)) // 使用MD5明文加密
				.uniqueResult();
	}

	/**
	 * 根据年月取出该年该月的注册的所有用户
	 * */
	public List<User> getByYearAndMonth(String date)
	{
		// 将字符串格式转为date格式 分为最小日期和最大日期
		Calendar calendar = Calendar.getInstance();
		int maxday = calendar.getMaximum(Calendar.DATE);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startstr = date + "-0" + 1 + " 00:00:00";
		String endstr = date + "-" + maxday + " 23:59:59";
		Date start = new Date();
		Date end = new Date();
		try
		{
			start = df.parse(startstr);
			end = df.parse(endstr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		System.out.println(start);
		System.out.println(end);
		return hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM " + clazz.getSimpleName()
								+ " u WHERE u.regtime>= ? AND u.regtime <= ?")
				.setParameter(0, start).setParameter(1, end).list();
	}

	/**
	 * 返回注册用户的总数量
	 * 
	 * @return
	 */
	public Long getAllUserCount()
	{
		String hql = "select count(*) from " + clazz.getSimpleName()
				+ " as user";
		System.out.println(hql);
		return (Long) hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql).uniqueResult();
	}

	/**
	 * 返回当天注册的用户总数
	 * 
	 * @return
	 */
	public Long getByDate(String date)
	{
		// 获得当天最小时间和最大时间
		String startstr = date + " 00:00:00";
		String endstr = date + " 23:59:59";
		Date start = new Date();
		Date end = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			start = df.parse(startstr);
			end = df.parse(endstr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		System.out.println(start);
		System.out.println(end);

		// 创建HQL语句
		String hql = "select count(*) from " + clazz.getSimpleName()
				+ " as user WHERE user.regtime>= ? AND user.regtime <= ?";

		System.out.println(hql);
		return (Long) hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql).setParameter(0, start).setParameter(1, end)
				.uniqueResult();
	}

}
