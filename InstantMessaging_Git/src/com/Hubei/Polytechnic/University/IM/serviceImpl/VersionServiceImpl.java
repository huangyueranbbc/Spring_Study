package com.Hubei.Polytechnic.University.IM.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Version;
import com.Hubei.Polytechnic.University.IM.service.VersionService;

@Service(value = "versionserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class VersionServiceImpl extends BaseDaoImpl<Version> implements
		VersionService
{

	/**
	 * 返回最新的版本数据
	 * */
	public Version getLastVersion()
	{
		return (Version) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"From " + clazz.getSimpleName()
								+ " t ORDER BY (t.version+0) DESC")
				.setFirstResult(0).setMaxResults(1).uniqueResult();
	}

}
