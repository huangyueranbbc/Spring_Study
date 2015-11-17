package com.Hubei.Polytechnic.University.IM.service;

import java.util.List;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Pricontact;

public interface PricontactService extends BaseDao<Pricontact>
{

	/**
	 * 根据用户的ID找到权限关联表
	 * 
	 * @return
	 */
	List<Pricontact> getByUserId(long userid);

}
