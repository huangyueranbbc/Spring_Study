package com.Hubei.Polytechnic.University.IM.cfg;

/**
 * 对应配置的对象（对应default.properties）
 * 
 * @author tyg
 * 
 */
public class Configuration
{

	private static int pageSize;
	private static String appKey;
	private static String masterSecret;

	static
	{
		// TODO 读取配置default.properties文件，并初始化所有配置
		pageSize = 10;
		appKey = "68791ca853584a16040dcdbc";
		masterSecret = "bf54f2cc6dd74d1417efa2bb";
	}

	public static int getPageSize()
	{
		return pageSize;
	}

	public static String getAppKey()
	{
		return appKey;
	}

	public static String getMasterSecret()
	{
		return masterSecret;
	}

}
