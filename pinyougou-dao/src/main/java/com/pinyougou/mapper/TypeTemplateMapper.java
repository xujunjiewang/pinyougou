package com.pinyougou.mapper;

import com.github.pagehelper.Page;
import com.pinyougou.pojo.TypeTemplate;
import entity.PageParameter;

/**
 * @author 屁屁
 */
public interface TypeTemplateMapper {

    /**
     * 分页显示所有模板信息
     * @param pageParameter 分页查询参数的包装类
     * @return Page分页查询结果的包装类
     */
    Page<TypeTemplate> selectPage(PageParameter<TypeTemplate> pageParameter);

    /**
     * 添加模板
     * @param typeTemplate
     */
    void insertTypeTemplate(TypeTemplate typeTemplate);

    /**
     * 根据id查询模板信息
     * @param id
     * @return 查寻到的模板信息
     */
    TypeTemplate selectOne(Long id);

    /**
     * 修改模板
     * @param typeTemplate
     */
    void updateTypeTemplate(TypeTemplate typeTemplate);

    /**
     *删除模板
     * @param ids
     */
    void deleteTypeTemplate(Long[] ids);
}
