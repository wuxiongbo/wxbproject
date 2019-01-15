package com.pinyougou.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceName = "com.pinyougou.sellergoods.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Brand> findAll() {
        PageInfo<Brand> pageInfo =
                PageHelper.startPage(1,10)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.selectAll();//需要拦截的方法
                    }
                });
        return pageInfo.getList(); //返回拦截后的分页对象;
    }

    /**
     * 查询分页数据
     * @param page 当前页码
     * @param rows 每页显示的记录数
     * @return
     */
    @Override
    public PageResult findByPage(Brand brand,Integer page, Integer rows) {

        try {
            PageInfo<Brand> pageInfo =
                    PageHelper.startPage(page,rows)
                            .doSelectPageInfo(
                                    new ISelect() {
                                        @Override
                                        public void doSelect() {
                                            brandMapper.findAll(brand);
                                        }
                                    }
                            );
            return new PageResult(pageInfo.getTotal(),pageInfo.getList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 保存数据
     * @param brand
     */
    @Override
    public void saveBrand(Brand brand) {
        try {
            brandMapper.insertSelective(brand);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBrand(Brand brand) {
        try {
            brandMapper.updateByPrimaryKeySelective(brand);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBrand(Long[] ids) {
        try{
            brandMapper.deleteAll(ids);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
