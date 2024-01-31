package com.dunshan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 这是订单服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }
}