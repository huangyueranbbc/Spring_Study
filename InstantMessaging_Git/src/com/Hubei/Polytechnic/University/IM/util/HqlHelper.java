package com.Hubei.Polytechnic.University.IM.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Hubei.Polytechnic.University.IM.base.BaseDao;
import com.Hubei.Polytechnic.University.IM.dto.ThemeDto;
import com.Hubei.Polytechnic.University.IM.model.PageBean;
import com.Hubei.Polytechnic.University.IM.model.Theme;
import com.Hubei.Polytechnic.University.IM.model.Type;
import com.Hubei.Polytechnic.University.IM.service.TypeService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用于辅助拼接生成HQL的工具类
 * 
 * @author tyg
 * 
 */
public class HqlHelper
{

	private String fromClause; // From子句，必须
	private String whereClause = ""; // Where子句，可选
	private String orderByClause = ""; // OrderBy子句，可选

	private List<Object> parameters = new ArrayList<Object>(); // 参数列表

	/**
	 * 生成From子句，默认的别名为'o'
	 * 
	 * @param clazz
	 */
	public HqlHelper(Class clazz)
	{
		this.fromClause = "FROM " + clazz.getSimpleName() + " o";
	}

	/**
	 * 生成From子句，使用指定的别。'
	 * 
	 * @param clazz
	 * @param alias
	 *            别名
	 */
	public HqlHelper(Class clazz, String alias)
	{
		this.fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}

	/**
	 * 拼接Where子句
	 * 
	 * @param condition
	 * @param params
	 */
	public HqlHelper addCondition(String condition, Object... params)
	{
		// 拼接
		if (whereClause.length() == 0)
		{
			whereClause = " WHERE " + condition;
		} else
		{
			whereClause += " AND " + condition;
		}

		// 保存参数
		if (params != null && params.length > 0)
		{
			for (Object obj : params)
			{
				parameters.add(obj);
			}
		}

		return this;
	}

	/**
	 * 如果第1个参数为true，则拼接Where子句
	 * 
	 * @param append
	 * @param condition
	 * @param params
	 */
	public HqlHelper addCondition(boolean append, String condition,
			Object... params)
	{
		if (append)
		{
			addCondition(condition, params);
		}
		return this;
	}

	/**
	 * 拼接OrderBy子句
	 * 
	 * @param propertyName
	 *            属性名
	 * @param isAsc
	 *            true表示升序，false表示降序
	 */
	public HqlHelper addOrder(String propertyName, boolean isAsc)
	{
		if (orderByClause.length() == 0)
		{
			orderByClause = " ORDER BY " + propertyName
					+ (isAsc ? " ASC" : " DESC");
		} else
		{
			orderByClause += ", " + propertyName + (isAsc ? " ASC" : " DESC");
		}
		return this;
	}

	/**
	 * 如果第1个参数为true，则拼接OrderBy子句
	 * 
	 * @param append
	 * @param propertyName
	 *            属性名
	 * @param isAsc
	 *            true表示升序，false表示降序
	 */
	public HqlHelper addOrder(boolean append, String propertyName, boolean isAsc)
	{
		if (append)
		{
			addOrder(propertyName, isAsc);
		}
		return this;
	}

	/**
	 * 获取生成的查询数据列表的HQL语句
	 * 
	 * @return
	 */
	public String getQueryListHql()
	{
		return fromClause + whereClause + orderByClause;
	}

	/**
	 * 获取生成的查询总记录数的HQL语句（没有OrderBy子句）
	 * 
	 * @return
	 */
	public String getQueryCountHql()
	{
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}

	/**
	 * 获取参数列表，与HQL过滤条件中的'?'一一对应
	 * 
	 * @return
	 */
	public List<Object> getParameters()
	{
		return parameters;
	}

	/**
	 * 查询并准备分页信息（放到栈顶）
	 * 
	 * @param pageNum
	 * @param service
	 * @return
	 */
	public HqlHelper buildPageBeanForStruts2(int pageNum, BaseDao<?> service)
	{
		System.out.println("============>分页数据　PageBean　准备完成<============");

		PageBean pageBean = service.getPageBean(pageNum, this);
		ActionContext.getContext().getValueStack().push(pageBean);
		return this;
	}

	/**
	 * 查询并准备Theme表的分页信息（放到栈顶）
	 * 
	 * @param pageNum
	 * @param service
	 * @return
	 */
	public HqlHelper buildThemePageBeanForStruts2(int pageNum,
			BaseDao<?> service, TypeService typeservice)
	{
		System.out.println("============>分页数据　PageBean　准备完成<============");

		PageBean pageBean = service.getPageBean(pageNum, this);
		List<Theme> themes = pageBean.getRecordList();
		List list = new ArrayList();
		for (Theme t : themes)
		{
			ThemeDto themeDto = new ThemeDto();
			themeDto.setCity(t.getCity());
			themeDto.setCollectioncount(t.getCollectioncount());
			themeDto.setCommentcount(t.getCommentcount());
			themeDto.setContent(t.getContent());
			themeDto.setCreatetime(t.getCreatetime());
			themeDto.setIp(t.getIp());
			themeDto.setLatitude(t.getLatitude());
			themeDto.setLongitude(t.getLongitude());
			themeDto.setId(t.getId());
			themeDto.setProvince(t.getProvince());
			themeDto.setThemepic(t.getThemepic());
			themeDto.setTypeid(t.getTypeid());
			Type type = (Type) typeservice.getById(t.getTypeid());
			// System.out.println("查询typename:"+type.getId()+" ========="+type.getName());
			themeDto.setTypename(type.getName());
			list.add(themeDto);
		}
		pageBean.setRecordList(list);
		Map<Long, String> types = new HashMap<Long, String>();
		List<String> typestrList = typeservice.getAllType();
		Long i = new Long(1);
		for (String s : typestrList)
		{
			types.put(i, s);
			System.out.println(i + ":" + s);
			i++;
		}
		types.put(null, "不选择");
		ActionContext.getContext().put("typelists", types);
		ActionContext.getContext().getValueStack().push(pageBean);
		return this;
	}

}
