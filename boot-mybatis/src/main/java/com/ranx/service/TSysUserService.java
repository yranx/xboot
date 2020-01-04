package com.ranx.service;

import com.ranx.model.TSysUser;

import java.util.List;

public interface TSysUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(TSysUser record);

    TSysUser selectByPrimaryKey(Integer id);

    List<TSysUser> selectAll();

    int updateByPrimaryKey(TSysUser record);

    List<TSysUser> selectByNameAndPwd(String name, String pwd);
}
