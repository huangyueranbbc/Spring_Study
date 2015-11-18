package com.hyr.maven.helloMaven;


public class HelloWord
{
	public String sayHello()
	{
		return "Hello Maven";

	}

	public static void main(String[] args)
	{
		System.out.println(new HelloWord().sayHello());
	}
}
