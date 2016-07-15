package com.hyr.register.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.hyr.register.dao.UserDao;
import com.hyr.register.model.User;

@Component("userDaoImplement")
public class UserDaoImplement implements UserDao  {
		private HibernateTemplate hibernateTemplate;
		public void save(User user) {
			hibernateTemplate.save(user);
		}

		public boolean checkUserExistsWithName(String username) {
			//检查用户名是否存在
//			List<User> users=(List<User>) hibernateTemplate
//					.find("from userregister where username ='"+username+"'", username);
			List<User> users=(List<User>) hibernateTemplate
					.find("from userregister where username ='"+username+"'");
			if(users.size()>0&&users!=null){
				return true;
			}
			return false;
		}

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}
		@Resource(name="hibernateTemplate")
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		
}
