package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    //模糊查询
    List<User> getUserByLike(@Param("mohu") String mohu);
    // 批量删除
    void deleteMoreUser(@Param("ids") String ids);
    // 动态设置表名
    List<User> getUserList(@Param("tableName") String tableName);

    void insertUser(User user);
}
