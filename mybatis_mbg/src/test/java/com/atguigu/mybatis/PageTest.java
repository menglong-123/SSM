package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 先插入多个员工信息，以实现分页
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        Emp emp = new Emp(null,"小庄",20, "男");
//        for (int i = 0; i < 100; i++) {
//            mapper.insert(emp);
//
//        }
        // 查询功能之前配置分页功能
        Page<Object> page = PageHelper.startPage(2, 4);

        List<Emp> emps = mapper.selectByExample(null);
        // 在查询功能之后，可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 5);

        emps.forEach(System.out::println);

        System.out.println(page);
        System.out.println(pageInfo);
        sqlSession.close();
    }
}
