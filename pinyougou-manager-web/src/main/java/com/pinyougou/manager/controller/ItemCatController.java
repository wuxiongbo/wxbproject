package com.pinyougou.manager.controller;

import com.pinyougou.pojo.ItemCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.ItemCatService;

import java.util.List;

/**
 * ItemCatController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:08:39
 * @version 1.0
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

	@Reference
	private ItemCatService itemCatService;

	/** 根据父级id查询商品分类 */
	@GetMapping("/findItemCatByParentId")
	public List<ItemCat> findItemCatByParentId(@RequestParam(value = "parentId",
			defaultValue = "0")Long parentId){
		return itemCatService.findItemCatByParentId(parentId);
	}
}