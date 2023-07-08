package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/7 22:11
 * @Version 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/test/annotation")
    @ResponseBody
    public String testAnnotation(){
        // System.out.println(1/0);
        return "success";
    }
}
