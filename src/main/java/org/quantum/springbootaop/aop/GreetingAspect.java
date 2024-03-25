package org.quantum.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class GreetingAspect {

    private final Logger log = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Después: " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Después de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Después de lanzar excepción: " + method + " con los argumentos " + args);
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        try {
            log.info("El método " + method + "() con los parámetros " + args);
            Object result = joinPoint.proceed();
            log.info("El método " + method + "() retorna el resultado: " + result);

            return result;
        } catch (Throwable e) {
            log.error("Error en la llamada al método " + method + "(): " + e.getLocalizedMessage());
            throw e;
        }
    }

}
