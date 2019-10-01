package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {

    @Around("@annotation(LoggerAnnotation)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms.");
        return proceed;
    }

    @Before("@annotation(LoggerAnnotation)")
    public Object logMethodName(JoinPoint joinPoint) throws  Throwable {
        System.out.println(joinPoint.getSignature() + " was invoked.");
        return joinPoint;
    }
}
