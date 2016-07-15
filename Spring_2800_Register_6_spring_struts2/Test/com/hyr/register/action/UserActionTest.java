package com.hyr.register.action;

import org.junit.Assert;
import org.junit.Test;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction userAction=new UserAction();
		userAction.setUsername("6");
		userAction.setPassword("2");
		String ret=userAction.execute();
		Assert.assertEquals("success",ret);
	}
}
