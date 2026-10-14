package com.qeema.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudLogAsncAspect {

    @Before("com.qeema.demo.aspect.AOPExpressions.daoOperationExcludingGettersAndSetters()")
    public void performCloudLogAsnc(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Argument: " + arg);
        }

    }
}
