package com.clyao.kingrabbitmqservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KingRabbitMQProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingRabbitMQProducerServiceApplication.class, args);
    }

}
