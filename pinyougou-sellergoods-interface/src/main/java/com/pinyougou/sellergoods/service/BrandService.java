package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.Brand;
import entity.PageParameter;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 品牌接口
 * @author 屁屁
 */
public interface BrandService {

    /**
     * 品牌分页条件查询
     * @param pageParameter 分页查询参数的包装类
     * @return PageResult 分页查询结果的包装类
     */
    PageResult findPage(PageParameter<Brand> pageParameter);

    /**
     *添加品牌
     * @param brand 需要存储的品牌实体
     */
    void saveBrand(Brand brand);

    /**
     * 根据id查找品牌
     * @param id 品牌id
     * @return 查询到的品牌信息
     */
    Brand findOne(Long id);

    /**
     * 修改品牌
     * @param brand 需要修改的品牌实体
     */
    void modifyBrand(Brand brand);

    /**
     * 根据id删除品牌
     * @param ids 品牌id
     */
    void removeOne(Long[] ids);

    /**
     * 查询所有品牌id和名称
     * @return 返回品牌列表
     */
    List<Map> findBrandList();
}
