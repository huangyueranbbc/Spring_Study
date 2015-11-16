package com.AiQing.MicroMessage.PublicPlatform.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AiQing.MicroMessage.PublicPlatform.base.BaseDaoImpl;
import com.AiQing.MicroMessage.PublicPlatform.model.Goods;
import com.AiQing.MicroMessage.PublicPlatform.model.Order;
import com.AiQing.MicroMessage.PublicPlatform.service.GoodsService;
import com.AiQing.MicroMessage.PublicPlatform.service.OrderService;

@Service(value = "orderserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class OrderServiceImpl extends BaseDaoImpl<Order> implements
		OrderService {

}
