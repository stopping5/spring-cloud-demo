package com.stopping.clou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description StreamRb8801
 * @Author stopping
 * @date: 2021/4/20 16:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class StreamRb8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRb8801.class,args);
    }
}
