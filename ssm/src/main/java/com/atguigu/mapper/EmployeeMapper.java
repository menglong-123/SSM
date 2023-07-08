package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/8 16:14
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper {
    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "empName", column = "emp_name"),
            // 其他字段映射
    })
    @Select("select * from t_emp")
    List<Employee> getAllEmployee();

    @Insert("insert into t_emp values(null, #{empName}, #{age}, #{gender}, #{email})" )
    void addEmployee(Employee employee);

    @Results({
            @Result(property = "empId", column = "emp_id"),
            @Result(property = "empName", column = "emp_name"),
            // 其他字段映射
    })
    @Select("select * from t_emp where emp_id = #{id}")
    public Employee getEmployeeById(@Param("id") Integer id);

    @Update("update t_emp set emp_name=#{empName}, age=#{age}, gender=#{gender}, email=#{email} where emp_id=#{empId}")
    void updateEmployee(Employee employee);

    @Delete("delete from t_emp where emp_id=#{id}")
    void deleteEmployee(@Param("id") Integer id);
}
