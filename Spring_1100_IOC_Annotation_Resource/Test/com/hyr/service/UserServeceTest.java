package com.hyr.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyr.model.User;

public class UserServeceTest {

	@Test
	public void testAdd() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");	//ָ����ǰxml�ļ���λ�ú���ƽ��ж�ȡ
		UserService userServece=(UserService) applicationContext.getBean("userService");
		UserService userServece1=(UserService) applicationContext.getBean("userService");
		User user=new User();
		user.setPassword("666666");
		user.setUsername("root");
		userServece.add(user);
		applicationContext.destroy();
	}

}
