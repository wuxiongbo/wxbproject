package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Seller; /**
 * 服务层接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:53:42
 * @version 1.0
 */
public interface SellerService {

    /** 添加商家 */
    void saveSeller(Seller seller);

    /**
     * 分页查询未审核的商家
     * @param seller 商家实体
     * @param page 当前页码
     * @param rows 每页显示的记录数
     * @return 分页结果
     */
    PageResult findByPage(Seller seller, Integer page, Integer rows);

    /**
     * 修改商家状态
     * @param sellerId
     * @param status
     */
    void updateStatus(String sellerId, String status);

    /** 根据sellerId查询商家对象 */
    Seller findOne(String username);
}
