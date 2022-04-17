package com.clyao.securityjwt.service.impl;

import com.clyao.securityjwt.pojo.Role;
import com.clyao.securityjwt.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("普通用户");
        role.setRoleKey("role1");
        roleList.add(role);

        User user = new User();
        user.setId(1);
        user.setUsername("king");
        user.setPassword("123456");
        user.setAge(20);
        user.setRoles(roleList);
        if(user.getUsername().equals(username)){
            return user;
        }
        return null;
    }
}
