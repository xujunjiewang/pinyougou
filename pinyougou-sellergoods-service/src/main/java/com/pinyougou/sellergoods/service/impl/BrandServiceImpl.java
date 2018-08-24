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


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult findPage(PageParameter<Brand> pageParameter) {
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getSize());  //分页
        Page<Brand> page = (Page<Brand>) brandMapper.findPage(pageParameter);

        return new PageResult(page.getTotal(), page.getResult());
    }
}
