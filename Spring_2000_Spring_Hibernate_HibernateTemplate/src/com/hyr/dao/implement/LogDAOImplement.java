package com.hyr.dao.implement;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jms.core.SessionCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.hyr.dao.LogDAO;
import com.hyr.model.Log;

@Component("logDAO")
public class LogDAOImplement implements LogDAO{
	
//	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	@Override
	public void save(Log log) {
		hibernateTemplate.save(log);
	}
/*	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
