package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description OrderConsumerApplication9003
 * @Author stopping
 * @date: 2021/4/22 15:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApplication9003.class,args);
    }
}
