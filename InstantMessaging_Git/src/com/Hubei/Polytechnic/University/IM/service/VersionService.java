package com.Hubei.Polytechnic.University.IM.service;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Version;

public interface VersionService extends BaseDao<Version>
{

	/**
	 * 返回最新的版本数据
	 * */
	Version getLastVersion();

}
