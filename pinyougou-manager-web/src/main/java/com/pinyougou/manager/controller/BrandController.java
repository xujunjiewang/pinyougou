package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageParameter;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findPage")
    public PageResult getBrandList(@RequestBody(required = false) Brand brand, PageParameter<Brand> pageParameter) {

        //封装参数
        //如果查询条件为空，new一个新对象，防止空指针
        if (brand == null) {
            brand = new Brand();
        }

        pageParameter.setT(brand);
        return brandService.findPage(pageParameter);
    }
}
