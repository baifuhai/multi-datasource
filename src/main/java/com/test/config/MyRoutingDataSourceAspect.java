package com.test.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class MyRoutingDataSourceAspect {

    @Pointcut("@annotation(com.test.config.MyRoutingDataSourceSelector)")
    public void pointcut(){}

    @Around("pointcut() && @annotation(at)")
    public Object dataSourceSwitcher(ProceedingJoinPoint joinPoint, MyRoutingDataSourceSelector at) throws Throwable {
        MyRoutingDataSourceKey dataSourceKey = at.value();
        if (dataSourceKey == MyRoutingDataSourceKey.DATASOURCE_UNKNOWN) {
            MethodSignature methodSignature = MethodSignature.class.cast(joinPoint.getSignature());
            Method method = methodSignature.getMethod();
            Object[] args = joinPoint.getArgs();
            int index = 0;
            x:for (Parameter parameter : method.getParameters()) {
                for (Annotation annotation : parameter.getAnnotations()) {
                    if (annotation instanceof MyRoutingDataSourceSelector) {
                        dataSourceKey = MyRoutingDataSourceKey.getByName(String.valueOf(args[index]));
                        break x;
                    }
                }
                index++;
            }
        }
        MyRoutingDataSourceHolder.setDataSourceKey(dataSourceKey.getName());
        try {
            return joinPoint.proceed();
        } finally {
            MyRoutingDataSourceHolder.resetDataSourceKey();
        }
    }

}

