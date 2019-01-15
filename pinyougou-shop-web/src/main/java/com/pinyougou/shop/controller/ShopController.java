package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShopController {
    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<Brand> fincAll(){
        return brandService.findAll();
    }
}
