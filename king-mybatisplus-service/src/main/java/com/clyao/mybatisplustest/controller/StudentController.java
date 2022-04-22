package com.clyao.mybatisplustest.controller;

import com.clyao.mybatisplustest.entity.Shop;
import com.clyao.mybatisplustest.entity.User;
import com.clyao.mybatisplustest.service.impl.UserServiceImpl;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @ApiOperation(value = "测试")
    @GetMapping("/test2/{pageNumbar}/{pageSize}")
    public String test2(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return "aaa";
    }

    @GetMapping("/test3")
    public String test3(@RequestBody Map<String, Object> params){
        return "aaa";
    }

    @PostMapping("/test4")
    @Schema
    public String test4(@RequestBody Shop shop){
        return "aaa";
    }


}
