package com.ranx.mapper;

import com.ranx.model.TSysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TSysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSysUser record);

    TSysUser selectByPrimaryKey(Integer id);

    List<TSysUser> selectAll();

    int updateByPrimaryKey(TSysUser record);

    List<TSysUser> selectByNameAndPwd(String name, String pwd);
}