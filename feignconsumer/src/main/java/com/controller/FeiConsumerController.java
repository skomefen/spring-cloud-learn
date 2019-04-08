package com.controller;

import com.service.FeignConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeiConsumerController {

    @Autowired
    FeignConsumerService consumerService;

    @RequestMapping("feign-consumer")
    public String feignConsumer() {
        String s =consumerService.hello();
        return "feign consumer call finished!!! "+s;
    }

}