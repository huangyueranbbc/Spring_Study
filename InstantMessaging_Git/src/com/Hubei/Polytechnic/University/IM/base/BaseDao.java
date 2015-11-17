package com.Hubei.Polytechnic.University.IM.base;

import java.util.List;

import com.Hubei.Polytechnic.University.IM.model.PageBean;
import com.Hubei.Polytechnic.University.IM.util.HqlHelper;

/**
 * @author Administrator
 *
 * @param <T>
 */
/**
 * @author Administrator
 *
 * @param <T>
 */
/**
 * @author Administrator
 * 
 * @param <T>
 */
public interface BaseDao<T>
{

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 查询实体
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * 查询实体 如果id为null,则返回null,不会抛出异常。
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 最终版公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param hqlHelper
	 *            查询条件
	 * @return
	 */
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);

}
