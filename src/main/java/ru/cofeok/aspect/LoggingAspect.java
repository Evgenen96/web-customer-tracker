package ru.cofeok.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* ru.cofeok.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* ru.cofeok.dbservice.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* ru.cofeok.dbservice.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        System.out.println("lol");
        myLogger.info(" >>>>> In @Before: calling method: " + theMethod);

        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            myLogger.info(" >>>>> Argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info(" >>>>> In @AfterReturning: from method: " + theMethod);

        myLogger.info(" >>>>> result: " + theResult);
    }


}
