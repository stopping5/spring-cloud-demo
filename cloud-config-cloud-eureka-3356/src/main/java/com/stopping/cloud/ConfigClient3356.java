package com.stopping.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description ConfigClient3355
 * @Author stopping
 * @date: 2021/4/19 17:34
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigClient3356 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3356.class,args);
    }
}
