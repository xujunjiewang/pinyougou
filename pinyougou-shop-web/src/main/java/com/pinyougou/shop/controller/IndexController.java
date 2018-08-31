package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class IndexController {

    @ResponseBody
    @RequestMapping("/name")
    public Map showLoginName() {
        Map map = new HashMap();
        String showName = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("showName", showName);
        return map;
    }
}
