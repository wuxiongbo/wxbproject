package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;

import java.lang.reflect.Type;

/**
 * 服务层接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午1:54:30
 * @version 1.0
 */
public interface TypeTemplateService {

    /**
     * 分页查询类型模版
     * @param typeTemplate 模版实体
     * @param page 当前页码
     * @param rows 每页显示的记录数
     * @return PageResult
     */
    PageResult findByPage(TypeTemplate typeTemplate,
                          Integer page, Integer rows);

    /** 添加类型模版 */
    void saveTypeTemplate(TypeTemplate typeTemplate);

    /** 修改类型模版 */
    void updateTypeTemplate(TypeTemplate typeTemplate);

    /** 删除规格与规格选项 */
    void deleteTypeTemplate(Long[] ids);
}
