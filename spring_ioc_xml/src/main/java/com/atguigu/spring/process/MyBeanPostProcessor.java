package com.atguigu.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的初始化之前执行
        System.out.println("后置处理器的 postProcessBeforeInitialization 方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的初始化之后执行
        System.out.println("后置处理器的 postProcessAfterInitialization 方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
