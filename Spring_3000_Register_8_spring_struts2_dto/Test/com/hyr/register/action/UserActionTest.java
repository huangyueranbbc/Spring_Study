package com.hyr.register.action;

import org.junit.Assert;
import org.junit.Test;

import com.bbc.hyr.register.action.UserAction;
import com.hyr.register.dto.UserRegisterDto;

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
}
