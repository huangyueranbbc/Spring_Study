package com.hyr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Test;

import com.hyr.dao.UserDAO;
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

}
