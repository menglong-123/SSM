package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 获取对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect前置通知, 方法：" + signature.getName() + " 参数：" + Arrays.toString(args));

    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect后置通知，方法：" + signature.getName() + "，执行完毕");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect返回通知，方法：" + signature.getName() + "，结果：" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable except){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect异常通知，方法：" + signature.getName() + "， 异常：" + except);
    }
}

