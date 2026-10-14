package com.qeema.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.qeema.demo.entity.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Before("com.qeema.demo.aspect.AOPExpressions.daoOperationExcludingGettersAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Executing @Before advice on daoOperation()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Argument: " + arg);
            if (arg instanceof Account account) {
                System.out.println("Account name: " + account.getName());
                System.out.println("Account service code: " + account.getLevel());
            }
        }
    }

}