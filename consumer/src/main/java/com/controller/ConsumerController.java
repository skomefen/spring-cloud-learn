package com.controller;

import com.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    //RestTemplate restTemplate;
    ConsumerService service;

    @RequestMapping("/consumer")
    public String helloConsumer() {
        //调用see-time service服务，注意这里用的是服务名，而不是具体的ip+port
        //Object o = restTemplate.getForObject("http://see-time/time", String.class);
        //return "hello consumer finish !!!"+o.toString();
        return service.consumer();
    }
}
