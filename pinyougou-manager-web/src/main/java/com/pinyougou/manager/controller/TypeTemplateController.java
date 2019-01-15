package com.pinyougou.manager.controller;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.TypeTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.TypeTemplateService;

/**
 * TypeTemplateController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:10:14
 * @version 1.0
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Reference
	private TypeTemplateService typeTemplateService;

	/** 分页查询规格 */
	@GetMapping("/findByPage")
	public PageResult findByPage(TypeTemplate typeTemplate,
								 Integer page,
								 Integer rows){
		try {
			/** GET请求参数转码 */
			if (typeTemplate != null && StringUtils.isNoneBlank(typeTemplate.getName())) {
				typeTemplate.setName(new String(typeTemplate.getName()
						.getBytes("ISO8859-1"),
						"UTF-8"));
			}
			return typeTemplateService.findByPage(typeTemplate, page, rows);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	/** 添加类型模版 */
	@PostMapping("/save")
	public boolean saveTypeTemplate(@RequestBody TypeTemplate typeTemplate){
		try{
			typeTemplateService.saveTypeTemplate(typeTemplate);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}


	/** 修改类型模 */
	@PostMapping("/update")
	public boolean updateTypeTemplate(@RequestBody TypeTemplate typeTemplate){
		try{
			typeTemplateService.updateTypeTemplate(typeTemplate);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	/** 删除类型模 */
	@GetMapping("/delete")
	public boolean deleteTypeTemplate(Long[] ids){
		try{
			typeTemplateService.deleteTypeTemplate(ids);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
}
