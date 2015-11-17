package com.hyr.client.cxf.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage>
{
	private String userName;
	private String userPasswd;

	public AddHeaderInterceptor(String username, String userpasswd)
	{
		// 在准备发送soap消息时调用
		super(Phase.PREPARE_SEND);
		this.userName = username;
		this.userPasswd = userpasswd;
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault
	{
		List<Header> headers = soapMessage.getHeaders();
		
		// 创建document对象
		Document document = DOMUtils.createDocument();
		Element element = document.createElement("userHeader");

		Element userNameeElement = document.createElement("userName");
		userNameeElement.setTextContent(this.userName);
		Element userPasswdeElement = document.createElement("userPasswd");
		userPasswdeElement.setTextContent(this.userPasswd);

		element.appendChild(userNameeElement);
		element.appendChild(userPasswdeElement);
		
		/*	
		 * 上面代码生成了一个如下的XML文档片段
		 * <userHeader>
		 * 			<userName>aaa<userName/>
		 * 			<userPasswd>bbb<userPasswd/>
		 * <userHeader/>
		 */
		
		//将该XML文档片段加入到Header节点中
		headers.add(new Header(new QName("userHeader"), element));
	}

}
