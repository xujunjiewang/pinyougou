package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TypeTemplateMapper;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageParameter;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 屁屁
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult findPage(PageParameter<TypeTemplate> pageParameter) {
        //分页
        PageHelper.startPage(pageParameter.getPage(), pageParameter.getSize());
        Page<TypeTemplate> page = typeTemplateMapper.selectPage(pageParameter);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void saveTypeTemplate(TypeTemplate typeTemplate) {
        typeTemplateMapper.insertTypeTemplate(typeTemplate);
    }

    @Override
    public TypeTemplate findOne(Long id) {
        return typeTemplateMapper.selectOne(id);
    }

    @Override
    public void modifyTypeTemplate(TypeTemplate typeTemplate) {
        typeTemplateMapper.updateTypeTemplate(typeTemplate);
    }

    @Override
    public void removeTypeTemplate(Long[] ids) {
        typeTemplateMapper.deleteTypeTemplate(ids);
    }
}
