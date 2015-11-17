package com.Hubei.Polytechnic.University.IM.service;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Reply;

public interface ReplyService extends BaseDao<Reply>
{

	/**
	 * 根据主题ID删除所有评论
	 */
	void deleteByThemeId(long id);

	/**
	 * 根据用户ID删除所有评论
	 */
	void deleteByPhone(String phone);

}
