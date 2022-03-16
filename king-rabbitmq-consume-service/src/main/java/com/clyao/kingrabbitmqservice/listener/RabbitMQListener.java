package com.clyao.kingrabbitmqservice.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "king.queue")
    public void receive1(String message) {
        System.out.println("queue msg:" +message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "king.direct"),
            exchange = @Exchange(value = "king.directExchange", type = ExchangeTypes.DIRECT),
            key = "king.direct"
    ))
    public void receive2(String message) {
        System.out.println("direct msg:" +message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "king.topic"),
            exchange = @Exchange(value = "king.topicExchange", type = ExchangeTypes.TOPIC),
            key = "king.topic"
    ))
    public void receive3(String message) {
        System.out.println("topic msg:" +message);
    }

}
