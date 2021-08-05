package org.satvik.springDemo.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//todo refer spring.xml for aop annotations config

public class LoggingAspect {

    private final static String ALL_GETTERS = "execution(* org.satvik..*.get*())";

    public void getterAdvice(JoinPoint joinPoint){
        System.out.println("getter method called for: "+joinPoint.getTarget());
    }

    public void someLoggingFunction(){
        System.out.println("logging function called!");
    }

//    @Pointcut("execution(* org.satvik..*.get*())")
//    public void allGetter(){}

    @Pointcut("within(org.satvik.springDemo.demo.pojo.Circle)")
    public void allCircleMethods(){}

//    @Before("allCircleMethods()")
//    public void allCircleMethodsAdvice(JoinPoint joinPoint){
//        System.out.println("one of the circle method was called!");
//    }

//    @Before("@annotation(org.satvik.springDemo.demo.aspects.Loggable))")
//    public void myCustomAnnotation(JoinPoint joinPoint){
//        System.out.println("log something from: "+joinPoint.getTarget());
//    }

//    @Before("allGetter() && allCircleMethods()")
//    public void circleGettersAdvice(){
//        System.out.println("called only for circle getters!");
//    }
}
