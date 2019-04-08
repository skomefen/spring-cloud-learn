package com.controller;

import com.entity.User;
import com.service.FeignConsumerService;
import com.service.FeignConsumerService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeiConsumerController2 {

    @Autowired
    FeignConsumerService2 consumerService;

    @RequestMapping("feign-consumer2")
    public String feignConsumer() {
        consumerService.hello();
        return "feign consumer call finished!!!";
    }

    @RequestMapping("feign-consumer-user")
    public User feignConsumer2(User user) {
        consumerService.hello2();
        return consumerService.printUser(user);
    }
}
