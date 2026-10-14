package com.qeema.demo.aspect;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.log(Level.INFO, "=====> Executing @Before advice on method: {0}", method);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.log(Level.INFO, "=====> Argument: {0}", arg);
        }
    }

}