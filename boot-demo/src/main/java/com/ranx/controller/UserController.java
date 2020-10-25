package com.ranx.controller;


import com.ranx.pojo.Resource;
import com.ranx.pojo.User;
import com.ranx.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * JSON对象的构建
 */
//@Controller
@RestController //(= @Controller + @ResponseBody)
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Resource resource;

    @RequestMapping("/getUser")
    //@ResponseBody //表明返回json格式
    public User getUser() {
        User u= new User();
        u.setName("ranx");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("ranx");
        return u;
    }

    @RequestMapping("/getUserJSON")
    //@ResponseBody //表明返回json格式
    public JSONResult getUserJSON() {
        User u= new User();
        u.setName("ranx");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("ranx");
        return JSONResult.ok(u);
    }

    @RequestMapping("/getResource")
    public JSONResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }
}
