package com.pinyougou.sellergoods.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.GoodsMapper;
import com.pinyougou.sellergoods.service.GoodsService;

/**
 * 服务实现层
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:55:55
 * @version 1.0
 */
@Service(interfaceName="com.pinyougou.sellergoods.service.GoodsService")
@Transactional(readOnly=false)
public class GoodsServiceImpl implements GoodsService {
	
	/** 注入数据访问层代理对象 */
	@Autowired
	private GoodsMapper goodsMapper;
	
}