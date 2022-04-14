package com.clyao.mybatisplustest;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.clyao.mybatisplustest.entity.User;
import com.clyao.mybatisplustest.mapper.UserMapper;
import com.clyao.mybatisplustest.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
@Slf4j
class KingMybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test1(){
        User u = new User();
        u.setName("Tomcat");
        u.setAge(18);
        u.setEmail("kellylake@qq.com");
        userMapper.insert(u);
    }

    @Test
    public void test2(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test", "root", "123456")
                //全局配置
                .globalConfig(builder -> {
                    builder.author("clyao")
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")//输出路径
                            .disableOpenDir();//不打开文件夹
                })
                //包名配置
                .packageConfig(builder -> {
                    builder.parent("com.clyao")
                            .moduleName("mybatisplustest")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .entity("entity")
                            .mapper("mapper")
                            //自定义输出路径，mapper.xml生成到resources目录下
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"));
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("student")
                            .addTablePrefix("t_")//表前缀
                            .serviceBuilder().formatServiceFileName("%sService")//去掉Service的 "I" 前缀
                            .controllerBuilder().enableRestStyle()//restful开启
                            .enableHyphenStyle()//url改变 例如：index_id_1
                            .entityBuilder();
                })
                //执行
                .execute();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test4() throws JsonProcessingException {
        User user = new User();
        user.setAge(11);
        user.setName("king");
        String s = objectMapper.writeValueAsString(user);
        System.out.println("s:" + s);
    }

}
