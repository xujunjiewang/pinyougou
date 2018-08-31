package com.pinyougou.mapper;

import com.github.pagehelper.Page;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.TypeTemplate;
import entity.PageParameter;

import java.util.List;
import java.util.Map;

/**
 * @author 屁屁
 */
public interface SpecificationMapper {

    /**
     * 分页显示所有模板信息
     * @param  specification 分页查询参数的包装类
     * @return Page分页查询结果的包装类
     */
    Page<Specification> selectPage(Specification specification);

    /**
     * 添加模板
     * @param specification
     */
    void insertSpecification(Specification specification);

    /**
     * 根据id查询模板信息
     * @param id
     * @return 查寻到的模板信息
     */
    Specification selectOne(Long id);

    /**
     * 修改模板
     * @param specification
     */
    void updateSpecification(Specification specification);

    /**
     *删除模板
     * @param ids
     */
    void deleteSpecification(Long[] ids);

    /**
     * 获取规格列表
     * @return 获取规格列表
     */
    List<Map> selectSpecList();
}
