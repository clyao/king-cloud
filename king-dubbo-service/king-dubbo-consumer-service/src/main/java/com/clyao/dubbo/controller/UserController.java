package com.clyao.dubbo.controller;

import com.clyao.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("test")
    public String test(){
        return userService.getUser();
    }
}
