package com.Hubei.Polytechnic.University.IM.Push;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.cfg.Configuration;
import com.Hubei.Polytechnic.University.IM.model.Theme;

public class LzstoneQuartzTask extends ModelDrivenBaseAction<Theme>
{
	protected static final Logger LOG = LoggerFactory
			.getLogger(LzstoneQuartzTask.class);

	// demo App defined in resources/jpush-api.conf

	public static final String TITLE = "欢迎登陆UC";
	public static String ALERT = "欢迎登陆UC";
	public static final String MSG_CONTENT = "欢迎登陆UC";
	public static final String REGISTRATION_ID = "0900e8d85ef";
	public static String TAG = "all";
	public static String MAP_KEY;
	public static Long MAP_VALUE;
	public static Set<String> TAGSET = new HashSet<String>();

	public static JPushClient jpushClient = null;

	/**
	 * 执行的定时器任务
	 * */
	// 每天 8点 10点 12点 14点 16点 18点 20点 22点进行推送
	public void timingPushTheme()
	{

		String appKey = Configuration.getAppKey();
		String masterSecret = Configuration.getMasterSecret();

		List<Long> typeids = typeService.getAllTypeid();
		List<String> typenames = typeService.getAllType();
		int typenameindex = 0;
		// 取出当天所有类型的主题中评论最多平且大于5的主题
		List<Theme> themes = new ArrayList<Theme>();
		for (Long id : typeids)
		{
			themes.add(themeService.getMaxCommentCountByTypeidAndTime(id));
		}

		for (Theme theme : themes)
		{
			System.out.println(theme);
			if (theme != null)
			{
				this.setALERT("有最新的" + typenames.get(typenameindex)
						+ "活动发布了，快去瞅瞅吧！");
				this.setTAG(typenames.get(typenameindex));
				this.setMAP_KEY(typenames.get(typenameindex));
				this.setMAP_VALUE(theme.getId());
				typenameindex++;
				testSendPush(appKey, masterSecret);
			} else
			{
				System.out.println("没有新主题！");
			}

		}

		System.out.println(new Date() + ":执行了一次！");
	}

	public static void testSendPush(String appKey, String masterSecret)
	{
		jpushClient = new JPushClient(masterSecret, appKey, 3);
		// HttpProxy proxy = new HttpProxy("localhost", 3128);
		// Can use this https proxy: https://github.com/Exa-Networks/exaproxy

		// For push, all you need do is to build PushPayload object.
		// PushPayload payload = buildPushObject_all_all_alert();
		// 生成推送的内容，这里我们先测试全部推送
		JPushInterface.filterValidTags(TAGSET);
		PushPayload payload = buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();

		try
		{
			System.out.println(payload.toString());
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result + "................................");

			LOG.info("Got result - " + result);

		} catch (APIConnectionException e)
		{
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e)
		{
			LOG.error(
					"Error response from JPush server. Should review and fix it. ",
					e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}

	public static PushPayload buildPushObject_all_all_alert()
	{
		return PushPayload.alertAll(ALERT);
	}

	public static PushPayload buildPushObject_all_alias_alert()
	{
		return PushPayload.newBuilder().setPlatform(Platform.all())
				// 设置接受的平台
				.setAudience(Audience.all())
				// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setNotification(Notification.alert(ALERT))
				.setMessage(Message.content(MSG_CONTENT)).build();
	}

	public static PushPayload buildPushObject_android_tag_alertWithTitle()
	{
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.all())
				.setNotification(Notification.android(ALERT, TITLE, null))
				.build();
	}

	public static PushPayload buildPushObject_android_and_ios()
	{
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag("tag1"))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert("alert content")
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle("Android Title")
												.build())
								.addPlatformNotification(
										IosNotification
												.newBuilder()
												.incrBadge(1)
												.addExtra("extra_key",
														"extra_value").build())
								.build()).build();
	}

	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage()
	{
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag(TAG))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setAlert(ALERT)
												.addExtra(MAP_KEY, MAP_VALUE)// br
												.build()).build())
				.setMessage(Message.content(MSG_CONTENT))
				.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
				.build();
	}

	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras()
	{
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(
						Audience.newBuilder()
								.addAudienceTarget(
										AudienceTarget.tag("社团活动", "tag2"))
								.addAudienceTarget(
										AudienceTarget
												.alias("alias1", "alias2"))
								.build())
				.setMessage(
						Message.newBuilder().setMsgContent(MSG_CONTENT)
								.addExtra("from", "JPush").build()).build();
	}

	public static String getALERT()
	{
		return ALERT;
	}

	public static void setALERT(String aLERT)
	{
		ALERT = aLERT;
	}

	public static String getTAG()
	{
		return TAG;
	}

	public static void setTAG(String tAG)
	{
		TAG = tAG;
	}

	public static String getMAP_KEY()
	{
		return MAP_KEY;
	}

	public static void setMAP_KEY(String mAP_KEY)
	{
		MAP_KEY = mAP_KEY;
	}

	public static Long getMAP_VALUE()
	{
		return MAP_VALUE;
	}

	public static void setMAP_VALUE(Long mAP_VALUE)
	{
		MAP_VALUE = mAP_VALUE;
	}

}