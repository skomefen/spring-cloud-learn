package com.controller;

import com.entity.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements UserService {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String hello() throws Exception {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        //打印服务的服务id
        logger.info("*********" + instance.getServiceId());
        return "hello,this is hello-service  "+instance.getPort();
    }

    @Override
    public String hello2() {
        return "hello,this is hello2-service";
    }

    @Override
    public User printUser(@RequestBody User user) {
        return user;
    }

}
