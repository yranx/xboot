package com.ranx.controller;

import com.ranx.pojo.SysUser;
import com.ranx.pojo.User;
import com.ranx.utils.JSONResult;
import com.ranx.utils.JsonUtils;
import com.ranx.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ranx
 * @create 2018-03-23 13:05
 **/
@RestController
@RequestMapping("/index")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    /**
     * 测试redis缓存
     * 启动项目，调用redisHandler方法，查询redis服务器方法
     * >keys *
     * >get k5
     */
    @RequestMapping("/redisHandler")
    @ResponseBody
    public String redisHandler() {
        stringRedisTemplate.opsForValue().set("k5", "Springboot redis");
        return stringRedisTemplate.opsForValue().get("k5");
    }


    @RequestMapping("/getJson")
    public JSONResult getJson() {
        stringRedisTemplate.opsForValue().set("ranx-redis-cache", "hello Reids~~~~");

        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("ranx");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        stringRedisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"), SysUser.class);
        return JSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JSONResult getJsonList() {
        User user = new User();
        user.setAge(18);
        user.setName("ranx1");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User user1 = new User();
        user1.setAge(19);
        user1.setName("ranx2");
        user1.setPassword("123456");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setAge(20);
        user2.setName("hello ranx");
        user2.setPassword("123456");
        user2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        redisOperator.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
        String userListJson = redisOperator.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JSONResult.ok(userListBorn);
    }
}
