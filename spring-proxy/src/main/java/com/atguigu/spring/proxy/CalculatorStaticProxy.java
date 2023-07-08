package com.atguigu.spring.proxy;

public class CalculatorStaticProxy implements Calculator{
    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl calculator) {
        this.target = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：mul，参数："+ i + "," + j);
        int result = target.add(i, j);
        System.out.println("日志，方法：mul，结果："+ result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：mul，参数："+ i + "," + j);
        int result = target.sub(i, j);
        System.out.println("日志，方法：mul，结果："+ result);
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul，参数："+ i + "," + j);
        int result = target.mul(i, j);
        System.out.println("日志，方法：mul，结果："+ result);
        return 0;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：mul，参数："+ i + "," + j);
        int result = target.div(i, j);
        System.out.println("日志，方法：mul，结果："+ result);
        return 0;
    }
}
