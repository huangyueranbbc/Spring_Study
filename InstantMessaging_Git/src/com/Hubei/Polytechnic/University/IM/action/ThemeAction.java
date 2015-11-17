package com.Hubei.Polytechnic.University.IM.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.ThemeDto;
import com.Hubei.Polytechnic.University.IM.model.Reply;
import com.Hubei.Polytechnic.University.IM.model.Theme;
import com.Hubei.Polytechnic.University.IM.model.Type;
import com.Hubei.Polytechnic.University.IM.util.HqlHelper;
import com.Hubei.Polytechnic.University.IM.util.ResultUtils;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class ThemeAction extends ModelDrivenBaseAction<ThemeDto>
{

	/** 列表 */
	public String list() throws Exception
	{
		new HqlHelper(Theme.class).buildThemePageBeanForStruts2(
				modeldto.getPageNum(), themeService, typeService);

		return "list";
	}

	/** 对主题进行筛选显示 */
	public String listbycheck() throws Exception
	{
		System.out.println("主题ID：" + modeldto.getThemebytypeid());
		if (modeldto.getThemebytypeid() == 0)
		{
			if (modeldto.getPhone().equals(""))
			{
				modeldto.setPhone(null);
			}
			if (modeldto.getPhone() == null)
			{
				new HqlHelper(Theme.class, "t").addCondition(
						"t.content LIKE '%" + modeldto.getKeyword() + "%'")
						.buildThemePageBeanForStruts2(modeldto.getPageNum(),
								themeService, typeService);
			} else
			{
				new HqlHelper(Theme.class, "t")
						.addCondition("t.phone=?", modeldto.getPhone())
						.addCondition(
								"t.content LIKE '%" + modeldto.getKeyword()
										+ "%'")
						.buildThemePageBeanForStruts2(modeldto.getPageNum(),
								themeService, typeService);
			}
		} else
		{
			if (modeldto.getPhone().equals(""))
			{
				modeldto.setPhone(null);
			}
			if (modeldto.getPhone() == null)
			{
				new HqlHelper(Theme.class, "t")
						.addCondition("t.typeid=?", modeldto.getThemebytypeid())
						.addCondition(
								"t.content LIKE '%" + modeldto.getKeyword()
										+ "%'")
						.buildThemePageBeanForStruts2(modeldto.getPageNum(),
								themeService, typeService);
			} else
			{
				new HqlHelper(Theme.class, "t")
						.addCondition("t.typeid=?", modeldto.getThemebytypeid())
						.addCondition("t.phone=?", modeldto.getPhone())
						.addCondition(
								"t.content LIKE '%" + modeldto.getKeyword()
										+ "%'")
						.buildThemePageBeanForStruts2(modeldto.getPageNum(),
								themeService, typeService);
			}
		}

		System.out.println("显示根据主题类型进行搜索的主题列表！");
		return "list";
	}

	/** 显示具体主题内容 */
	public String show() throws Exception
	{
		// 准备数据
		Theme theme = themeService.getById(modeldto.getId());
		ActionContext.getContext().getValueStack().push(theme);
		new HqlHelper(Reply.class, "r").addCondition("r.themeid=?",
				theme.getId()).buildPageBeanForStruts2(1, replyService);

		return "show";
	}

	/** 删除 */
	public String delete() throws Exception
	{
		themeService.delete(modeldto.getId());
		replyService.deleteByThemeId(modeldto.getId());
		System.out.println("删除成功！");
		return "tolist";
	}

}
