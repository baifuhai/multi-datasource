package com.test.controller;

import com.test.config.MyRoutingDataSourceKey;
import com.test.config.MyRoutingDataSourceSelector;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("getById1")
    @ResponseBody
    @MyRoutingDataSourceSelector(MyRoutingDataSourceKey.DATASOURCE_KEY2)
    public User getById1(Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("getById2")
    @ResponseBody
    @MyRoutingDataSourceSelector
    public User getById2(@MyRoutingDataSourceSelector String dataSourceKey, Integer id) {
        return userService.getById(id);
    }

}
