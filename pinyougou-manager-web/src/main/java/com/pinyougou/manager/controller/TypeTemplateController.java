package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageParameter;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 屁屁
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/searchPage")
    public PageResult searchPage(@RequestBody TypeTemplate typeTemplate , PageParameter<TypeTemplate> pageParameter){

        pageParameter.setT(typeTemplate);
        return typeTemplateService.findPage(pageParameter);
    }

    @RequestMapping("/searchOne")
    public TypeTemplate searchOne(Long id) {
        return typeTemplateService.findOne(id);
    }

    @RequestMapping("/addTypeTemplate")
    public Map addTypeTemplate(@RequestBody TypeTemplate typeTemplate) {
        try{
            typeTemplateService.saveTypeTemplate(typeTemplate);
            return result(true, "添加成功");
        }catch (Exception e) {
            e.printStackTrace();
            return result(false, "添加失败");
        }
    }

    @RequestMapping("/reviseTypeTemplate")
    public Map reviseTypeTemplate(@RequestBody TypeTemplate typeTemplate) {
        try{
            typeTemplateService.modifyTypeTemplate(typeTemplate);
            return result(true, "修改成功");
        }catch (Exception e) {
            return result(false, "修改失败");
        }
    }

    @RequestMapping("/expurgateTypeTemplate")
    public Map expurgateTypeTemplate(Long[] ids) {

        try{
            typeTemplateService.removeTypeTemplate(ids);
            return result(true, "修改成功");
        }catch (Exception e) {
            return result(false, "修改失败");
        }
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
