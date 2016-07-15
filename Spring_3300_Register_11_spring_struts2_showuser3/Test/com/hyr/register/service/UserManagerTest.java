package com.hyr.register.service;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hyr.register.dto.UserRegisterDto;
import com.hyr.register.model.User;
import com.hyr.register.service.impl.UserManagerImplement;

public class UserManagerTest {	
	@Test
	public void testExists() {
		UserManager userManager =new UserManagerImplement();
		User user=new User(new UserRegisterDto());
		user.setUsername("qq");
		user.setPassword("b");
		boolean exist=userManager.exists(user);
		Assert.assertEquals(true,exist);
	}
	@Test
	public void testAdd() {
		UserManager userManager =new UserManagerImplement();
		User user=new User(new UserRegisterDto());
		user.setUsername("qq2");
		user.setPassword("b");
		if(!userManager.exists(user)){
			userManager.add(user);
			user.setUsername("qq2");
			Assert.assertEquals(true, userManager.exists(user));
		}else {
			Assert.fail("≤Â»Î ß∞‹");
		}

	}

}
