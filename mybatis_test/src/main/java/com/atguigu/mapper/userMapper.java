package com.atguigu.mapper;

import com.atguigu.POJO.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/3 16:41
 * @Version 1.0
 */
public interface userMapper {
    public User getUserById(@Param("id") Integer id);

    public int insertUser(User user);
    public int updateUser(@Param("id") Integer id, @Param("username") String username);
}
