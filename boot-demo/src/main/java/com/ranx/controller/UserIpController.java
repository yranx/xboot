package com.ranx.controller;

import com.ranx.utils.IpUtil;
import com.ranx.utils.IpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ranx
 * @create 2018-03-22 10:43
 **/
@RestController
public class UserIpController {
    @RequestMapping("/getIp")
    @ResponseBody
    public String getIp(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }
}
