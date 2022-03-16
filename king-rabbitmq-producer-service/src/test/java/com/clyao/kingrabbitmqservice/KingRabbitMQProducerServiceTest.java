package com.clyao.kingrabbitmqservice;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KingRabbitMQProducerServiceTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1(){
        rabbitTemplate.convertAndSend("", "king.queue","First message in spring boot");
        //rabbitTemplate.convertAndSend("xxxxxx");
    }

}
