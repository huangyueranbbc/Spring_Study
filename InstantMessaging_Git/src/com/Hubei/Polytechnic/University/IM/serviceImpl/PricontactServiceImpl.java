package com.Hubei.Polytechnic.University.IM.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Pricontact;
import com.Hubei.Polytechnic.University.IM.service.PricontactService;

@Service(value = "pricontactserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class PricontactServiceImpl extends BaseDaoImpl<Pricontact> implements
		PricontactService
{

	/**
	 * 根据用户的ID找到权限关联表
	 * 
	 * @return
	 */
	public List<Pricontact> getByUserId(long userid)
	{
		System.out.println("user的类名:" + clazz.getSimpleName());
		return (List<Pricontact>) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM " + clazz.getSimpleName()
								+ " p WHERE p.userid = ?")
				.setParameter(0, userid).list();
	}

}
