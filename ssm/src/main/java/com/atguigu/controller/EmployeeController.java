package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: cml
 * @Date: 2023/7/8 18:18
 * @Version 1.0
 * @Description:
 * 查询员工信息   /employee   get
 * 分页查询员工信息   /employee/page/1   get
 * 根据id查询员工信息  /employee/1  get
 * 跳转到添加页面      /to/add   get
 * 添加员工信息       /employee  post
 * 修改员工信息       /employee/1   put
 * 删除员工信息       /employee/1 delete
 * 目前的WARN：①数据库的列名和实体类的属性名匹配要手动定义
 *            ②出现警告：clearReferencesJdbc Web应用程序 [SSM] 注册了JDBC驱动程序
 *            [com.alibaba.druid.proxy.DruidDriver]，但在Web应用程序停止时无法注销它。
 *            为防止内存泄漏，JDBC驱动程序已被强制取消注册。
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/employee")
//    public String getAllEmployee(Model model){
//        // 查询所有的员工信息
//        List<Employee> employees = employeeService.getAllEmployee();
//        // 将员工信息添加到共享域中
//        model.addAttribute("employees", employees);
//        System.out.println(employees);
//        // 跳转到employ_list.html
//        return "employee_list";
//    }

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeeByPage(@PathVariable("pageNum") Integer pageNum, Model model){
        // 获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeeByPage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page", page);
        // 跳转
        return "employee_list";
    }

    @GetMapping("/to/add")
    public String toAdd(){
        return "employee_add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/page/1";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println(employee);

        model.addAttribute("employee", employee);

        return "employee_update";
    }

    @PutMapping("/employee")
    public String updataEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/page/1";
    }
}
