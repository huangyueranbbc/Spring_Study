package com.hyr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServeceTest {

	@Test
	public void testAdd() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");	//指定当前xml文件的位置和名称进行读取
		UserService userServece=(UserService) applicationContext.getBean("userService");
		
		System.out.println(userServece.getUserDAO());

		
	}

}
