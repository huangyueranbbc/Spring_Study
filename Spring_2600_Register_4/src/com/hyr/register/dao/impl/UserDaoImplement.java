package com.hyr.register.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hyr.register.dao.UserDao;
import com.hyr.register.model.User;
import com.hyr.register.util.HibernateUtil;

public class UserDaoImplement implements UserDao  {
		public void save(User user) {
			HibernateUtil hibernateUtil=new HibernateUtil();
			SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}

		public boolean checkUserExistsWithName(String username) {
			//检查用户名是否存在
			HibernateUtil hibernateUtil=new HibernateUtil();
			SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query q = session.createQuery("from userregister where username = '"+username+"'");
			List<User> categories = (List<User>)q.list();
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
			if(categories.size()>0){
				return true;
			}
			return false;
		}
}
