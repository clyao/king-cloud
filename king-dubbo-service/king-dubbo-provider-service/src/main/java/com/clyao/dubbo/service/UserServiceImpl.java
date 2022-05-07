package com.clyao.dubbo.service;

import com.clyao.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@Component
@DubboService
public class UserServiceImpl implements UserService {

    @Override
    public String getUser() {
        return "我是通过dubbo的服务提供者输出的哦";
    }
}
