package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Scanner;

/***
 *
 * @EnableDiscoveryClient
 * 让服务使用eureka服务器
 * 实现服务注册和发现
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SeeTimeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(SeeTimeApp.class)
                .properties("server.port=" + port).run(args);
    }
/*
    public static void main(String[] args) {

        SpringApplication.run(SeeTimeApp.class, args);
    }
*/
}
