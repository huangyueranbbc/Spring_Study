package com.Hubei.Polytechnic.University.IM.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.AdminDto;
import com.Hubei.Polytechnic.University.IM.model.Admin;
import com.Hubei.Polytechnic.University.IM.util.ResultUtils;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class AdminAction extends ModelDrivenBaseAction<AdminDto>
{

	/** 添加 */
	public String add() throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();

		Admin admin = new Admin();
		String passwdMD5 = DigestUtils.md5Hex("1");

		admin.setIp(ServletActionContext.getRequest().getRemoteAddr());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String szDatetime = df.format(new Date());
		admin.setLogintime(new Date());
		admin.setPhone("18212345678");
		admin.setPassword(passwdMD5);
		adminService.save(admin);
		System.out.println("保存成功");
		map.put("Admin", admin);
		ResultUtils.toJson(ServletActionContext.getResponse(), map);

		return null;
	}

	/**
	 * 管理员登陆页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginUI() throws Exception
	{

		return "loginUI";
	}

	/**
	 * 管理员登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception
	{
		// 服务端验证用户名和密码是否正确
		String loginFlag;
		Admin admin = adminService.getByPhoneAndPassword(modeldto.getPhone(),
				modeldto.getPassword());
		System.out.println("查询结束");
		if (admin == null)
		{
			// 用户名和密码不正确 添加错误 并使用国际化i18n资源。
			System.out.println("不存在此用户！");
			addFieldError("login", "用户名或密码错误");
			loginFlag = "loginUI";
		} else
		{
			// 正确 登陆用户
			System.out.println("存在此用户！");
			ActionContext.getContext().getSession().put("Admin", admin);
			System.out.println("Action中的Admin : "
					+ ActionContext.getContext().getSession().get("admin"));
			loginFlag = "toindex";
		}

		return loginFlag;
	}

	/**
	 * 管理员修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception
	{
		// 准备数据
		Admin admin = (Admin) ActionContext.getContext().getSession()
				.get("Admin");
		ActionContext.getContext().getValueStack().push(admin);

		return "show";
	}

	/**
	 * 管理员注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception
	{
		Admin admin = (Admin) ActionContext.getContext().getSession()
				.get("Admin");
		admin.setIp(ServletActionContext.getRequest().getRemoteAddr());
		admin.setLogintime(new Date());
		adminService.update(admin);

		ActionContext.getContext().getSession().remove("Admin");
		return "logout";
	}

}
