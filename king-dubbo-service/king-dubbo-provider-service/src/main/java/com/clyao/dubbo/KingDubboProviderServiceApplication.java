package com.clyao.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class KingDubboProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingDubboProviderServiceApplication.class, args);
    }
}
