package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/8 12:20
 * @Version 1.0
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
