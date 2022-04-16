package com.clyao.securityjwt.controller;

import com.clyao.securityjwt.pojo.User;
import com.clyao.securityjwt.pojo.Result;
import com.clyao.securityjwt.pojo.UserEntity;
import com.clyao.securityjwt.utils.JwtTokenUtil;
import com.clyao.securityjwt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户登录")
public class UserLoginController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 用户登录
     * @param request
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录后返回token")
    public Result login(HttpServletRequest request, @RequestBody User user){
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        if(null == userDetails || !passwordEncoder.matches(user.getPassword(), passwordEncoder.encode(userDetails.getPassword()))){
            return ResultUtil.error("用户名或密码不正确");
        }

        if(!userDetails.isEnabled()){
            return ResultUtil.error("账号被禁用，请联系管理员！");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);

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
    public UserEntity getUserInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        UserEntity userEntity = new UserEntity();
        return userEntity;
    }


}
