package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SeeTimeController {

     Logger logger = LoggerFactory.getLogger(SeeTimeController.class);

     @Autowired
     DiscoveryClient discoveryClient;

     @RequestMapping("/time")
     public String getTime(){

          ServiceInstance instance = discoveryClient.getLocalServiceInstance();

          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          String time = df.format(new Date());
          String s = "time:"+time+" serviceId:"+instance.getServiceId();
          logger.info(s);

          return s+":"+instance.getPort();
     }
}
