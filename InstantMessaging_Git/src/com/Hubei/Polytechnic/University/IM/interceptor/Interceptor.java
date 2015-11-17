package com.Hubei.Polytechnic.University.IM.interceptor;

import com.Hubei.Polytechnic.University.IM.model.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor
{

	/**
	 * 自定义权限拦截器
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{

		System.out.println("拦截器开启！！！");
		// 获取当前用户
		Admin admin = (Admin) ActionContext.getContext().getSession()
				.get("Admin");

		System.out.println("Admin : " + admin);
		if (admin == null)
		{
			System.out.println("拦截器未找到该用户");
			return "loginUI";
		} else
		{
			return invocation.invoke();
		}
	}

}
