package com.atguiug.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotation {
    /*

     */
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");

        UserController userController = ioc.getBean("controller", UserController.class);
        System.out.println(userController);
        userController.saveUser();
        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
        userController.saveUser();
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.saveUser();
    }
}
