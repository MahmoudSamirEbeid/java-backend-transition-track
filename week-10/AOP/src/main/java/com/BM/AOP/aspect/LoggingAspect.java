package com.BM.AOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.BM.AOP.example.BusinessService.calculateMax(..))")
    private void methodName2(JoinPoint joinPoint) {
        logger.info("Method Name {}", joinPoint.getSignature().getName());
    }

    @Before("execution(* com.BM.AOP.example.DataService.getData(..))")
    private void methodName(JoinPoint joinPoint) {
        logger.info("Method Name {}", joinPoint.getSignature().getName());
    }

}
