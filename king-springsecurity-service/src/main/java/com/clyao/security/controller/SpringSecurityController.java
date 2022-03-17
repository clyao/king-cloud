package com.clyao.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
@Slf4j
public class SpringSecurityController {

    @GetMapping("/hello")
    public String hello(){
        log.info("xxxx");
        return "hello spring security";
    }

}
