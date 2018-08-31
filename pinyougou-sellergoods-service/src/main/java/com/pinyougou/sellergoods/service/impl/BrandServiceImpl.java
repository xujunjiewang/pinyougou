package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageParameter;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult findPage(PageParameter<Brand> pageParameter) {
        //分页
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getSize());
        Page<Brand> page = (Page<Brand>) brandMapper.selectPage(pageParameter);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void saveBrand(Brand brand) {
        brandMapper.insertBrand(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return brandMapper.selectOne(id);
    }

    @Override
    public void modifyBrand(Brand brand) {
        brandMapper.updateBrand(brand);
    }

    @Override
    public void removeOne(Long[] ids) {
        for(Long id : ids) {
            brandMapper.deleteOne(id);
        }
    }

    @Override
    public List<Map> findBrandList() {
        return brandMapper.selectBrandList();
    }

}
