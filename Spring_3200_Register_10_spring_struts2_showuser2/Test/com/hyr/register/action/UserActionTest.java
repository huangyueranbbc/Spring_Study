package com.hyr.register.action;

import java.util.List;

import javax.faces.application.Application;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bbc.hyr.register.action.UserAction;
import com.hyr.register.dto.UserRegisterDto;
import com.hyr.register.model.User;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction userAction=new UserAction();
		UserRegisterDto userRegisterDto=new UserRegisterDto();
		userRegisterDto.setUsername("a");
		userRegisterDto.setPassword("a");
		userAction.setUserRegisterDto(userRegisterDto);
		String ret=userAction.execute();
		Assert.assertEquals("success",ret);
	}
	@Test
	public void showuserlist() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		UserAction userAction=(UserAction) applicationContext.getBean("userAction");
		userAction.list();
		List<User> users=userAction.getUsers();
		for(User user:users){
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("======================================");
		}
		Assert.assertTrue(userAction.getUsers().size()>0);
	}
	
	@Test
	public void showuser() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		UserAction userAction=(UserAction) applicationContext.getBean("userAction");
		userAction.setId(24);
		userAction.load();
		List<User> users=userAction.getUsers();
		for(User user:users){
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("======================================");
		}
		Assert.assertTrue(userAction.getUsers().size()>0);
	}
}



