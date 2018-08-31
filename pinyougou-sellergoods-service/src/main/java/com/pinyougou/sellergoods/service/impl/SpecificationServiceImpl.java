package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.SpecificationMapper;
import com.pinyougou.mapper.SpecificationOptionMapper;
import com.pinyougou.mapper.TypeTemplateMapper;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.pojogroup.SpecificationGroup;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageParameter;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 屁屁
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult findPage(Integer page, Integer size, Object[] objects) {
        //分页
        Specification specification = JSON.parseObject(
                JSON.toJSONString(objects[0]), Specification.class);
        Page<Specification> pages = specificationMapper.selectPage(specification);

        return new PageResult(pages.getTotal(), pages.getResult());
    }

    @Override
    public void saveSpecification(SpecificationGroup specificationGroup) {
        //设置规格名称
        Specification specification = specificationGroup.getSpecification();
        specificationMapper.insertSpecification(specification);
        Long id = specification.getId();
        //规格选项管理规格id
        List<SpecificationOption> specificationOptionList = specificationGroup.getSpecificationOptionList();
        for (SpecificationOption specificationOption: specificationOptionList) {
            specificationOption.setSpecId(id);
        }

        specificationOptionMapper.insertSpecificationOption(specificationOptionList);
        //设置规格选项

    }

    @Override
    public SpecificationGroup findOne(Long id) {
        //获取规格实体类
        Specification specification = specificationMapper.selectOne(id);
        //获取相对性的规格选项
        List<SpecificationOption> specificationOptionList = specificationOptionMapper.selectBySpecId(id);
        //设置规格返回对象
        SpecificationGroup specificationGroup = new SpecificationGroup();
        specificationGroup.setSpecificationOptionList(specificationOptionList);
        specificationGroup.setSpecification(specification);

        return specificationGroup;
    }

    @Override
    public void modifySpecification(SpecificationGroup specificationGroup) {
        //获取规格实体
        Long id = specificationGroup.getSpecification().getId();
        Specification specification = specificationMapper.selectOne(id);
        //删除对应的规格选项
        specificationOptionMapper.deleteBySpecId(id);
        //添加规模选项
        List<SpecificationOption> specificationOptionList = specificationGroup.getSpecificationOptionList();
        for(SpecificationOption specificationOption : specificationOptionList) {
            specificationOption.setSpecId(id);
        }
        specificationOptionMapper.insertSpecificationOption(specificationOptionList);
    }

    @Override
    public void removeSpecification(Long[] ids) {
        specificationMapper.deleteSpecification(ids);
    }

    @Override
    public List<Map> findSpecList() {
        return specificationMapper.selectSpecList();
    }
}
