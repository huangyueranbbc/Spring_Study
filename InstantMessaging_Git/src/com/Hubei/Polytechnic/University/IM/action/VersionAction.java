package com.Hubei.Polytechnic.University.IM.action;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.VersionDto;
import com.Hubei.Polytechnic.University.IM.model.Version;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class VersionAction extends ModelDrivenBaseAction<VersionDto>
{

	private static final long serialVersionUID = -3258710987353957694L;

	/** 列表 */
	public String list() throws Exception
	{
		List<Version> versions = versionService.findAll();
		ActionContext.getContext().put("versionList", versions);

		return "list";
	}

	/** 发布页面 */
	public String addUI() throws Exception
	{
		// 准备模板数据定义数据
		HttpServletRequest httpRequest = ServletActionContext.getRequest();

		// String strBackUrl = "http://" + httpRequest.getServerName() //服务器地址
		// + ":"
		// + httpRequest.getServerPort() //端口号
		// + httpRequest.getContextPath();
		// System.out.println("网站的路径"+strBackUrl);
		return "addUI";
	}

	/** 发布 */
	public String add() throws Exception
	{
		// 封装
		String path = saveUploadFile(modeldto.getUpload());

		Version version = new Version();
		version.setPath(path);
		version.setSoft_name(modeldto.getSoft_name() + modeldto.getVersion());
		version.setTime(new Date());
		HttpServletRequest httpRequest = ServletActionContext.getRequest();

		String strBackUrl = "http://"
				+ httpRequest.getServerName() // 服务器地址
				+ ":"
				+ httpRequest.getServerPort() // 端口号
				+ httpRequest.getContextPath()
				+ "/downloadOrUpload_download.action";
		version.setVersion(modeldto.getVersion());
		version.setUrl(strBackUrl);
		System.out.println("软件的下载地址:" + strBackUrl);

		versionService.save(version);

		return "tolist";
	}

	/** 下载 */
	public String download() throws Exception
	{
		System.out.println("版本ID号:" + modeldto.getId());
		Version version = versionService.getById(modeldto.getId());
		System.out.println("开始下载....下载名称:" + version.getSoft_name());

		// URL转码
		String fileName = URLEncoder.encode(version.getSoft_name(), "utf-8");
		// 准备下载的文件名
		ActionContext.getContext().put("fileName", fileName);
		File file = new File(version.getPath());
		ActionContext.getContext().put("fileLength", file.length());
		modeldto.setInputStream(new FileInputStream(version.getPath()));

		return "download";
	}

	/** 删除该版本 应通过删除文件 */
	public String delete() throws Exception
	{
		System.out.println(modeldto.getId());
		Version version = versionService.getById(modeldto.getId());
		versionService.delete(version.getId());

		return "tolist";
	}
}
