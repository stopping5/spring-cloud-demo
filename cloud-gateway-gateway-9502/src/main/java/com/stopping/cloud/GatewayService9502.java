package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description GatewayService9502
 * @Author stopping
 * @date: 2021/4/19 10:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayService9502 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayService9502.class,args);
    }
}
