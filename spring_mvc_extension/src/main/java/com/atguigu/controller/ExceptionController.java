package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/7 20:44
 * @Version 1.0
 */

// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable exception, Model model){
        model.addAttribute("exception", exception);
        return "error";
    }
}
