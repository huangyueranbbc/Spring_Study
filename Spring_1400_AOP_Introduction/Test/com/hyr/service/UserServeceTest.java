package com.hyr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import org.jdom.JDOMException;
import org.junit.Test;

import com.hyr.aop.Proxy.LogInterceptor;
import com.hyr.dao.UserDAO;
import com.hyr.dao.implement.UserDAOJDBCImplement;
import com.hyr.model.User;
import com.hyr.spring.BeanFactory;
import com.hyr.spring.ClassPathXmlApplicationContext;

public class UserServeceTest {

	@Test
	public void testAdd() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext();
		UserService userServece=(UserService) beanFactory.getBean("userService");
		
		User user=new User();
		userServece.add(user);
		
	}

	@Test
	public void AOPProxy(){
		UserDAO UDJI=new UserDAOJDBCImplement();
		LogInterceptor logi=new LogInterceptor(UDJI);
		//生成一个代理对象
		UserDAO userDAOProxy =(UserDAO) Proxy.newProxyInstance(UserDAOJDBCImplement.class.getClassLoader(), 
				new Class[]{UserDAO.class}, logi);
		userDAOProxy.save(new User());
	}
}
