package com.clyao.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KingRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingRedisApplication.class, args);
    }

}
