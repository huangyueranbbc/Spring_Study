package com.AiQing.MicroMessage.PublicPlatform.model;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlCDATA;

@Entity
@XmlRootElement(name = "xml")
public class WeChatReqBean {
	private Long id;
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private String content;

	private Double location_X;
	private Double location_Y;
	private Integer scale;
	private String label;

	private Long msgId;

	public String getToUserName() {
		return toUserName;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlCDATA
	@XmlElement(name = "ToUserName")
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	@XmlCDATA
	@XmlElement(name = "FromUserName")
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	@XmlCDATA
	@XmlElement(name = "MsgType")
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	@XmlCDATA
	@XmlElement(name = "Content")
	public void setContent(String content) {
		Logger log = Logger.getLogger(WeChatReqBean.class.getName());
		// 解决乱码 估计是垃圾服务器的原因 真是日了狗。
		try {
			this.content = new String(content.getBytes("GBK"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.warning("卧槽！居然出错了！！！");
			e.printStackTrace();
		}
	}

	public Double getLocation_X() {
		return location_X;
	}

	@XmlElement(name = "Location_X")
	public void setLocation_X(Double location_X) {
		this.location_X = location_X;
	}

	public Double getLocation_Y() {
		return location_Y;
	}

	@XmlElement(name = "Location_Y")
	public void setLocation_Y(Double location_Y) {
		this.location_Y = location_Y;
	}

	public Integer getScale() {
		return scale;
	}

	@XmlElement(name = "Scale")
	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	@XmlCDATA
	@XmlElement(name = "Label")
	public void setLabel(String label) {
		this.label = label;
	}

	public Long getMsgId() {
		return msgId;
	}

	@XmlElement(name = "MsgId")
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "WeChatReqBean [toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", content=" + content + ", location_X="
				+ location_X + ", location_Y=" + location_Y + ", scale="
				+ scale + ", label=" + label + ", msgId=" + msgId + "]";
	}

}
