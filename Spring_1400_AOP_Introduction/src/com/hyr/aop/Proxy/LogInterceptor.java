package com.hyr.aop.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.util.Date;

public class LogInterceptor implements InvocationHandler,Runnable {
	private Object	target;
	
	public LogInterceptor(Object target) {
		super();
		this.target = target;
	}

	public void Before() {
		System.out.println("�������:"+new Date().getTime());
	}
	
	public void after() {
		System.out.println("�������:"+new Date().getTime());
	}
	//�ô������ͨ��invoke�����ҵ����������ķ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
			Before();
			method.invoke(target, args);
			try {
				Thread.sleep(14254);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			after();
			return null;	
	}

	@Override
	public void run() {
		System.out.println("a");
		
	}

}
