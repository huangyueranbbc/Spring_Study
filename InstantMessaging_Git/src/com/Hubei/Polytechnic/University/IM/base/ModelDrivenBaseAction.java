package com.Hubei.Polytechnic.University.IM.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ModelDriven;

public abstract class ModelDrivenBaseAction<T> extends BaseAction implements
		ModelDriven<T>
{

	protected T modeldto;

	public ModelDrivenBaseAction()
	{
		try
		{
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			System.out.println("modelclass=" + clazz.getName());
			this.modeldto = (T) clazz.newInstance();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T getModel()
	{
		// TODO Auto-generated method stub
		return this.modeldto;
	}

}
