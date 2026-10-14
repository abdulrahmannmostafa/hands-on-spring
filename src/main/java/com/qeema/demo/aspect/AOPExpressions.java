package com.qeema.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPExpressions {

    @Pointcut("execution(* com.qeema.demo.dao.*.*(..))")
    public void daoOperation() {
    }

    @Pointcut("execution(* com.qeema.demo.dao.*.get*(..))")
    public void getOperation() {
    }

    @Pointcut("execution(* com.qeema.demo.dao.*.set*(..))")
    public void setOperation() {
    }

    @Pointcut("daoOperation() && !(getOperation() || setOperation())")
    public void daoOperationExcludingGettersAndSetters() {
    }

    @Pointcut("execution(* com.qeema.demo.dao.*.findAccounts(..))")
    public void findAccountsOperation() {
    }

    @Pointcut("execution(* com.qeema.demo.service.*.getFortune(..))")
    public void getFortuneOperation() {
    }
}