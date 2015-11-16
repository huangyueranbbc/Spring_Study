package com.AiQing.MicroMessage.PublicPlatform.base;

import javax.annotation.Resource;

import com.AiQing.MicroMessage.PublicPlatform.service.GoodsService;
import com.AiQing.MicroMessage.PublicPlatform.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	protected OrderService orderService;
	protected GoodsService goodsService;

	public OrderService getOrderService() {
		return orderService;
	}

	@Resource(name = "orderserviceimplement")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	@Resource(name = "goodsserviceimplement")
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

}
