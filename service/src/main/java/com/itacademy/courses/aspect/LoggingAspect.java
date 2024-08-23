package com.itacademy.courses.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.itacademy.courses.services..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.itacademy.courses.services..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method: {} returned with value: {}", joinPoint.getSignature(), result);
    }

    @Around("execution(* com.itacademy.courses.services..*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("Method: {} executed in {} ms with result: {}", proceedingJoinPoint.getSignature(), elapsedTime, result);
            return result;
        } catch (Throwable e) {
            logger.error("Method: {} failed with exception: {}", proceedingJoinPoint.getSignature(), e.getMessage());
            throw e;
        }
    }
}
