package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Specification;
import com.pinyougou.pojo.SpecificationOption;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.pojogroup.SpecificationGroup;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageParameter;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author 屁屁
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    @RequestMapping("/searchPage")
    public PageResult searchPage(Integer page, Integer size, @RequestBody Object... objects){
        return specificationService.findPage(page, size, objects);
    }

    @RequestMapping(value = "/searchOne")
    public SpecificationGroup searchOne(Long id) {
        return specificationService.findOne(id);
    }

    @RequestMapping("/addSpecification")
    public Map addSpecification(@RequestBody SpecificationGroup specificationGroup) {
        try{
            specificationService.saveSpecification(specificationGroup);
            return result(true, "添加成功");
        }catch (Exception e) {
            e.printStackTrace();
            return result(false, "添加失败");
        }
    }

    @RequestMapping("/reviseSpecification")
    public Map reviseSpecification(@RequestBody SpecificationGroup specificationGroup) {
        try{
            specificationService.modifySpecification(specificationGroup);
            return result(true, "修改成功");
        }catch (Exception e) {
            return result(false, "修改失败");
        }
    }

    @RequestMapping("/expurgateSpecification")
    public Map expurgateSpecification(Long[] ids) {

        try{
            specificationService.removeSpecification(ids);
            return result(true, "修改成功");
        }catch (Exception e) {
            return result(false, "修改失败");
        }
    }

    @RequestMapping("/searchSpecList")
    public List<Map> searchSpecList() {
        return specificationService.findSpecList();
    }


    /**
     * 将返回信息封装到map中
     * @param flag
     * @param msg
     * @return map的返回集
     */
    private Map result(boolean flag, String msg) {
        Map result = new HashMap(16);
        result.put("success", flag);
        result.put("message", msg);

        return result;
    }
}
