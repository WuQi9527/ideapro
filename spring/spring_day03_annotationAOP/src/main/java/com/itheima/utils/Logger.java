package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect//表示当前类是一个切面类

public class Logger {
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }
    @AfterThrowing("pt1()")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }


    @Around("pt1()")
    public Object arround(ProceedingJoinPoint pjb){
        Object rtValue=null;
        try {
            Object[] args = pjb.getArgs();//得到方法执行的参数
            System.out.println("开始记录日志了  前置");
            rtValue=pjb.proceed(args);
            System.out.println("开始记录了   后置");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("开始记录了 异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("开始记录了   最终");
        }

    }

}
