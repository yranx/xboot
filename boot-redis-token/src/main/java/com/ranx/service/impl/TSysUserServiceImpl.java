package com.ranx.service.impl;


import com.ranx.mapper.TSysUserMapper;
import com.ranx.model.entity.TSysUser;
import com.ranx.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TSysUserService")
public class TSysUserServiceImpl implements TSysUserService {

    @Autowired
    private TSysUserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSysUser record) {
        return userMapper.insert(record);
    }

    @Override
    public TSysUser selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TSysUser> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(TSysUser record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TSysUser> selectByNameAndPwd(String name, String pwd) {
        return userMapper.selectByNameAndPwd(name, pwd);
    }
}
