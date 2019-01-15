package com.pinyougou.manager.controller;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.SpecificationService;

import java.util.List;
import java.util.Map;

/**
 * 规格处理器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:09:46
 * @version 1.0
 */
@RestController //相当于@Controller+@ResponseBody两个注解的结合
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;

	/** 分页查询规格 */
	@GetMapping("/findByPage")
	public PageResult findByPage(Specification specification,
								 Integer page, Integer rows){

		try {
			/** GET请求参数转码 */
			if (specification != null && StringUtils.
					isNoneBlank(specification.getSpecName())) {
				specification.setSpecName(new String(specification
						.getSpecName().getBytes("ISO8859-1"), "UTF-8"));
			}

			return specificationService.findByPage(specification, page, rows);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	/** 添加规格与规格选项 */
	@PostMapping("/save")
	public boolean saveSpecification(@RequestBody Specification specification){
		System.out.print(specification);
		try{
			specificationService.saveSpecification(specification);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	/** 根据规格id查询规格选项 */
	@GetMapping("/findOne")
	public List<SpecificationOption> findOne(Long id){
		List<SpecificationOption> temp = specificationService.findOne(id);
		return temp;
	}


    /** 修改规格与规格选项 */
    @PostMapping("/update")
    public boolean updateSpecification(@RequestBody Specification specification){
        try{
            specificationService.updateSpecification(specification);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /** 删除规格与规格选项 */
    @GetMapping("/delete")
    public boolean deleteSpecification(Long[] ids){
		try{
			specificationService.deleteSpecification(ids);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	/** 查询规格列表(id,name) */
	@GetMapping("/selectSpecList")
	public List<Map<String, Object>> selectSpecList(){
		return specificationService.findSpecByIdAndName();
	}
}
