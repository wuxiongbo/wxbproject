package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    /**
     * 引用服务
     */
    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findByPage")
    public PageResult findByPage(Brand brand,
            @RequestParam("page")Integer page,
            @RequestParam("rows")Integer rows) throws UnsupportedEncodingException {
        /* get请求中文乱码 */
        if(brand != null && StringUtils.isNoneBlank(brand.getName())){
            brand.setName(new String(brand.getName()
                    .getBytes("ISO8859-1"),"UTF-8"));
        }
        return brandService.findByPage(brand,page,rows);
    }

    @PostMapping("/save")
    public boolean saveOrUpdate(@RequestBody Brand brand){
        try {
            brandService.saveBrand(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try {
            brandService.updateBrand(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /** 删除品牌 */
    @GetMapping("/delete")
    public boolean delete(Long[] ids){
        try{
            brandService.deleteBrand(ids);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
