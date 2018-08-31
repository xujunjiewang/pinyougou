package com.pinyougou.mapper;

import com.github.pagehelper.Page;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;
import com.pinyougou.pojo.TypeTemplate;

import java.util.List;

/**
 * @author 屁屁
 */
public interface SpecificationOptionMapper {

    /**
     * 分页显示所有模板信息
     * @param  specificationOption 分页查询参数的包装类
     * @return Page分页查询结果的包装类
     */
    Page<SpecificationOption> selectPage(SpecificationOption specificationOption);

    /**
     * 添加模板
     * @param specificationOptionList
     */
    void insertSpecificationOption(List<SpecificationOption> specificationOptionList);

    /**
     * 根据id查询模板信息
     * @param id
     * @return 查寻到的模板信息
     */
    SpecificationOption selectOne(Long id);

    /**
     * 修改模板
     * @param specificationOptionList
     */
    void updateSpecificationOption(List<SpecificationOption> specificationOptionList);

    /**
     *删除模板
     * @param ids
     */
    void deleteSpecificationOption(Long[] ids);

    /**
     * 根据规格id获取对应的规格选项
     * @param id 规格id
     * @return 与规格匹配的规格选项
     */
    List<SpecificationOption> selectBySpecId(Long id);

    /**
     * 删除规格对应的规格选项
     * @param id 规格id
     */
    void deleteBySpecId(Long id);
}
