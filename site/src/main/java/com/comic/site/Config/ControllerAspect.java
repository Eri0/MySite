package com.comic.site.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerAspect {
    /**
     * 切点表达式
     */
    @Pointcut("execution(public * com.comic.site.controller..*.*(..))")
    public void controllrAspect(){

    }

//    @Before("controllrAspect()")
//    public void doBefore(JoinPoint joinPoint){
//        System.out.println("doBefore");
//    }
//
//    @After("controllrAspect()")
//    public void doAfter(JoinPoint joinPoint){
//        System.out.println("doAfter");
//    }

//    @AfterReturning("controllrAspect()")
//    public void doAfterReturning(JoinPoint joinPoint){
//        System.out.println("doAfterReturning");
//    }

//    @AfterThrowing("controllrAspect()")
//    public void deAfterThrowing(JoinPoint joinPoint){
//        System.out.println("deAfterThrowing");
//    }

    @Around("controllrAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[Around]{}",joinPoint);
        return joinPoint.proceed();
    }
}
