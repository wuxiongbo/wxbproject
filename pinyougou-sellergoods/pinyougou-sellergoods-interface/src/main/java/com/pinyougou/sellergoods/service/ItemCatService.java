package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.ItemCat;

import java.util.List;

/**
 * 服务层接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:53:19
 * @version 1.0
 */
public interface ItemCatService {

    /** 根据父级id查询商品分类 */
    List<ItemCat> findItemCatByParentId(Long parentId);
}
