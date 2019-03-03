package com.test.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@Order(1)
@Aspect
@Component
public class MyRoutingDataSourceAspect2 {

    @Pointcut("execution(* com.test.service.UserService2.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = MethodSignature.class.cast(joinPoint.getSignature());
        Method method = methodSignature.getMethod();
        MyRoutingDataSourceSelector annotation = method.getDeclaringClass().getDeclaredAnnotation(MyRoutingDataSourceSelector.class);
        MyRoutingDataSourceKey dataSourceKey = annotation.value();

        MyRoutingDataSourceHolder.setDataSourceKey(dataSourceKey.getName());
        try {
            return joinPoint.proceed();
        } finally {
            MyRoutingDataSourceHolder.resetDataSourceKey();
        }
    }

}

