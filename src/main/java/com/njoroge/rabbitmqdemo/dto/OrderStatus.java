package com.njoroge.rabbitmqdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class OrderStatus {

    private Order order;
    private String status;
    private String message;

}
