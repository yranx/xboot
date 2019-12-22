package com.ranx.mapper;

import com.ranx.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT * FROM user WHERE age = #{age}")
    List<User> get(int age);

    @Insert("INSERT INTO user(name, age) VALUES (#{name}, #{age})")
    void insert(User user);
}
