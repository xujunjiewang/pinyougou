package com.pinyougou.pojogroup;

import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;

import java.io.Serializable;
import java.util.List;

public class SpecificationGroup implements Serializable {

    private Specification specification;
    private List<SpecificationOption> specificationOptionList;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
