package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        // 获取核心配置文件的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
        // 获取sqlSession对象，是Mybatis提供的操作数据库的对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();

        // 设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper接口中的方法，实现添加用户信息的功能；
        int result = mapper.insertUser();

        // 和上面两句效果相同  通过sql以及唯一标识来找到sql并执行
        // int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");

        System.out.println("结果：" + result);

        // 提交事务
        // sqlSession.commit();

        // 关闭sqlSession
        sqlSession.close();

    }
}
