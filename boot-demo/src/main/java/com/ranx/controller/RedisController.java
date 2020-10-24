package com.ranx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ranx
 * @create 2018-03-23 13:05
 **/
@RestController
@RequestMapping("/index")
public class RedisController {

    /**
     * 测试redis缓存
     * 启动项目，调用redisHandler方法，查询redis服务器方法
     * >keys *
     * >get k5
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/redisHandler")
    @ResponseBody
    public String redisHandler() {
        stringRedisTemplate.opsForValue().set("k5", "Springboot redis");
        return stringRedisTemplate.opsForValue().get("k5");
    }
}
