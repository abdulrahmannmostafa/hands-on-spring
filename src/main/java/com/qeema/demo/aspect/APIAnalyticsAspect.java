package com.qeema.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class APIAnalyticsAspect {

    @Before("com.qeema.demo.aspect.AOPExpressions.daoOperationExcludingGettersAndSetters()")
    public void performApiAnalytics(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Performing API analytics");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Argument: " + arg);
        }

    }

}
