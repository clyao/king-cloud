package com.clyao.securityjwt.config;

import com.clyao.securityjwt.pojo.Menu;
import com.clyao.securityjwt.pojo.Role;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析请求所需的角色
 */
@Component
public class RestfulUrlFiter implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求url
        String requestUrl = ((FilterInvocation)object).getRequestUrl();

        List<Role> roleList1 = new ArrayList<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setRoleName("普通用户");
        role1.setRoleKey("role1");
        roleList1.add(role1);

        List<Role> roleList2 = new ArrayList<>();
        Role role2 = new Role();
        role2.setRoleId(2);
        role2.setRoleName("普通用户");
        role2.setRoleKey("role2");
        roleList2.add(role2);

        List<Menu> menuList = new ArrayList<>();
        Menu menu1 = new Menu();
        menu1.setMenuId(1);
        menu1.setMenuName("菜单1");
        menu1.setPath("/login");
        menu1.setPerms("role1");
        menu1.setRoles(roleList1);

        Menu menu2 = new Menu();
        menu2.setMenuId(2);
        menu2.setMenuName("菜单2");
        menu2.setPath("/test");
        menu2.setPerms("role2");
        menu2.setRoles(roleList2);

        menuList.add(menu1);
        menuList.add(menu2);
        for (Menu menu: menuList){
            //判断请求url与菜单角色是否匹配
            if(menu.getPath().equals(requestUrl)){
                String[] roles = menu.getRoles().stream().map(Role::getRoleKey).toArray(String[]::new);
                return SecurityConfig.createList(roles);

            }
        }
        //没有匹配url默认role1即可访问
        return SecurityConfig.createList("role1");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
