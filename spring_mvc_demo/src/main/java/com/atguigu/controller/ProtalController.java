package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/5 22:35
 * @Version 1.0
 */
@Controller
public class ProtalController {
    @RequestMapping("/")
    public String protal(){
        return "index";
    }

}
