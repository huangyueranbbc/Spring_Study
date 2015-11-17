package com.Hubei.Polytechnic.University.IM.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hubei.Polytechnic.University.IM.base.BaseDaoImpl;
import com.Hubei.Polytechnic.University.IM.model.Theme;
import com.Hubei.Polytechnic.University.IM.service.ThemeService;

@Service(value = "themeserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class ThemeServiceImpl extends BaseDaoImpl<Theme> implements
		ThemeService
{

	/**
	 * 根据用户手机号删除此用户所有主题
	 * 
	 * @return
	 */
	public void deleteByPhone(String phone)
	{
		System.out.println("查询用户:" + phone + "所有主题");
		List<Theme> themes = hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM " + clazz.getSimpleName()
								+ " t WHERE t.phone = ?")
				.setParameter(0, phone).list();
		hibernateTemplate.deleteAll(themes);
	}

	/**
	 * 根据时间和主题类型查找所有评论数大于五并且评论数最多的主题
	 */
	public Theme getMaxCommentCountByTypeidAndTime(Long id)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
		Date date = new Date();
		String datestr = df.format(date);
		System.out.println(datestr);
		String startstr = datestr + "00:00:00";
		String endstr = datestr + "23:59:59";
		Date start = new Date();
		Date end = new Date();

		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			start = df.parse(startstr);
			end = df.parse(endstr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		System.out.println(start);
		System.out.println(end);
		return (Theme) hibernateTemplate
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						" FROM "
								+ clazz.getSimpleName()
								+ " t WHERE t.createtime>= ? AND t.createtime <= ? AND t.typeid = ? AND t.commentcount >= 5 ORDER BY  commentcount DESC")
				.setParameter(0, start).setParameter(1, end)
				.setParameter(2, id).setFirstResult(0).setMaxResults(1)
				.uniqueResult();
	}

}
