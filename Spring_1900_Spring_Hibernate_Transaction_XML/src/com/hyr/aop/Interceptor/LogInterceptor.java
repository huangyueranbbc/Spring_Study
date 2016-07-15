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
	//声明是一个织入点集合
//	@Pointcut("execution(* com.hyr..save(..))")
	public void myInterceptor() {
	}
	//在方法执行之前
//	@Before("myInterceptor()")
	public void beforestart() {
		System.out.println("method start");
	}
	//在方法无异常结束之后
//	@AfterReturning("myInterceptor())")
	public void afterstart() {
		System.out.println("method end");
	}
//	@Around("myInterceptor()")
	public Object aroundMethod1(ProceedingJoinPoint pjJoinPoint) throws Throwable{
		System.out.println("拦截器一 start");
		Object object=pjJoinPoint.proceed();
		System.out.println("拦截器一 end");
		return object;
	}
//	@Around("myInterceptor()")
	public Object aroundMethod2(ProceedingJoinPoint pjJoinPoint) throws Throwable{
		System.out.println("拦截器二 start");
		Object object=pjJoinPoint.proceed();
		System.out.println("拦截器二 end");
		return object;
	}
	
}
