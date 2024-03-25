package org.quantum.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class GreetingFooAspect {

    private final Logger log = LoggerFactory.getLogger(GreetingFooAspect.class);

    @Before("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("[foo] Antes: " + method + " invocado con los parámetros " + args);
    }

    @After("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("[foo] Después: " + method + " con los argumentos " + args);
    }

}
