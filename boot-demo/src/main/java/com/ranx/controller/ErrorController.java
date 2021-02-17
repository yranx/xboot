package com.ranx.controller;

import com.ranx.utils.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ranx
 * @create 2018-04-10 23:14
 **/
@Controller
@RequestMapping("err")
public class ErrorController {

    //web页面跳转
    @RequestMapping("error")
    public String error() {
        int a = 1 / 0;
        return "/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {
        return "exception/ajaxerror";
    }

    //ajax形式
    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JSONResult getAjaxerror() {
        int a = 1/0;
        return JSONResult.ok();
    }
}
