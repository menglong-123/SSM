package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student studentTwo = ioc.getBean("studentTwo", Student.class);

        System.out.println(studentTwo);

        Student studentThree = ioc.getBean("studentThree", Student.class);
        System.out.println(studentThree);

        Student studentFour = ioc.getBean("studentFour", Student.class);

        System.out.println(studentFour);

        Student studentFive = ioc.getBean("studentFive", Student.class);
        System.out.println(studentFive);

        Student studentSix = ioc.getBean("studentSix", Student.class);
        System.out.println(studentSix);
    }

    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        Clazz clazz = ioc.getBean("clazz", Clazz.class);
        System.out.println(clazz);
    }
}
