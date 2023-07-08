package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/6 20:36
 * @Version 1.0
 */
@Controller
public class TestRestController {
    @GetMapping("/user")
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息 --> /user --> get");
        return "success";
    }
    @GetMapping("/user/{id}")
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息--> /user/" + id + "-->get");
        return "success";
    }

    @PostMapping("/user")
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息--> /user --> post");
        return "success";
    }
    @PutMapping("/user")
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息--> /user --> put");
        return "success";
    }

    @DeleteMapping("/user/{id}")
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户id为:" + id + "的用户 ---> /user/1 --> delete");
        return "success";
    }
}
