package com.clyao.mybatisplustest.controller;

import com.clyao.mybatisplustest.entity.User;
import com.clyao.mybatisplustest.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("学生列表")
    @GetMapping("/test1")
    public String test1(@ApiParam("学生ID") String id){
        User byId = userService.getById(1);
        System.out.println(byId.toString());
        return "test1";
    }

}
