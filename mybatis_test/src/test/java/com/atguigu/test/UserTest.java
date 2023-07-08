package com.atguigu.test;

import com.atguigu.POJO.User;
import com.atguigu.Utils.SqlSessionUtil;
import com.atguigu.mapper.userMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/3 16:46
 * @Version 1.0
 */
public class UserTest {
    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = new User(null, "cml", "1234", 23, "男", "123@qq.com");
        int rows = mapper.insertUser(user);
        System.out.println(rows);
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int rows = mapper.updateUser(3, "cuimenglong");
        System.out.println(rows);
    }
}
