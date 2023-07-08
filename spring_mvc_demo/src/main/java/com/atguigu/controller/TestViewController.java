package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/6 17:02
 * @Version 1.0
 */
@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testViewThymeleaf(){
        return "success";
    }
}
