package com.ranx.service;

import com.ranx.mapper.UserMapper;
import com.ranx.entity.User;
import com.ranx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ranx
 * @create 2019-12-08 14:11
 **/

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsersByAge(int age) {
        return userMapper.get(age);
    }

    public String insert(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userMapper.insert(user);
        return "Insert ( \""+name+"\", age"+age+") !";
    }
}
