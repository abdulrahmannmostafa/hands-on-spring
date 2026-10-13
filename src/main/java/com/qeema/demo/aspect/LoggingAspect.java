package com.qeema.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.qeema.demo.dao.*.*(..))")
    public void daoOperation() {
    }

    /*
     * this would run that function before we call the pointcut method which is our
     * addAccount() method in AccountDAOImpl class
     */
    @Before("daoOperation()")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + ": Executing @Before advice on addAccount()");
    }
}
