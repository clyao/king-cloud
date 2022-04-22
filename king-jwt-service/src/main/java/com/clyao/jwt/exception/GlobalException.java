package com.clyao.jwt.exception;

import com.clyao.jwt.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;


/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        if (e instanceof SQLException){
            return new Result("数据库异常");
        }else {
            return new Result("系统异常");
        }

    }

}
