package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;

import java.util.List;
import java.util.Map;

/**
 * 规格服务层接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:54:04
 * @version 1.0
 */
public interface SpecificationService {

    /**
     * 分页查询规格
     * @param specification 规格实体
     * @param page 当前页码
     * @param rows 每页显示的记录数
     * @return PageResult
     */
    PageResult findByPage(Specification specification,
                          Integer page, Integer rows);

    /** 添加规格与规格选项 */
    void saveSpecification(Specification specification);

    /** 根据规格id查询规格选项 */
    List<SpecificationOption> findOne(Long id);

    /** 修改规格与规格选项  */
    void updateSpecification(Specification specification);

    /** 删除规格与规格选项 */
    void deleteSpecification(Long[] ids);

    /** 查询规格列表(id,name) */
    List<Map<String,Object>> findSpecByIdAndName();
}
