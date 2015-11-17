package com.Hubei.Polytechnic.University.IM.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Type;
import com.Hubei.Polytechnic.University.IM.service.TypeService;

@Service(value = "typeserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class TypeServiceImpl extends BaseDaoImpl<Type> implements TypeService
{

	/**
	 * 根据名称得到一个类型
	 * 
	 * @param name
	 * @return
	 */
	public boolean getByName(String name)
	{
		List<Type> types = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"From " + clazz.getSimpleName() + " t WHERE t.name = ?")
				.setParameter(0, name).list();
		if (types.size() == 0)
		{
			// 如果不存在 返回true
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * 返回所有类型的名称
	 * 
	 * @return
	 */
	public List<String> getAllType()
	{
		System.out.println("alltype.class:" + clazz.getSimpleName());
		return hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery("Select name From " + clazz.getSimpleName() + " t")
				.list();
	}

	/**
	 * 返回所有类型的ID
	 * 
	 * @return
	 */
	public List<Long> getAllTypeid()
	{
		return hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("Select id From " + clazz.getSimpleName() + " t")
				.list();
	}

}
