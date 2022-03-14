package com.clyao.kingorderservice.controller;

import com.clyao.kingorderservice.service.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/list")
    public String get(){
        String user = userClient.user();
        log.info("order的controller执行了");
        return user;
    }
}
