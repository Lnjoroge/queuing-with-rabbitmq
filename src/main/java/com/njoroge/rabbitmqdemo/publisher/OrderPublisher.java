/*package com.njoroge.rabbitmqdemo.publisher;*/


import com.njoroge.rabbitmqdemo.config.MessagingConfig;
import com.njoroge.rabbitmqdemo.dto.Order;
import com.njoroge.rabbitmqdemo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")

public class OrderPublisher {


    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus=new OrderStatus(order, "PROCESS","order placed successfully in "+restaurantName);
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);
        return "Success!!";
    }
}
