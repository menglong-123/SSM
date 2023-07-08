package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/6 21:29
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAlEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        // 将所有的员工信息在请求域中共享
        model.addAttribute("employees", employees);
        // 跳转到列表页面
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        // 保存员工信息
        employeeDao.save(employee);
        // 重定向到列表页面： /employee
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        // 根据id查询员工信息
        Employee employee = employeeDao.get(id);
        // 将员工信息共享的请求域中
        model.addAttribute("employee", employee);
        // 跳转到employee_update.html
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        // 修改员工信息
        employeeDao.save(employee);
        // 重定向到列表页面
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
