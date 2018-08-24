package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import entity.PageParameter;

import java.util.List;

public interface BrandMapper {

    List<Brand> findPage(PageParameter<Brand> pageParameter);
}
