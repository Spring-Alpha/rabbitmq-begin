package com.example.rabbitmq.controller;

import com.example.rabbitmq.producer.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public MessageController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQSender.send(message);
        return "Message sent!";
    }
}

