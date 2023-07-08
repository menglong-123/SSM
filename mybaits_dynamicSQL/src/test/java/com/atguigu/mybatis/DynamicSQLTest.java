package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
        emp.setAge(20);
        emp.setEmpName("张三");
        List<Emp> emps = mapper.getEmpByCondition(emp);
        emps.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
        //emp.setAge(20);
        List<Emp> emps = mapper.getEmpByChoose(emp);
        emps.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明", 20, "男");
        Emp emp2 = new Emp(null, "小红", 20, "女");
        Emp emp3 = new Emp(null, "小壮", 20, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        //emp.setAge(20);
        mapper.insertMoreEmp(emps);
        emps.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{};
        //emp.setAge(20);
        mapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
}
