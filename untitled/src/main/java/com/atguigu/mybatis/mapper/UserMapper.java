package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    public int insertUser();
    public int updateUser();

    public int deleteUser();

    // 根据id查询用户
    public User getUserById();
    //查询所有的用户信息
    public List<User> getAllUser();
}
