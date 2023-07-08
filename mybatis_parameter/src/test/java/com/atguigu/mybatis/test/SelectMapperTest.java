package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    void getUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);
        sqlSession.close();
    }
    
    @Test
    void getAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
        sqlSession.close();

    }

    @Test
    void getUserCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int userCount = mapper.getUserCount();
        System.out.println(userCount);
        sqlSession.close();

    }

    @Test
    void getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // 值为null的不会放到集合中
        Map<String, Object> map = mapper.getUserByIdToMap(2);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    void getAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // 值为null的不会放到集合中
        List<Map<String, Object>> users = mapper.getAllUserToMap();
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    void getAllUserToMap2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // 值为null的不会放到集合中
        Map<String, Object> map = mapper.getAllUserToMap2();
        System.out.println(map);
        sqlSession.close();
    }
}
