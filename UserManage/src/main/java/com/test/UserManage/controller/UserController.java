package com.test.UserManage.controller;

import com.test.UserManage.model.User;
import com.test.UserManage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/list",produces = "application/json")
    public List<User> getUserList(){
        return userService.selectList();
    }

    @RequestMapping(value = "/getUser/{username}", produces = "application/json")
    public User getUserByUserName(@PathVariable String username){

        System.out.println("调用了用户信息服务");
        return userService.getUserByUsername(username);
    }

}
