package com.hyr.aop.Interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component(value="loginterceptor")
public class LogInterceptor {
	/*@Before("execution(* com.hyr..*(..))")
	public void beforestart() {
		System.out.println("method start");
	}
	
	@AfterReturning("execution(* com.hyr..*(..))")
	public void afterstart() {
		System.out.println("method end");
	}*/
	//������һ��֯��㼯��
//	@Pointcut("execution(* com.hyr..save(..))")
	public void myInterceptor() {
	}
	//�ڷ���ִ��֮ǰ
//	@Before("myInterceptor()")
	public void beforestart() {
		System.out.println("method start");
	}
	//�ڷ������쳣����֮��
//	@AfterReturning("myInterceptor())")
	public void afterstart() {
		System.out.println("method end");
	}
//	@Around("myInterceptor()")
	public Object aroundMethod1(ProceedingJoinPoint pjJoinPoint) throws Throwable{
		System.out.println("������һ start");
		Object object=pjJoinPoint.proceed();
		System.out.println("������һ end");
		return object;
	}
//	@Around("myInterceptor()")
	public Object aroundMethod2(ProceedingJoinPoint pjJoinPoint) throws Throwable{
		System.out.println("�������� start");
		Object object=pjJoinPoint.proceed();
		System.out.println("�������� end");
		return object;
	}
	
}
