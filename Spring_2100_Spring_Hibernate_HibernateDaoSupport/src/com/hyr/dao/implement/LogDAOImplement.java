package com.hyr.dao.implement;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.hyr.dao.LogDAO;
import com.hyr.model.Log;

@Component("logDAO")
public class LogDAOImplement extends HibernateDaoSupport implements LogDAO{
	
	@Override
	public void save(Log log) {
		getHibernateTemplate().save(log);
	}

}
