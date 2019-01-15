package com.pinyougou.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.GoodsService;

/**
 * GoodsController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:08:17
 * @version 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
}
