package com.Hubei.Polytechnic.University.IM.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Reply;
import com.Hubei.Polytechnic.University.IM.service.ReplyService;

@Service(value = "replyserviceimplement")
@Transactional
public class ReplyServiceImpl extends BaseDaoImpl<Reply> implements
		ReplyService
{

	/**
	 * 根据主题ID删除所有评论
	 */
	public void deleteByThemeId(long id)
	{
		@SuppressWarnings("unchecked")
		List<Reply> replies = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"From " + clazz.getSimpleName()
								+ " r WHERE r.themeid = ?").setParameter(0, id)
				.list();
		hibernateTemplate.deleteAll(replies);
	}

	/**
	 * 根据用户ID删除所有评论
	 */
	public void deleteByPhone(String phone)
	{
		@SuppressWarnings("unchecked")
		List<Reply> replies = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"From " + clazz.getSimpleName()
								+ " r WHERE r.phone = ?")
				.setParameter(0, phone).list();
		hibernateTemplate.deleteAll(replies);
	}

}
