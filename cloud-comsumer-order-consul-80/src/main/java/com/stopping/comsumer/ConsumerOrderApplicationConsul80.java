package com.stopping.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description ComsumerOrderApplication
 * @Author stopping
 * @date: 2021/4/15 12:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderApplicationConsul80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplicationConsul80.class,args);
    }
}
