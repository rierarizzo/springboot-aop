package org.quantum.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* org.quantum.springbootaop.services.IGreetingService.*(..))")
    protected void greetingLoggerPointcut() {}

    @Pointcut("execution(* org.quantum.springbootaop.services.IGreetingService.*(..))")
    protected void greetingFooLoggerPointcut() {}

}
