package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageParameter;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

/**
 * @author 屁屁
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/searchPage")
    public PageResult searchPage(@RequestBody Brand brand, PageParameter<Brand> pageParameter) {
        pageParameter.setT(brand);
        return brandService.findPage(pageParameter);
    }

    @RequestMapping("/addBrand")
    public Result addBrand(@RequestBody Brand brand) {
        try {
            brandService.saveBrand(brand);
            return new Result(true, "保存成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败");
        }
    }

    @RequestMapping("/searchOne")
    public Brand searchOne(Long id) {
        return brandService.findOne(id);
    }

    @RequestMapping("/reviseBrand")
    public Result reviseBrand(@RequestBody Brand brand) {
        try {
            brandService.modifyBrand(brand);
            return new Result(true, "修改成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/expurgateBrand")
    public Result expurgateBrand(Long[] ids) {
        try {
            brandService.removeOne(ids);
            return new Result(true, "删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/searchBrandList")
    public List<Map> searchBrandList() {
        return brandService.findBrandList();
    }
}
