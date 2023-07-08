package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及所对应的部门信息的第二步
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    // 查询部门以及部门的员工信息
    Dept getDeptAndEmpById(@Param("deptId") Integer deptId);

    // 通过分步查询来查询部门信息以及部门里的员工的信息
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
