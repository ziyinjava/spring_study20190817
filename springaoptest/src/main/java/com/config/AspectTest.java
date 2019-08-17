package com.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ziyin
 @create 2019-06-2019/6/18-15:43
 */
@Component
@Aspect
public class AspectTest {

    @Pointcut("execution(* com.dao.*.*(..))")
    private void pt1(){

    }

    @Before("pt1()")
    public void beforeMethod() {
        System.out.println("before...");
    }
}
