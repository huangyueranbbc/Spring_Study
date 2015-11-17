package com.Hubei.Polytechnic.University.IM.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.Hubei.Polytechnic.University.IM.model.User;
import com.Hubei.Polytechnic.University.IM.service.AdminService;
import com.Hubei.Polytechnic.University.IM.service.PricontactService;
import com.Hubei.Polytechnic.University.IM.service.ReplyService;
import com.Hubei.Polytechnic.University.IM.service.ThemeService;
import com.Hubei.Polytechnic.University.IM.service.TypeService;
import com.Hubei.Polytechnic.University.IM.service.UserService;
import com.Hubei.Polytechnic.University.IM.service.VersionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport
{
	protected UserService userService;
	protected PricontactService pricontactService;
	protected ThemeService themeService;
	protected TypeService typeService;
	protected ReplyService replyService;
	protected AdminService adminService;
	protected VersionService versionService;

	/**
	 * 返回当前登录的用户
	 * 
	 * @return
	 */
	protected User getCurrentUser()
	{
		return (User) ActionContext.getContext().getSession().get("user");
	}

	/**
	 * 保存上传的文件 并返回文件在服务器端的保存路径
	 * 
	 * @param uploadTemp
	 * @return
	 */
	protected String saveUploadFile(File uploadTemp)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String basepath = ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/upload_download_file");
		String datepath = sdf.format(new Date());
		String path = basepath + datepath + UUID.randomUUID();
		// 如果文件夹不存在 就创建
		File dir = new File(basepath + datepath);
		if (!dir.exists())
		{
			dir.mkdirs(); // 不存在就递归创建
		}
		// 移动目录
		uploadTemp.renameTo(new File(path));
		// modeldto.setUpload(modeldto.getUpload().renameTo(new File(path)));
		return path;
	}

	public UserService getUserService()
	{
		return userService;
	}

	@Resource(name = "userserviceimplement")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public PricontactService getPricontactService()
	{
		return pricontactService;
	}

	@Resource(name = "pricontactserviceimplement")
	public void setPricontactService(PricontactService pricontactService)
	{
		this.pricontactService = pricontactService;
	}

	public ThemeService getThemeService()
	{
		return themeService;
	}

	@Resource(name = "themeserviceimplement")
	public void setThemeService(ThemeService themeService)
	{
		this.themeService = themeService;
	}

	public TypeService getTypeService()
	{
		return typeService;
	}

	@Resource(name = "typeserviceimplement")
	public void setTypeService(TypeService typeService)
	{
		this.typeService = typeService;
	}

	public ReplyService getReplyService()
	{
		return replyService;
	}

	@Resource(name = "replyserviceimplement")
	public void setReplyService(ReplyService replyService)
	{
		this.replyService = replyService;
	}

	public AdminService getAdminService()
	{
		return adminService;
	}

	@Resource(name = "adminserviceimplement")
	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}

	public VersionService getVersionService()
	{
		return versionService;
	}

	@Resource(name = "versionserviceimplement")
	public void setVersionService(VersionService versionService)
	{
		this.versionService = versionService;
	}

}
