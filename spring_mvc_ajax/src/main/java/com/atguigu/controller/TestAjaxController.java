package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: cml
 * @Description:
 * @Date: 2023/7/7 14:16
 * @Version 1.0
 */
@Controller
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        System.out.println(requestBody);
        response.getWriter().write("hello,axios");
    }

    //
    //@RequestMapping("test/requestBody")
//    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
//        System.out.println(user);
//        response.getWriter().write("Hello,ResquestBody");
//    }

    @RequestMapping("test/requestBody")
    public void testRequestBody(@RequestBody Map<String, Object> user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("Hello,ResquestBody");
    }

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody(){
        return "Hello, world";
    }

    @RequestMapping("test/responseBody/json")
    @ResponseBody
    public User testResponseBodyJson(@RequestBody User user){
        return user;
    }
}
