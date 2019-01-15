package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌
     * 
     * @return
     */
    List findAll();

    /**
     *  分页查询品牌
     * @param page 当前页码
     * @param rows 每页显示的记录数
     * @return
     */
    PageResult findByPage(Brand brand,Integer page, Integer rows);

    /**
     * 保存数据
     * @param brand
     */
    void saveBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteBrand(Long[] ids);
}
