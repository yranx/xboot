package com.ranx.controller;

import com.ranx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ranx
 * @create 2019-12-08 14:13
 **/
//@RestController("/user")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUsersByAge")
    @ResponseBody
    public Object getUserByAge(int age) {
        return userService.getUsersByAge(age);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String name, int age) {
        return userService.insert(name, age);
    }

    @RequestMapping( "/hello")
    @ResponseBody
    public String show() {
        return "hello";
    }
}
