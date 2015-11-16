package com.AiQing.MicroMessage.PublicPlatform.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AiQing.MicroMessage.PublicPlatform.base.BaseDaoImpl;
import com.AiQing.MicroMessage.PublicPlatform.model.Goods;
import com.AiQing.MicroMessage.PublicPlatform.service.GoodsService;

@Service(value = "goodsserviceimplement")
@Transactional
@SuppressWarnings("unchecked")
public class GoodsServiceImpl extends BaseDaoImpl<Goods> implements
		GoodsService {

}
