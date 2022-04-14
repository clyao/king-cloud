package com.clyao.shiro.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ShiroBaseExceptionHandler {

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public String error(HttpServletRequest request, HttpServletResponse response, AuthorizationException exception){
        return "未授权";
    }

}
