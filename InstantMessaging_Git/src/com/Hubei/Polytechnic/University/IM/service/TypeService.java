package com.Hubei.Polytechnic.University.IM.service;

import java.util.List;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Type;

public interface TypeService extends BaseDao<Type>
{

	/**
	 * 根据名称得到一个类型
	 * 
	 * @param name
	 * @return
	 */
	boolean getByName(String name);

	/**
	 * 返回所有类型的名称
	 * 
	 * @return
	 */
	List<String> getAllType();

	/**
	 * 返回所有类型的ID
	 * 
	 * @return
	 */
	List<Long> getAllTypeid();
}
