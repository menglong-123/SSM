package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    //根据员工id查询员工信息
    Emp getEmpById(@Param("empId") Integer empId);

    void insertEmp(@Param("emp") Emp emp);
}
