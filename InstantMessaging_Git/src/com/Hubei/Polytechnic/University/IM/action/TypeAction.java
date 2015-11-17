package com.Hubei.Polytechnic.University.IM.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.TypeDto;
import com.Hubei.Polytechnic.University.IM.model.Type;
import com.Hubei.Polytechnic.University.IM.util.HqlHelper;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class TypeAction extends ModelDrivenBaseAction<TypeDto>
{

	/** 查看主题类型列表页面 */
	public String list() throws Exception
	{

		new HqlHelper(Type.class, "t").buildPageBeanForStruts2(
				modeldto.getPageNum(), typeService);
		System.out.println("显示根据主题类型进行搜索的主题列表！");
		return "list";
	}

	/** 主题类型修改页面 */
	public String updateUI() throws Exception
	{
		System.out.println("进入了修改主题类型方法！！");
		Type type = typeService.getById(modeldto.getId());
		System.out.println(type.getName());
		ActionContext.getContext().getValueStack().push(type);

		return "updateUI";
	}

	/** 主题类型修改 */
	public String update() throws Exception
	{
		System.out.println("开始执行主题类型修改！！");
		Type type = typeService.getById(modeldto.getId());
		type.setName(modeldto.getName());
		System.out.println("model:" + modeldto.getName());
		System.out.println("type:" + type.getName());
		typeService.update(type);
		System.out.println("========================================");
		System.out.println("model:" + modeldto.getName());
		System.out.println("type:" + type.getName());
		return "tolist";
	}

	/** 添加页面 */
	public String addUI() throws Exception
	{

		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception
	{
		Type type = new Type();
		type.setName(modeldto.getName());
		if (typeService.getByName(modeldto.getName()))
		{
			typeService.save(type);
			System.out.println("主题类型保存成功！");

		}
		System.out.println("已存在的主题");
		return "tolist";
	}

}
