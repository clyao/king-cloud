package com.clyao.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity("https://petstore.swagger.io/v2/store/inventory", String.class);
        String body = stringResponseEntity.getBody().toString();
        return body;
    }

}
