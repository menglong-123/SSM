package com.atguigu.service;


import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/8 15:20
 * @Version 1.0
 */

public interface EmployeeService {
    List<Employee> getAllEmployee();


    PageInfo<Employee> getEmployeeByPage(Integer pageNum);

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
