package com.example.rabbitmq.rabbitmq.producer;

import com.example.rabbitmq.rabbitmq.ConfigureRabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String themessage){
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME, "mica.springmessage", themessage);
        return "We have a sent message! : " + themessage;

    }
}
