package com.Hubei.Polytechnic.University.IM.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.Hubei.Polytechnic.University.IM.base.ModelDrivenBaseAction;
import com.Hubei.Polytechnic.University.IM.dto.ReplyDto;
import com.Hubei.Polytechnic.University.IM.model.Reply;
import com.Hubei.Polytechnic.University.IM.util.ResultUtils;

@Component
@Scope("prototype")
public class ReplyAction extends ModelDrivenBaseAction<ReplyDto>
{
	/** 添加 */
	public String add() throws Exception
	{

		System.out.println("执行了");
		try
		{
			Map<String, Object> map = new HashMap<String, Object>();

			Reply reply = new Reply();
			reply.setPhone("18212345678");
			reply.setContent("洗衣机，我喜欢你！");
			reply.setCreatetime(new Date());
			reply.setThemeid(1);

			System.out.println("保存");
			replyService.save(reply);
			System.out.println("保存成功");
			map.put("Theme", reply);

			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
