package com.Hubei.Polytechnic.University.IM.service;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Admin;

public interface AdminService extends BaseDao<Admin>
{

	/**
	 * 查询管理员
	 * 
	 * @param phone
	 * @param password
	 *            明文密码
	 * @return
	 */
	Admin getByPhoneAndPassword(String phone, String password);

}
