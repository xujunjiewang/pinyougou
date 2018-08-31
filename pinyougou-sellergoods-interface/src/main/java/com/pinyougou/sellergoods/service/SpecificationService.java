package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.pojogroup.SpecificationGroup;
import entity.PageParameter;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 模板接口
 * @author 屁屁
 */
public interface SpecificationService {
    /**
     * 分页显示所有模板信息
     * @param object
     * @param page
     * @param size
     * @return PageResult 分页查询结果的包装类
     */
    PageResult findPage(Integer page, Integer size, Object[] object);

    /**
     * 添加模板
     * @param specificationGroup
     */
    void saveSpecification(SpecificationGroup specificationGroup);

    /**
     * 根据id查询模板信息
     * @param id
     * @return 查寻到的模板信息
     */
    SpecificationGroup findOne(Long id);


    /**
     * 修改模板
     * @param specificationGroup
     */
    void modifySpecification(SpecificationGroup specificationGroup);

    /**
     *删除模板
     * @param ids
     */
    void removeSpecification(Long[] ids);

    /**
     * 获取规格列表
     * @return 返回规格列表
     */
    List<Map> findSpecList();
}
