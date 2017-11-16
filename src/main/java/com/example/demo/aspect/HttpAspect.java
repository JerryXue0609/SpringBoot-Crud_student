package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jerry on 2017/8/15 0015.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.StudentController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
       //url
       LOGGER.info("url={}",request.getRequestURL());
        //请求方式
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("IP={}",request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        LOGGER.info("切点后方法执行。。。。。");
    }

    @AfterReturning(returning = "o",pointcut = "log()")
    public void doAfterRuturning(Object o){
       // LOGGER.info("response={}",o.toString());
    }
}
