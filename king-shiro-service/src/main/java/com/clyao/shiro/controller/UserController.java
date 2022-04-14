package com.clyao.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(String username, String password){
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            System.out.println(subject.hasRole("admin"));
            System.out.println(subject.isPermitted("user:update"));
            return "登录成功";
        } catch (AuthenticationException e) {
            return "登录失败";
        }
    }

    @GetMapping("/list")
    @RequiresRoles("admin")
    @RequiresPermissions("user:save")
    public String list(){
        return "king";
    }

    @GetMapping("/home")
    public String home(int code){
        return code==1?"未登录":"未授权";
    }

}
