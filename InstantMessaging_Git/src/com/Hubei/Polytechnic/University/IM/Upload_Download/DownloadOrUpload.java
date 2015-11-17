package com.Hubei.Polytechnic.University.IM.Upload_Download;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import org.hibernate.result.Output;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.VersionDto;
import com.Hubei.Polytechnic.University.IM.model.Version;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class DownloadOrUpload extends ModelDrivenBaseAction<VersionDto>
{

	/** 下载 */
	public String download() throws Exception
	{
		Version version = versionService.getLastVersion();
		System.out.println("开始下载....下载版本:" + version.getVersion());
		// URL转码
		String fileName = URLEncoder.encode(version.getSoft_name(), "utf-8");
		// 准备下载的文件名
		ActionContext.getContext().put("fileName", fileName);
		System.out.println(fileName);
		File file = new File(version.getPath());
		ActionContext.getContext().put("fileLength", file.length());

		modeldto.setInputStream(new FileInputStream(version.getPath()));
		return "download";
	}

}
