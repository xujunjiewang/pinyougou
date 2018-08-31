package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TypeTemplate;
import entity.PageParameter;
import entity.PageResult;
import entity.Result;

/**
 * 模板接口
 * @author 屁屁
 */
public interface TypeTemplateService {
    /**
     * 分页显示所有模板信息
     * @param pageParameter 分页查询参数的包装类
     * @return PageResult 分页查询结果的包装类
     */
    PageResult findPage(PageParameter<TypeTemplate> pageParameter);

    /**
     * 添加模板
     * @param typeTemplate
     */
    void saveTypeTemplate(TypeTemplate typeTemplate);

    /**
     * 根据id查询模板信息
     * @param id
     * @return 查寻到的模板信息
     */
    TypeTemplate findOne(Long id);

    /**
     * 修改模板
     * @param typeTemplate
     */
    void modifyTypeTemplate(TypeTemplate typeTemplate);

    /**
     *删除模板
     * @param ids
     */
    void removeTypeTemplate(Long[] ids);
}
