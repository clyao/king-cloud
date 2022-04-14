package com.clyao.jwt.controller;

import com.clyao.jwt.utils.JwtUtils;
import com.clyao.jwt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(@RequestParam("mobile") String mobile, @RequestParam("password") String password){
        if(mobile == null || !password.equals("123")){
           return new Result("密码错误");
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "king");
            map.put("age", 20);
            String token = jwtUtils.createJwt("1", "king", map);
            System.out.println(token);
            return new Result(token);
        }
        //return "sss";
    }

}
