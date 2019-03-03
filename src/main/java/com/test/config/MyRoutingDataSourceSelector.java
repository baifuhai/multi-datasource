package com.test.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRoutingDataSourceSelector {

    MyRoutingDataSourceKey value() default MyRoutingDataSourceKey.DATASOURCE_UNKNOWN;

}
