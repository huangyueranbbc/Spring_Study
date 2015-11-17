package com.Hubei.Polytechnic.University.IM.Push;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
import com.Hubei.Polytechnic.University.IM.dto.MessageDto;
import com.Hubei.Polytechnic.University.IM.model.Type;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class messagePushAction extends ModelDrivenBaseAction<MessageDto>
{

	protected static final Logger LOG = LoggerFactory
			.getLogger(LzstoneQuartzTask.class);

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
	 * 管理员消息推送页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendUI() throws Exception
	{
		// 准备数据
		List<String> typestrList = typeService.getAllType();
		Map<Long, String> types = new HashMap<Long, String>();

		Long i = new Long(1);
		for (String s : typestrList)
		{
			types.put(i, s);
			System.out.println(i + ":" + s);
			i++;
		}

		ActionContext.getContext().put("typelists", types);

		return "sendUI";
	}

	/**
	 * 管理员消息推送页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String send() throws Exception
	{
		String appKey = Configuration.getAppKey();
		String masterSecret = Configuration.getMasterSecret();

		// 准备数据
		System.out.println("进入发送逻辑!");
		List<String> typestrList = typeService.getAllType();
		System.out.println("1");
		List<Long> tags = modeldto.getTagList();
		System.out.println("2");
		for (Long id : tags)
		{
			System.out.println("333");
			Type type = typeService.getById(id);
			this.TAG = type.getName();
			this.ALERT = modeldto.getAlert();
			testSendPush(appKey, masterSecret);
		}

		return "tosendUI";
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
		PushPayload payload = buildPushObject_all_alias_alert();

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
				.setAudience(Audience.tag(TAG))
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

}
