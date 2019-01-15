package com.pinyougou.sellergoods.service.impl;
import com.pinyougou.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.ItemCatMapper;
import com.pinyougou.sellergoods.service.ItemCatService;

import java.util.List;

/**
 * 服务实现层
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:56:56
 * @version 1.0
 */
@Service(interfaceName="com.pinyougou.sellergoods.service.ItemCatService")
@Transactional(readOnly=false)
public class ItemCatServiceImpl implements ItemCatService {
	
	/** 注入数据访问层代理对象 */
	@Autowired
	private ItemCatMapper itemCatMapper;

	/** 根据父级id查询商品分类 */
	public List<ItemCat> findItemCatByParentId(Long parentId){
		try{
			
			return null;
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
