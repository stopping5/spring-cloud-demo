package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description GatewayApplication9501
 * @Author stopping
 * @date: 2021/4/18 23:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayApplication9501 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9501.class,args);
    }
}
