package com.hyr.maven.helloMaven;

import org.junit.Assert;
import org.junit.Test;

public class helloWordlTest
{

	@Test
	public void testSayHello()
	{
		HelloWord helloWord = new HelloWord();
		String result = helloWord.sayHello();
		Assert.assertEquals("Hello Maven", result);
	} 

}
