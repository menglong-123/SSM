package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/6 16:24
 * @Version 1.0
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/scope")
    public ModelAndView testMAV(){
        // 设置ModelAndView
        ModelAndView mav = new ModelAndView();
        // 向请求域中共享数据
        mav.addObject("testScope", "hello, ModelAndView");
        // 设置逻辑视图，来跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSession", "hello, Session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication", "Hello, Application");
        return "success";
    }

}
