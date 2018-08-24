package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.Brand;
import entity.PageParameter;
import entity.PageResult;

import java.util.List;

/**
 * 品牌接口
 * @author 屁屁
 */
public interface BrandService {

    /**
     *
     * @return 商品分页条件查询
     */
    PageResult findPage(PageParameter<Brand> pageParameter);
}
