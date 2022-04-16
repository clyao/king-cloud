package com.clyao.securityjwt.controller;

import com.clyao.securityjwt.pojo.Result;
import com.clyao.securityjwt.pojo.User;
import com.clyao.securityjwt.service.impl.UserDetailsServiceImpl;
import com.clyao.securityjwt.utils.JwtTokenUtil;
import com.clyao.securityjwt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户登录")
public class UserLoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录后返回token")
    public Result login(@RequestParam(value = "username",required = true) String username, @RequestParam(value = "password",required = true) String password){
        //验证用户名
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //验证用户名和密码是否一致
        if(null == userDetails || !passwordEncoder.matches(password, passwordEncoder.encode(userDetails.getPassword()))){
            return ResultUtil.error("用户名或密码不正确");
        }
        //验证账号是否被禁用
        if(!userDetails.isEnabled()){
            return ResultUtil.error("账号被禁用，请联系管理员！");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //获取token并返回给前端
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        //返回登录结果
        return ResultUtil.success("登录成功", tokenMap);
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation(value = "退出登录")
    public Result logout(){
        return ResultUtil.success("注销成功！");
    }

    /**
     * 获取当前用户信息
     * @param principal
     * @return
     */
    @GetMapping("/user/info")
    @ApiOperation(value = "获取当前登录用户的信息")
    public User getUserInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        User userEntity = new User();
        return userEntity;
    }


}
