package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import entity.PageParameter;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectPage(PageParameter<Brand> pageParameter);

    void insertBrand(Brand brand);

    Brand selectOne(Long id);

    void updateBrand(Brand brand);

    void deleteOne(Long id);

    List<Map> selectBrandList();
}
