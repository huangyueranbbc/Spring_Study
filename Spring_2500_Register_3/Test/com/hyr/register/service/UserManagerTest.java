package com.hyr.register.service;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hyr.register.model.User;

public class UserManagerTest {
	

	
	@Test
	public void testExists() {
		UserManager userManager =new UserManager();
		User user=new User();
		user.setUsername("qq");
		user.setPassword("b");
		boolean exist=userManager.exists(user);
		Assert.assertEquals(true,exist);
	}

	@Test
	public void testAdd() {
		UserManager userManager =new UserManager();
		User user=new User();
		user.setUsername("qq1");
		user.setPassword("b");
		if(!userManager.exists(user)){
			userManager.add(user);
			user.setUsername("qq");
			Assert.assertEquals(true, userManager.exists(user));
		}else {
			Assert.fail("²åÈëÊ§°Ü");
		}

	}

}
