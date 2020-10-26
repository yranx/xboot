package com.ranx.controller;

import com.ranx.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ranx
 * @create 2018-04-08 22:52
 * 联合templates中的freemarker
 **/
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {
    @Autowired
    private Resource resource;

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "/freemarker/index";
    }

    @RequestMapping("center")
    public String center() {
        return "/freemarker/center/center";
    }
}
