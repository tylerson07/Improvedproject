package com.sparta.deliveryproject.loggingAop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAop {
    Logger log = LoggerFactory.getLogger(LoggingAop.class);

    @Pointcut(value="execution(* com.sparta.deliveryproject.*..*.*(..))")
    public void myPointcut(){


    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        String methodName =  pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("method invoked" + className + ":" + methodName + "()" + "arguments :" + mapper.writeValueAsString(array));
        Object object= pjp.proceed();
        log.info(className + ":" + methodName + "()" + "Response :" + mapper.writeValueAsString(array));
        return object;
    }
}
