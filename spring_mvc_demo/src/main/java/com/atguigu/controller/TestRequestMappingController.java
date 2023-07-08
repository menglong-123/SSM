package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/5 21:33
 * @Version 1.0
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username!=123"})
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?c/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println("id :" + id + ", username: " + username);
        return "success";
    }


}
