package com.qeema.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.qeema.demo.entity.Account;

import org.aspectj.lang.ProceedingJoinPoint;

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

    @AfterReturning(pointcut = "com.qeema.demo.aspect.AOPExpressions.findAccountsOperation()", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
        System.out.println(getClass() + ": Executing @AfterReturning advice on findAccounts()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        System.out.println("Result: " + accounts);

        if (!accounts.isEmpty()) {
            Account firstAccount = accounts.get(0);
            firstAccount.setName(firstAccount.getName().toUpperCase());
        }

        System.out.println("Modified Result: " + accounts);

    }

    @AfterThrowing(pointcut = "com.qeema.demo.aspect.AOPExpressions.findAccountsOperation()", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println(getClass() + ": Executing @AfterThrowing advice on findAccounts()");

        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("Method: " + methodSignature);

        System.out.println("Exception: " + exception);
    }

    @After("com.qeema.demo.aspect.AOPExpressions.findAccountsOperation()")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Executing @After (finally) advice on findAccounts()");

        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("Method: " + methodSignature);
    }

    @Around("com.qeema.demo.aspect.AOPExpressions.getFortuneOperation()")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(getClass() + ": Executing @Around advice on getFortune()");

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) / 1000.0 + " s");

        return result;
    }

    @Around("com.qeema.demo.aspect.AOPExpressions.getFortuneOperation()")
    public Object aroundGetFortuneAdviceWithExceptionHandling(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(getClass() + ": Executing @Around advice on getFortune() with exception handling");

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Exception caught in @Around advice: " + e);
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }

        return result;
    }

}