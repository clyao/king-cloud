package com.clyao.mybatisplustest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clyao
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/mybatisplustest/student")
@Api(value = "学生接口", tags = "学生")
public class StudentController {

    @ApiOperation("学生列表")
    @GetMapping("/test1")
    public String test1(@ApiParam("学生ID") String id){
        return "test1";
    }

}
