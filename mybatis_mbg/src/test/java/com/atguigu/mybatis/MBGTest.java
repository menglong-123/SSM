package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 根据id查询数据
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
        // 查询所有数据
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(System.out::println);

        // 根据条件来查询数据
//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("小红").andAgeGreaterThanOrEqualTo(20);
//        example.or().andGenderEqualTo("男");
//        List<Emp> list = mapper.selectByExample(example);
//        list.forEach(System.out::println);

        // 测试普通修改功能，覆盖性修改
        Emp emp = new Emp(1,"小花",null,"女");
//        mapper.updateByPrimaryKey(emp);

        // 选择性修改, 若属性为null，则不修改该属性
        mapper.updateByPrimaryKeySelective(emp);

        sqlSession.close();
    }
}
