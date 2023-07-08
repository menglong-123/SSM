package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 根据id来获取Bean对象
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);
        // 根据bean的类型来获取Bean对象
//        Student bean = ioc.getBean(Student.class);
//        System.out.println(bean);

//         根据 id和类型来获取bean
//        Student studentTwo = ioc.getBean("studentTwo", Student.class);
//        System.out.println(studentTwo);
//
//        Person person = ioc.getBean(Person.class);
//        System.out.println(person);
    }



}
