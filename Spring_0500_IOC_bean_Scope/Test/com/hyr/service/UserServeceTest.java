package com.hyr.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyr.model.User;

public class UserServeceTest {

	@Test
	public void testAdd() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");	//指定当前xml文件的位置和名称进行读取
		UserService userServece=(UserService) applicationContext.getBean("userService");
		UserService userServece2=(UserService) applicationContext.getBean("userService");
		assertTrue("不等于",userServece2==userServece);
		User user=new User();
		user.setPassword("666666");
		user.setUsername("root");
		userServece.add(user);
		
	}

}
