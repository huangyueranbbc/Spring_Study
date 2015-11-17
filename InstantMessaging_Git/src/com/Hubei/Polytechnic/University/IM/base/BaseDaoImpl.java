package com.Hubei.Polytechnic.University.IM.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.cfg.Configuration;
import com.Hubei.Polytechnic.University.IM.model.PageBean;
import com.Hubei.Polytechnic.University.IM.util.HqlHelper;

@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T>
{

	protected HibernateTemplate hibernateTemplate;
	protected Class<T> clazz; // 这是一个问题！

	public BaseDaoImpl()
	{
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];

		System.out.println("反射得到类的类型clazz 为:			 " + clazz.getName());
	}

	public void save(T entity)
	{
		hibernateTemplate.save(entity);
	}

	public void update(T entity)
	{
		hibernateTemplate.update(entity);
	}

	public void delete(Long id)
	{
		Object obj = hibernateTemplate.get(clazz, id);
		hibernateTemplate.delete(obj);
	}

	public T getById(Long id)
	{
		if (id == null)
		{
			return null;
		}
		return (T) hibernateTemplate.get(clazz, id);
	}

	public List<T> getByIds(Long[] ids)
	{
		if (ids == null || ids.length == 0)
		{
			return Collections.EMPTY_LIST;
		}
		return hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public List<T> findAll()
	{
		return hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName())//
				.list();
	}

	/**
	 * 最终版公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param hqlHelper
	 *            查询条件
	 * @return
	 */
	public PageBean getPageBean(int pageNum, HqlHelper hqlHelper)
	{
		// 获取三个计算的数据
		int pageSize = Configuration.getPageSize(); // 分页显示多少页
		List<Object> parameters = hqlHelper.getParameters();
		// 查询本页的数据列表
		Query listQuery = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createQuery(hqlHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0)
		{
			for (int i = 0; i < parameters.size(); i++)
			{
				listQuery.setParameter(i, parameters.get(i));
			}
		}

		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		// 查询总记录数
		Query countQuery = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0)
		{
			for (int i = 0; i < parameters.size(); i++)
			{
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(pageNum, pageSize, list, count.intValue());
	}

	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

}
