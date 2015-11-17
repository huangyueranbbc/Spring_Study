package com.hyr.server.cxf.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class QuanXianLoginInterceptor extends
		AbstractPhaseInterceptor<SoapMessage>
{

	public QuanXianLoginInterceptor()
	{
		// 在调用之前进行拦截
		super(Phase.PRE_INVOKE);
	}

	// 实现自己拦截器，需要实现handleMessage方法。在此方法进行拦截逻辑处理
	// 该方法的参数就是被拦截到的soap消息。
	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault
	{
		System.out.println("aa" + soapMessage);
		// 获取soap消息的所有head信息(附加信息)
		List<Header> headers = soapMessage.getHeaders();
		// 如果没有head消息
		if (headers == null | headers.size() < 1)
		{
			throw new Fault(new IllegalArgumentException("不存在head消息,无法调用!"));
		}
		Header firstHeader = headers.get(0);
		Element element = (Element) firstHeader.getObject();
		NodeList userNameNodeList = element.getElementsByTagName("userName");
		NodeList userPasswdNodeList = element
				.getElementsByTagName("userPasswd");
		// 判断格式
		if (userNameNodeList.getLength() != 1)
		{
			throw new Fault(new IllegalArgumentException("用户名格式不对!"));
		}
		if (userPasswdNodeList.getLength() != 1)
		{
			throw new Fault(new IllegalArgumentException("密码格式不对!"));
		}
		// 获取String类型的文本内容
		String userName = userNameNodeList.item(0).getTextContent();
		String userPasswd = userPasswdNodeList.item(0).getTextContent();
		// 进行判断是否被授权，是否能够调用该Web Service方法
		if (!"root".equals(userName) | !"666666".equals(userPasswd))
		{
			throw new Fault(new IllegalArgumentException("该用户未被授权 无法访问!"));
		}
	}

}
