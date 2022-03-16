package com.clyao.kingrabbitmqservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue1(){
        return new Queue("king.queue");
    }

    @Bean
    public Queue queue2(){
        return new Queue("king.direct");
    }

    @Bean
    public Queue queue3(){
        return new Queue("king.topic");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("king.directExchange");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("king.topicExchange");
    }

    @Bean
    public Binding bindingDirect(DirectExchange directExchange, Queue queue2){
        return BindingBuilder.bind(queue2).to(directExchange).with("king.direct");
    }

    @Bean
    public Binding bindingTopic(TopicExchange topicExchange, Queue queue3){
        return BindingBuilder.bind(queue3).to(topicExchange).with("king.topic");
    }

}
