package com.test;

import com.test.config.MyRoutingDataSourceHolder;
import com.test.controller.UserController;
import com.test.service.UserService;
import com.test.service.UserService2;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.PatternMatchUtils;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class Tests {

    @Autowired
    DataSource dataSource1;

    @Autowired
    DataSource dataSource2;

    @Autowired
    UserService userService;

    @Autowired
    UserService2 userService2;

    @Autowired
    UserController userController;

    @Test
    public void test01() {
        System.out.println(dataSource1.getClass());
        System.out.println(dataSource2.getClass());
        System.out.println(dataSource1 == dataSource2);
    }

    //在事务开始之前就要确定数据源

    @Test
    public void test02() {
        System.out.println(userController.getById1(1));
    }

    @Test
    public void test03() {
        System.out.println(userController.getById2(MyRoutingDataSourceHolder.getDataSourceKey1(), 1));
        System.out.println(userController.getById2(MyRoutingDataSourceHolder.getDataSourceKey2(), 1));
    }

    @Test
    public void test04() {
        MyRoutingDataSourceHolder.setDataSourceKey2();
        System.out.println(userService.getById(1));
    }

    @Test
    public void test05() {
        System.out.println(userService2.getById(1));
    }

    @Test
    public void test06() {
        System.out.println(StringUtils.startsWithAny("getById", "get", "find", "query"));
    }

    @Test
    public void test07() {
        System.out.println(PatternMatchUtils.simpleMatch(new String[]{"get*", "find*", "query*"}, "getById"));
    }

}
