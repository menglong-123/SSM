package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    Emp getEmpById(@Param("empId") Integer empId);

    Emp getEmpAndDept(@Param("empId") Integer empId);

    // 通过分步查询查询员工以及所对应的部门信息的第一步
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    // 通过分步查询查询部门信息以及部门里的员工信息的第二步
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
