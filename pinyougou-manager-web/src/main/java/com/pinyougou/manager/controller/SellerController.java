package com.pinyougou.manager.controller;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Seller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.SellerService;

/**
 * SellerController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:09:18
 * @version 1.0
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference(timeout = 10000)
	private SellerService sellerService;

	/** 分页查询未审核的商家 */
	@GetMapping("/findByPage")
	public PageResult findByPage(Seller seller,
								 Integer page, Integer rows){
		try{
			/** GET请求中文转码 */
			if (seller != null && StringUtils.isNoneBlank(seller.getName())){
				seller.setName(new String(seller.getName()
						.getBytes("ISO8859-1"),"UTF-8"));
			}
			if (seller != null && StringUtils.isNoneBlank(seller.getNickName())){
				seller.setNickName(new String(seller.getNickName()
						.getBytes("ISO8859-1"),"UTF-8"));
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return sellerService.findByPage(seller, page, rows);
	}

	/** 审核商家(修改商家的状态) */
	@GetMapping("/upddateStatus")
	public boolean upddateStatus(String sellerId, String status){
		try{
			sellerService.updateStatus(sellerId, status);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}