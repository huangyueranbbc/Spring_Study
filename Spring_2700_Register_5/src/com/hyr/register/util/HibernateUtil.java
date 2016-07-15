package com.hyr.register.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		// ����serviceRegistry
		ServiceRegistry serviceRegistry = new 		StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties()).build();
		// ��ȡsessionFactory
		SessionFactory sessionFactory = configuration
		.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
