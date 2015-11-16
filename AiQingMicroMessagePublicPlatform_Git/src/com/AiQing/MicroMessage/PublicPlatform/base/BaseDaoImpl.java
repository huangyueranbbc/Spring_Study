package com.AiQing.MicroMessage.PublicPlatform.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected HibernateTemplate hibernateTemplate;
	protected Class<T> clazz; // 这是一个问题！

	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];

		System.out.println("反射得到类的类型clazz 为:			 " + clazz.getName());
	}

	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	public void delete(Long id) {
		Object obj = hibernateTemplate.get(clazz, id);
		hibernateTemplate.delete(obj);
	}

	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) hibernateTemplate.get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public List<T> findAll() {
		return hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(//
						"FROM " + clazz.getSimpleName())//
				.list();
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
