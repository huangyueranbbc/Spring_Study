package com.Hubei.Polytechnic.University.IM.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Admin;
import com.Hubei.Polytechnic.University.IM.service.AdminService;

@Service(value = "adminserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class AdminServiceImpl extends BaseDaoImpl<Admin> implements
		AdminService
{

	/**
	 * 查询管理员
	 * 
	 * @param phone
	 * @param password
	 *            明文密码
	 * @return
	 */
	public Admin getByPhoneAndPassword(String phone, String password)
	{
		System.out.println("查询管理员开始");
		System.out.println("PASSWORD : " + password);
		return (Admin) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM " + clazz.getSimpleName()
								+ " a WHERE a.phone = ? AND a.password = ?")
				.setParameter(0, phone)
				.setParameter(1, DigestUtils.md5Hex(password)) // 使用MD5明文加密
				.uniqueResult();
	}

}
