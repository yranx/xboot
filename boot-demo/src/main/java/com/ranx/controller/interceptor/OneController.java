package com.ranx.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ranx
 * @create 2018-05-07 23:30
 **/
@Controller
@RequestMapping("one")
public class OneController {
    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name","ran11");
        return "thymeleaf/index";
    }
}
