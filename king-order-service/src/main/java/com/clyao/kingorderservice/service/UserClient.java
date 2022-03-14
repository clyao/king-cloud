package com.clyao.kingorderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("king-user-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user/list")
    String user();

}
