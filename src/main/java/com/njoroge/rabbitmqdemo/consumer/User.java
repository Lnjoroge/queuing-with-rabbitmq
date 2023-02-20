package com.njoroge.rabbitmqdemo.consumer;

import com.njoroge.rabbitmqdemo.config.MessagingConfig;
import com.njoroge.rabbitmqdemo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue : "+orderStatus);


    }
}
