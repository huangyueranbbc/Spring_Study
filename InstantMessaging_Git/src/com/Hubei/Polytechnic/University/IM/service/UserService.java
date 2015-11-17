package com.Hubei.Polytechnic.University.IM.service;

import java.util.Date;
import java.util.List;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.User;

public interface UserService extends BaseDao<User>
{

	/**
	 * 查询用户
	 * 
	 * @param phone
	 * @param password
	 *            明文密码
	 * @return
	 */
	User getByPhoneAndPassword(String phone, String password);

	/**
	 * 根据年月取出该年该月的注册的所有用户
	 * */
	List<User> getByYearAndMonth(String date);

	/**
	 * 返回注册用户的总数量
	 * 
	 * @return
	 */
	Long getAllUserCount();

	/**
	 * 返回当天注册的用户总数
	 * 
	 * @return
	 */
	Long getByDate(String string);
}
