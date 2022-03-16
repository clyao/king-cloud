package com.clyao.kingrabbitmqservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send/queue/{msg}")
    public String sendQueueMsg(@PathVariable("msg") String msg){
        rabbitTemplate.convertAndSend("king.queue", msg);
        return msg;
    }

    @GetMapping("/send/direct/{msg}")
    public String sendDirectMsg(@PathVariable("msg") String msg){
        rabbitTemplate.convertAndSend("king.directExchange","king.direct", msg);
        return msg;
    }

    @GetMapping("/send/topic/{msg}")
    public String sendTopicMsg(@PathVariable("msg") String msg){
        rabbitTemplate.convertAndSend("king.topicExchange","king.topic", msg);
        return msg;
    }

}
