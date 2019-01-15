package com.pinyougou.mapper;

import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecificationOptionMapper  extends Mapper<SpecificationOption>{

    /** 添加规格选项 */
    void save(Specification specification);

    /** 根据规格主键查询规格选项 */
    @Select("select * from tb_specification_option"
            + " where spec_id = #{id} order by orders asc")
    List<SpecificationOption> findBySpecId(Long id);
    
}