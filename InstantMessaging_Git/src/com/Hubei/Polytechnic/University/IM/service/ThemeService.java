package com.Hubei.Polytechnic.University.IM.service;

import java.util.List;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.model.Theme;

public interface ThemeService extends BaseDao<Theme>
{

	/**
	 * 根据用户手机号删除此用户所有主题
	 */
	void deleteByPhone(String phone);

	/**
	 * 根据时间和主题类型查找所有评论数大于五并且评论数最多的主题
	 */
	Theme getMaxCommentCountByTypeidAndTime(Long id);

}
