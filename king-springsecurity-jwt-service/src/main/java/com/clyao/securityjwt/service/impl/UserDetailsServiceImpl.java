package com.clyao.securityjwt.service.impl;

import com.clyao.securityjwt.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 重新用户验证方法
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里是模拟数据，可以查询数据库进行用户名验证

        User userEntity = new User();
        userEntity.setId(1);
        userEntity.setUsername("king");
        userEntity.setPassword("123456");
        userEntity.setAge(20);
        if(userEntity.getUsername().equals(username)){
            return userEntity;
        }
        return null;
    }
}
