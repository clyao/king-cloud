package com.clyao.kinguserservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String get(){
        log.info("user的controller被执行了");
        return "ssss";
    }

}
