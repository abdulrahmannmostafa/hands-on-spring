package com.qeema.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDeclaration {

    @Pointcut("execution(* com.qeema.demo.controller.*.*(..))")
    public void forControllerPackage() {
    }

    @Pointcut("execution(* com.qeema.demo.service.*.*(..))")
    public void forServicePackage() {
    }

    @Pointcut("execution(* com.qeema.demo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {
    }

}