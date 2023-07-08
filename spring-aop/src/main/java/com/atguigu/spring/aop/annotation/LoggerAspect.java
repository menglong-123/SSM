package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    在切面中，需要通过指定的注解将方法标识为通知方法
    @Before：前置通知，在目标对象方法执行之前执行
    @After: 后置通知，在目标对象方法的finally中执行
    @AfterReturning：返回通知，在目标对象返回值之后执行
    @AfterThrowing：异常通知，在目标对象方法的catch中执行

    切入点表达式：设置在标识通知的注解的value属性中
        execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int, int))
        execution(* com.atguigu.spring.aop.annotation.*.*(..))
        第一个 * 表示任意访问修饰符和返回值类型
        第二个 * 表示包的所有类
        第三个 * 表示类中任意的方法
        .. 表示任意的参数列表
    获取连接点信息：
        在通知方法的参数位置，设置JoinPoint的参数，就可以获取连接点所对应方法的信息

     重用切入点表达式
        声明一个重用的切入点表达式
        @Pointcut("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
        public void pointCut(){}
        使用时在相应位置写pointCut()的方法即可
 */
@Component
@Aspect // 将当前组件标识为切面组件
public class LoggerAspect {
    @Pointcut("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

//    @Before("pointCut()")
//    public void beforeAdviceMethod(JoinPoint joinPoint){
//        // 获取对应方法的签名信息
//        Signature signature = joinPoint.getSignature();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("LoggerAspect前置通知, 方法：" + signature.getName() + " 参数：" + Arrays.toString(args));
//
//    }
//
//    @After("pointCut()")
//    public void afterAdviceMethod(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("LoggerAspect后置通知，方法：" + signature.getName() + "，执行完毕");
//    }
//    // 在返回通知中若要获取目标对象方法的返回值，只需要在注解中加入returning属性， 然后在方法添加Object result参数即可
//    @AfterReturning(value = "pointCut()", returning = "result")
//    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("LoggerAspect返回通知，方法：" + signature.getName() + "，结果：" + result);
//    }
//    // 在返回通知中若要获取目标对象方法的异常，只需要在注解中加入throwing属性， 然后在方法添加Throwable except参数即可
//    @AfterThrowing(value = "pointCut()", throwing = "except")
//    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable except){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("LoggerAspect异常通知，方法：" + signature.getName() + "， 异常：" + except);
//    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        // 环绕通知的方法一定要和目标对象方法的返回值一致
        Signature signature = joinPoint.getSignature();
        Object result = null;
        try {
            System.out.println("前置通知，方法：" + signature.getName() + "，参数：" + Arrays.toString(joinPoint.getArgs()));
            // 表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("返回通知，方法：" + signature.getName() + "，结果：" + result);
        } catch (Throwable e) {
            System.out.println("异常通知，方法：" + signature.getName() + "，异常：" + e);
        }finally {
            System.out.println("后置通知，方法：" + signature.getName() + "执行完毕");
        }
        return result;
    }
}

